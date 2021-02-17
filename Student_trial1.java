// Student_usnews.java: sample implementation for Student
// COS 445 HW1, Spring 2018
// Created by Andrew Wonnacott

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Student_trial1 implements Student {
    public int[] getApplications(
            int N,
            double S,
            double T,
            double W,
            double aptitude,
            List<Double> schools,
            List<Double> synergies) {
        Map<Double, Integer> scores = new TreeMap<Double, Integer>();
        for (int i = 0; i < schools.size(); i++) {
            double chance_to_obtain = aptitude / S + synergies.get(i) / W;
            double happiness_by_obtaining = schools.get(i) / T + synergies.get(i) / W;
            scores.put(chance_to_obtain + happiness_by_obtaining, i);
        }

    }
}
