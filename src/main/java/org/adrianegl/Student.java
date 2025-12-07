package org.adrianegl;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private List<Course> registeredCourses;

    private static int nextId = 1;

    public enum Gender {
        MALE, FEMALE
    }

    public Student(String studentName, Gender gender, Address address, Department department, List<Course> registeredCourses) {
        this.studentId = String.format("S%06", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * adds a course to student's registeredCourses
     * if the student is not registered yet.
     * @param course the course that the student wants to register.
     * @return if the student is registered or not.
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
        else {
            registeredCourses.add(course);
        }
        return true;

    }

    /**
     * remove the course from the student's registeredCourses list
     * @param course the course that wants to remove
     * @return if the course was removed or not
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }
        else {
            registeredCourses.remove(course);
        }
        return true;

    }
}
