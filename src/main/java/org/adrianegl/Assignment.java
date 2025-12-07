package org.adrianegl;

import java.util.List;
import java.util.Random;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private List<Integer> scores;

    private static int nextId = 1;

    /**
     * Calculates the avg score of the assignment
     * @return the avg score
     */
    public double calcAssignmentAvg() {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }

        return sum / scores.size();
    }

    private void generateRandomScore() {
        Random random = new Random();
        int randomNum = random.nextInt(0, 11);
        int randomScore = switch (randomNum) {
            case 0 -> random.nextInt(0, 61);
            case 1, 2 -> random.nextInt(60, 71);
            case 3, 4 -> random.nextInt(70, 81);
            case 5, 6, 7, 8 -> random.nextInt(80, 91);
            case 9, 10 -> random.nextInt(90, 101);
            default -> -1;
        };
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "weight=" + weight +
                ", assignmentName='" + assignmentName + '\'' +
                ", assignmentId='" + assignmentId + '\'' +
                '}';
    }
}
