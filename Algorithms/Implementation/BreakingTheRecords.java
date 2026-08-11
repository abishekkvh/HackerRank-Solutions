/*
===========================================================
IMPLEMENTATION - BREAKING THE RECORDS - EASY
===========================================================

Problem:
Maria plays college basketball and wants to go pro. Each season she maintains a record of her play. She tabulates the number of times she breaks her season record for most points and least points in a game. Points scored in the first game establish her record for the season, and she begins counting from there.

Given the scores for a season, find and print the number of times she breaks her records for most and least points scored during the season.
*/

import java.util.*;

public class BreakingTheRecords {

    public static List<Integer> breakingRecords(List<Integer> scores) {
        if (scores == null || scores.isEmpty()) {
            return Arrays.asList(0, 0);
        }

        int minScore = scores.get(0);
        int maxScore = scores.get(0);
        int minCount = 0;
        int maxCount = 0;

        for (int i = 1; i < scores.size(); i++) {
            int currentScore = scores.get(i);
            if (currentScore < minScore) {
                minScore = currentScore;
                minCount++;
            } else if (currentScore > maxScore) {
                maxScore = currentScore;
                maxCount++;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(maxCount);
        result.add(minCount);
        return result;
    }

    public static void main(String[] args) {
        // Default data to run locally
        List<Integer> scores = Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1);
        
        System.out.println("Input scores: " + scores);
        List<Integer> result = breakingRecords(scores);
        System.out.println("Result (Max breaks, Min breaks): " + result.get(0) + " " + result.get(1));
    }
}
