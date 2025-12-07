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

    private static int nextId;

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
