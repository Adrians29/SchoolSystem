package org.adrianegl;

public class Department {
    private String departmentId;
    private String departmentName;

    private static int nextId = 1;

    private static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }

        for (int i = 0; i < departmentName.length(); i++) {
            char letter = departmentName.charAt(i);
            if (!Character.isLetter(letter)) {
                return false;
            }
            else if (!Character.isSpaceChar(letter)) {
                return false;
            }
        }
        return true;

    }
}
