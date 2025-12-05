package org.adrianegl;

public class Address {
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public enum Province {
        AB, BC, MB, NB, NL, NS, ON, PE, QC, SK
    }

    /**
     * Checks if a postcode is valid or not
     * @param postalCode the postcode that is going to be used with a length of 6
     * @return if the postcode is valid or not
     */
    private static boolean isPostalCodeValid(String postalCode) {
        int len = postalCode.length();
        if (len != 6) {
            return false;
        }
        for (int i = 0; i < len; i += 2) {
            char letter = postalCode.charAt(i);
            char digit = postalCode.charAt(i + 1);
            if (!Character.isLetter(letter) || !Character.isUpperCase(letter)) {
                return false;
            }
            else if (!Character.isDigit(digit)) {
                return false;
            }
        }
        return true;
    }
}
