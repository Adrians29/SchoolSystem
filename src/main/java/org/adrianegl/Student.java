package org.adrianegl;

import lombok.*;
import util.Util;

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

    /**
     * Possible genders for student
     */
    public enum Gender {
        MALE, FEMALE
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = Util.toTitleCase(studentName);
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
        registeredCourses.remove(course);

        course.getRegisteredStudents().remove(this);

        for (Assignment assignment : course.getAssignments()) {
            if (!assignment.getScores().isEmpty()) {
                assignment.getScores().remove(assignment.getScores().size() - 1);
            }
        }
        return true;

    }

    public String toSimplifiedString() {
        return "Student{" +
                "studentId=" + studentId + '\'' +
                "studentName=" + studentName + '\'' +
                "department=" + department +
                '}';
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
