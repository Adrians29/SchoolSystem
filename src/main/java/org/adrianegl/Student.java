package org.adrianegl;

import java.util.List;

public class Student {
    private String studentId;
    private Gender gender;
    private Address address;
    private Department department;
    private List<Course> registeredCourses;

    private static int nextId;

    public boolean registerCourse(Course course) {
        return true;
    }
}
