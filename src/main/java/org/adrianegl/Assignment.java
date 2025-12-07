package org.adrianegl;

import java.util.List;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private List<Integer> scores;

    private static int nextId = 1;

    /**
     * Calculates the avg score of the assignment
     * @return
     */
    public double calcAssignmentAvg() {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }

        return sum / scores.size();
    }
}
