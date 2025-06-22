package com.adventofcode.day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Day1 extends DayBase {
    public void doit() {

        List<String> lines = readFile(getResource("day/1"));
        List<Integer> first = new ArrayList<>(lines.size());
        List<Integer> second = new ArrayList<>(lines.size());

        for (String line : lines) {
            String[] doot = line.split("\s+"); // Split on all spaces

            int one = Integer.parseInt(doot[0]);
            int two = Integer.parseInt(doot[1]);
            first.add(one);
            second.add(two);
        }

        // diff(first, second);
        similarityScore(first, second);
    }

    private void diff(List<Integer> first, List<Integer> second) {
        Collections.sort(first);
        Collections.sort(second);

        int sum = 0;
        for (int i = 0; i < first.size(); i++) {
            sum += Math.abs(Math.subtractExact(first.get(i), second.get(i)));
        }

        System.out.println(sum);
    }

    private void similarityScore(List<Integer> first, List<Integer> second) {
        Collections.sort(first);
        Collections.sort(second);

        List<Integer> similarity = new ArrayList<>();
        for (Integer i : first) {
            long matchCount = second.stream().filter(p -> Objects.equals(p, i)).count();
            if (matchCount > 0) {
                similarity.add(i * (int) matchCount);
            }
        }

        int sum = similarity.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println(sum);

    }

}
