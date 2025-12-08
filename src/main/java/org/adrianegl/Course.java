package org.adrianegl;

import lombok.*;

import java.util.List;

@Getter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;

    private static int nextId = 1;

    /**
     * checks if the sum of weights of all assignments of that course equals to 100
     * @return if the sum of weights equals to 100
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0;
        for (Assignment assignment : assignments) {
            double weight = assignment.getWeight();
            sum += weight;
        }
        if (sum != 100) {
            return false;
        }
        return true;
    }

    public boolean registerStudent(Student student) {

    }
}