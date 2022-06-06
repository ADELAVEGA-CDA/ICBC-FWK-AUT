package driversManager.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FileUtilities {
    private static final Logger logger = LogManager.getLogger(String.valueOf(FileUtilities.class));

    public static void writeToFile(String filePath, String text) {
        try {
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(text);
            myWriter.close();
            logger.info("String saved to '" + filePath + "' file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeFile(String filePath) {
        File file = new File(filePath);
        try {
            Files.deleteIfExists(file.toPath());
            logger.info("File '" + filePath + "' deleted");
        } catch (IOException e) {
            logger.warn("File '" + filePath + "' not found");
        }
    }

    public static String readFile(String filePath) throws IOException {
        logger.info("Reading contents of '" + filePath + "' file");
        return Files.readString(Paths.get(filePath), StandardCharsets.US_ASCII);
    }

    public static String[][] readCsvFile(String filePath) throws IOException {
        logger.info("Reading contents of '" + filePath + "' csv file");
        String[][] csvContent = new String[0][];

        File file = new File(filePath);
        if (!file.exists()) {
            logger.info("File doesn't exists");
            return csvContent;
        }

        BufferedReader bufRdr;
        bufRdr = new BufferedReader(new FileReader(file));

        String line = null;
        int row = 0;

        while ((line = bufRdr.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, ",");
            int col = 0;
            while (st.hasMoreTokens()) {
                csvContent[row][col] = st.nextToken();
                col++;
            }
            row++;
        }

        bufRdr.close();
        return csvContent;
    }

    public static void updateFile(String filePath, String text) {
        removeFile(filePath);
        writeToFile(filePath, text);
    }

    public HashMap<String, String> parseStringXML(InputStream file) throws Exception {
        HashMap<String, String> stringMap = new HashMap<String, String>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();

        Element root = document.getDocumentElement();
        NodeList nList = document.getElementsByTagName("string");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                stringMap.put(eElement.getAttribute("name"), eElement.getTextContent());
            }
        }
        return stringMap;
    }
}
