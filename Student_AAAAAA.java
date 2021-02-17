// Student_usnews.java: sample implementation for Student
// COS 445 HW1, Spring 2018
// Created by Andrew Wonnacott

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Student_AAAAAA implements Student {
    public int[] getApplications(
            int N,
            double S,
            double T,
            double W,
            double aptitude,
            List<Double> schools,
            List<Double> synergies) {
        // Maps score to university index
        Map<Double, Integer> happiness_map = new HashMap<Double, Integer>();
        PriorityQueue<Double> happiness_rank = new PriorityQueue<Double>();
        Map<Double, Integer> score_map = new HashMap<Double, Integer>();
        // Ranks scores
        PriorityQueue<Double> score_rank = new PriorityQueue<Double>();
        double[] happiness_scores = new double[schools.size()];

        for (int i = 0; i < schools.size(); i++) {
            // Compute your ranking scores for each university
            double happiness_by_obtaining = schools.get(i) + synergies.get(i);
            happiness_map.put(-1 * happiness_by_obtaining, i);
            happiness_rank.add(-1 * happiness_by_obtaining);
        }
        for (int i = 0; i < schools.size(); i++) {
            // Compute a discrete score for each university by position in preferences list
            double happiness_score = happiness_rank.remove();
            int index = happiness_map.get(happiness_score);
            happiness_scores[index] = 2 - 2 * (double) i / schools.size();
        }

        for (int i = 0; i < schools.size(); i++) {
            double chance_to_obtain = schools.get(i) / T + 4 * synergies.get(i) / (W);
            // If your aptitude is lower, you need to apply to universities you have a better chance of obtaining.
            double total_score = chance_to_obtain + 2 * Math.pow(aptitude / S + 0.3, 2) * happiness_scores[i];
            score_map.put(-1 * total_score, i);
            score_rank.add(-1 * total_score);
        }
        int[] selected_unis = new int[10];
        for (int i = 0; i < 10; i++) {
            double key = score_rank.remove();
            selected_unis[i] = score_map.get(key);
        }
        return selected_unis;
    }
}
