/* eslint-disable */

const locators = JSON.parse(arguments[0])
const command = arguments[1]

if (!Array.isArray(locators) || !locators || !locators.length) {
  throw new Error(`Invalid locators: ${arguments[0]}`)
}

function findElementsByXpath(xpath) {
  const elements = []
  const nodes = document.evaluate(xpath, document, null, XPathResult.ORDERED_NODE_ITERATOR_TYPE, null)
  let node = null
  while (node = nodes.iterateNext()) {
    elements.push(node)
  }

  return elements
}

function getAbsoluteXPath(doc, domNode) {
  try {
    // If this isn't an element, we're above the root, return empty string
    if (!domNode.tagName || domNode.nodeType !== 1) {
      return ''
    }

    // Get the relative xpath of this node using tagName
    let xpath = `/${domNode.tagName.toLowerCase()}`

    // If this node has siblings of the same tagName, get the index of this node
    if (domNode.parentNode) {
      // Get the siblings
      const childNodes = Array.prototype.slice
          .call(domNode.parentNode.childNodes, 0)
          .filter((childNode) => (
              childNode.nodeType === 1 && childNode.tagName === domNode.tagName
          ))

      // If there's more than one sibling, append the index
      if (childNodes.length > 1) {
        let index = childNodes.indexOf(domNode)
        xpath += `[${index + 1}]`
      }
    }

    // Make a recursive call to this nodes parents and prepend it to this xpath
    return getAbsoluteXPath(doc, domNode.parentNode) + xpath
  }
  catch (ignored) {
    // If there's an unexpected exception, abort and don't get an XPath
    return null
  }
}

let element
for (const locator of locators) {
  const locatorValue = locator.value
  let foundElements = []
  switch (locator.type) {
    case 'id':
      foundElements = document.querySelectorAll(`[id='${locatorValue}']`)
      break
    case 'name':
      foundElements = document.getElementsByName(locatorValue)
      break
    case 'className':
      foundElements = document.getElementsByClassName(locatorValue)
      break
    case 'linkText':
      foundElements = findElementsByXpath(`//a[text()='${locatorValue}']`)
      break
    case 'css':
      foundElements = document.querySelectorAll(locatorValue)
      break
    case 'xpath':
      foundElements = findElementsByXpath(locatorValue)
      break
  }

  let visibleElements = []
  for (const foundElement of foundElements || []) {
    const elementVisible = !!(foundElement.offsetWidth || foundElement.offsetHeight || foundElement.getClientRects().length)
    if (elementVisible) visibleElements.push(foundElement)
  }

  if (visibleElements.length === 1) {
    element = visibleElements[0]
    break
  }
}

if (!element) {
  return null
}

switch (command) {
  case "findVisibleElement":
    return getAbsoluteXPath(document, element)
  case "scrollIntoView":
    const elementRect = element.getBoundingClientRect()
    const absoluteElementTop = elementRect.top + window.pageYOffset
    const middle = absoluteElementTop - (window.innerHeight / 2)
    window.scrollTo({
      top: middle,
      left: window.pageXOffset
    })

    return true
  case "getBoundingClientRect":
    const {devicePixelRatio} = window
    const rect = element.getBoundingClientRect()

    const result = {
      x: Math.round(rect.x * devicePixelRatio),
      y: Math.round(rect.y * devicePixelRatio),
      width: Math.round(rect.width * devicePixelRatio),
      height: Math.round(rect.height * devicePixelRatio),
      windowInnerHeight: Math.round(window.innerHeight * devicePixelRatio)
    }

    return JSON.stringify(result)
  default:
    throw new Error(`Unsupported command: ${command}`)
}
