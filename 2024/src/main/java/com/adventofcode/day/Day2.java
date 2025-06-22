package com.adventofcode.day;

import java.util.Arrays;
import java.util.List;

public class Day2 extends DayBase {

    @Override
    public void doit() {
        List<String> rows = readFile("day/2");
        System.out.println(calculate(rows));
    }

    public Integer calculate(List<String> rows) {
        return this.calculate(rows, false);
    }

    public Integer calculate(List<String> rows, boolean tolerateOneFail) {

        int safeCount = 0;

        for (String row : rows) {
            if (row.isBlank()) {
                System.out.println("Blank rad lol");
                continue;
            }

            boolean increasing = true;
            boolean decreasing = true;
            boolean goodRow = true;

            List<String> temp = Arrays.asList(row.split("\s+"));
            Integer recentValue = null;

            // Speed up if it's already gone to shit
            if (!increasing && !decreasing) {
                continue;
            }

            for (String s : temp) {

                if (recentValue == null) {
                    recentValue = Integer.parseInt(s);
                    continue;
                } else {
                    int currentValue = Integer.parseInt(s);
                    int diff = 0;

                    increasing &= recentValue < currentValue;
                    decreasing &= recentValue > currentValue;

                    diff = Math.abs(Math.subtractExact(recentValue, currentValue));
                    // System.out.println(String.format("(%d, %d) diff: %d", recentValue,
                    // currentValue, diff));

                    goodRow &= diff >= 1 && diff <= 3;
                    recentValue = currentValue;
                }
            }
            if (goodRow && (increasing || decreasing)) {
                // System.out.println(String.format("increasing: %s, decreasing: %s",
                // increasing, decreasing));
                // System.out.println();
                safeCount++;
            }

        }

        return safeCount;
    }

}
