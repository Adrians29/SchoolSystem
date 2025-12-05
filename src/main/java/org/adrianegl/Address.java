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
}
