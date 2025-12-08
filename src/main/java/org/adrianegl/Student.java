package org.adrianegl;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
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
        this.studentId = String.format("S%06d", nextId++);
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
        registeredCourses.add(course);

        course.getRegisteredStudents().add(this);

        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().add(null);
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

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=" + registeredCourses +
                '}';
    }
}
