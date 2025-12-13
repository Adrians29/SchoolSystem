package org.adrianegl;

import lombok.*;
import util.Util;

import java.util.List;

@Getter
public class Course {
    private String courseId;
    @Setter private String courseName;
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
            sum += assignment.getWeight();
        }
        return sum == 100;
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

    public int[] calcStudentsAverage() {
        int size = registeredStudents.size();
        int[] results = new int[size];

        for (int i = 0; i < size; i++) {
            double avg = 0;
            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);

                if (score != null) {
                    avg += score * assignment.getWeight() / 100.0;
                }
            }

            results[i] = (int) Math.round(avg);
        }

        return results;
    }

    public boolean addAssignment(String assignmentName, double weight) {
        Assignment newAssignment = new Assignment(assignmentName, weight);
        assignments.add(newAssignment);

        for (int i = 0; i < registeredStudents.size(); i++) {
            newAssignment.getScores().add(null);
        }
        return true;

    }

    public void generateScores() {
        for (Assignment assignment : assignments) {
            for (int i = 0; i < registeredStudents.size(); i++) {
                assignment.generateRandomScore(i);
            }
        }
        calcStudentsAverage();
    }

    void displayScores() {
        int sizeStudents = registeredStudents.size();
        int sizeAssignments = assignments.size();

        String[] studentNames = new String[sizeStudents];
        String[] assignmentNames = new String[sizeAssignments];

        for (int i = 0; i < sizeStudents; i++) {
            studentNames[i] = Util.toTitleCase(registeredStudents.get(i).getStudentName());
        }

        for (int i = 0; i < sizeAssignments; i++) {
            assignmentNames[i] = Util.toTitleCase(assignments.get(i).getAssignmentName());
        }

        System.out.printf("Course: %s (%s)\n", courseName, courseId);
        System.out.printf("%-30s", "");

        for (String assignmentName : assignmentNames) {
            System.out.printf("%-15s", assignmentName);
        }

        System.out.println("Final Score");

        for (int i = 0; i < studentNames.length; i++) {
            System.out.printf("%-30s", studentNames[i]);

            for (int j = 0; j < assignmentNames.length; j++) {
                System.out.printf("%-15d", assignments.get(j).getScores().get(i));
            }

            System.out.printf("%-15.0f\n", finalScores.get(i));
        }

        System.out.printf("%-30s", "Average");

        for (Assignment assignment : assignments) {
            System.out.printf("%-15.0f", assignment.calcAssignmentAvg());
        }
        System.out.println();
    }

}