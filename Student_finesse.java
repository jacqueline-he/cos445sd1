// Student_usnews.java: sample implementation for Student
// COS 445 HW1, Spring 2018
// Created by Andrew Wonnacott

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Student_finesse implements Student {
    public int[] getApplications(
            int N,
            double S,
            double T,
            double W,
            double aptitude,
            List<Double> schools,
            List<Double> synergies) {
        // Maps score to university index
        Map<Double, Integer> score_map = new HashMap<Double, Integer>();
        // Ranks scores
        PriorityQueue<Double> score_rank = new PriorityQueue<Double>();
        for (int i = 0; i < schools.size(); i++) {
            double chance_to_obtain = aptitude / S + synergies.get(i) / W;
            double happiness_by_obtaining = schools.get(i) / T + synergies.get(i) / W;
            double total_score = chance_to_obtain + happiness_by_obtaining;
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
