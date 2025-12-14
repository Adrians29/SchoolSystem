package org.adrianegl;

import lombok.*;
import util.Util;
import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class Course {
    private String courseId;
    @Setter private String courseName;
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;
    private List<Double> finalScores;

    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseId = "C-" + department.getDepartmentId() + "-" +
                String.format("%02d", nextId++);
        this.courseName = Util.toTitleCase(courseName.trim());
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }

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

    /**
     * It registers a student in the course
     * @param student the student that is going to register
     * @return if the student was register
     */
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

    /**
     * Calculates the weighted average score of a student
     * @return the weighted average score of a student
     */
    public int[] calcStudentsAverage() {
        int size = registeredStudents.size();
        int[] results = new int[size];

        for (int i = 0; i < size; i++) {
            double sum = 0;
            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);

                if (score != null) {
                    sum += score * assignment.getWeight() / 100.0;
                }
            }

            results[i] = (int) Math.round(sum);
            finalScores.set(i, sum);
        }

        return results;
    }

    /**
     * Adds a new assignment to the course
     * @param assignmentName the name of the assignment
     * @param weight the weight of the assignment
     * @return always return true
     */
    public boolean addAssignment(String assignmentName, double weight) {
        Assignment assignment = new Assignment(assignmentName, weight);
        assignments.add(assignment);

        for (int i = 0; i < registeredStudents.size(); i++) {
            assignment.getScores().add(null);
        }
        return true;

    }

    /**
     * generates random scores for each assignment and student,
     * and calculates the final score for each student.
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
                assignment.generateRandomScore();
        }
        calcStudentsAverage();
    }

    /**
     * displays the scores of a course in a table, with the assignment averages
     * and student weighted average
     */
    public void displayScores() {
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
        System.out.printf("%-25s", "");

        for (String assignmentName : assignmentNames) {
            System.out.printf("%-15s", assignmentName);
        }
         System.out.printf("%-15s%n", "Final Score");

        for (int i = 0; i < studentNames.length; i++) {
            System.out.printf("%-25s", studentNames[i]);

            for (int j = 0; j < assignmentNames.length; j++) {
                System.out.printf("%-15d", assignments.get(j).getScores().get(i));
            }

            System.out.printf("%-15.0f\n", finalScores.get(i));
        }

        System.out.printf("%-25s", "Average");

        for (Assignment assignment : assignments) {
            System.out.printf("%-15.0f", assignment.calcAssignmentAvg());
        }
        System.out.println();
    }

    public String toSimplifiedString() {
        return "courseId=" + courseId +
                ", courseName=" + courseName +
                ", departmentName=" + department.getDepartmentName() +
                '}';
    }

    @Override
    public String toString() {
        return toSimplifiedString() +
                ", assignments=" + assignments +
                ", registeredStudents=" + registeredStudents +
                ", isAssignmentWeightValid=" + isAssignmentWeightValid() +
                '}';
    }
}