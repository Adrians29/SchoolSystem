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
    private List<Double> finalScores;

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
        return sum <= 100;
    }

    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }
        registeredStudents.add(student);

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }

        finalScores.add(null);

        student.getRegisteredCourses().add(this);
        return true;
    }
}