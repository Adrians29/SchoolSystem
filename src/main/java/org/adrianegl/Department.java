package org.adrianegl;

import lombok.*;
import util.Util;

@ToString
@EqualsAndHashCode
@Getter
public class Department {
    private String departmentId;
    @Setter private String departmentName;

    private static int nextId = 1;

    /**
     * Validates if a department name is valid or not, a department name should only contain letters or space
     * Constructor with only `departmentName` // if the `departmentName` is invalid,
     * create the object with everything as `null`
     */
    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentId = String.format("D%02d", nextId++);
            this.departmentName = Util.toTitleCase(departmentName);
        }
        else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    /**
     * checks if a department name is valid or not
     * @param departmentName name should only contain letters or space
     * @return if department name is valid or not
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }

        for (char c : departmentName.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;

    }
}
