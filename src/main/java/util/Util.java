package util;

public class Util {

    /**
     * Converts each word in a string to title case.
     * @param str the string that want to convert into title case
     * @return the string in title case
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isBlank()) {
            return str;
        }

        String[] words = str.trim().toLowerCase().split("\\s+");
        str = "";

        for (String word : words) {
            word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
            str += word;
        }
        str = str.trim();

        return str;

    }
}
