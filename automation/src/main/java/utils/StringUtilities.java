package utils;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class StringUtilities {

    public static String rightPadZeros(String str, int num) {
        return String.format("%1$-" + num + "s", str).replace(' ', '0');
    }

    public static String getStringFirstWords(String string, int num) {
        String [] arr = string.split("\\s+");
        // splits words & assign to the arr[]  ex : arr[0] -> Copying ,arr[1] -> first

        StringBuilder nWords= new StringBuilder();

        // use array length if smaller than num
        if (arr.length < num) {
            num = arr.length;
        }

        // concatenating number of words that you required
        for(int i=0; i<num ; i++){
            if (i == 0) {
                nWords.append(arr[i]);
            } else {
                nWords.append(" ").append(arr[i]);
            }
        }
        return nWords.toString();
    }

    public static String getStringReplaceSpaces(String string) {
        return string.replaceAll("\\s","%20");
    }

    public static String getStringReplaceAccents(String string) {
        return StringUtils.stripAccents(string);
    }

    public static String getStringFromList(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            // Discard if null
            if (str == null) {
                continue;
            }
            // Add to string
            if (sb.toString().isEmpty()){
                sb.append(str);
            } else {
                sb.append(",").append(str);
            }
        }
        return sb.toString();
    }

    public static String getStringFromListFirstElements(List<String> list, int elementsAmount) {
        List<String> firstNElementsList = list.stream().limit(elementsAmount).collect(Collectors.toList());

        return getStringFromList(firstNElementsList);
    }
}
