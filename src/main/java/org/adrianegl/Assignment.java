package org.adrianegl;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Assignment {
    private String assignmentId;
    @Setter private String assignmentName;
    private double weight;
    private List<Integer> scores;

    private static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentId = String.format("%02d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = Math.max(Math.min(100.0, weight), 0.0);
        this.scores = new ArrayList<>();
    }

    /**
     * Calculates the avg score of the assignment
     * @return the avg score
     */
    public double calcAssignmentAvg() {
        double sum = 0;
        if (scores.isEmpty()) {
            return sum;
        }
        for (double score : scores) {
            sum += score;
        }

        return sum / scores.size();
    }

    /**
     * generate a random score for scores list
     */
    private void generateRandomScore() {
        Random random = new Random();
        int randomNum = random.nextInt(0, 11);
        int randomScore = switch (randomNum) {
            case 0 -> random.nextInt(0, 60);
            case 1, 2 -> random.nextInt(60, 70);
            case 3, 4 -> random.nextInt(70, 80);
            case 5, 6, 7, 8 -> random.nextInt(80, 90);
            case 9, 10 -> random.nextInt(90, 101);
            default -> -1;
        };
        scores.add(randomScore);
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId=" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight='" + weight +
                '}';
    }
}
