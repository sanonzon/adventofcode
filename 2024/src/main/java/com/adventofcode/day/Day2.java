package com.adventofcode.day;

import java.util.Arrays;
import java.util.List;

// https://adventofcode.com/2024/day/2
public class Day2 extends DayBase {

    @Override
    public void doit() {
        List<String> rows = readFile("day/2");
        System.out.println(calculate(rows));
    }

    public Integer calculate(List<String> rows) {

        int safeCount = 0;

        for (String row : rows) {

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
                int currentValue = Integer.parseInt(s);

                if (recentValue == null) {
                    recentValue = currentValue;
                    continue;
                } else {

                    increasing &= recentValue < currentValue;
                    decreasing &= recentValue > currentValue;

                    int diff = Math.subtractExact(recentValue, currentValue);

                    goodRow &= diff >= 1 || diff <= 3;
                    if (!goodRow) {
                        System.out.println(String.format("Fail: %d -> %d", recentValue, currentValue));
                    }

                    recentValue = currentValue;
                }
            }
            if (goodRow && (increasing || decreasing)) {
                safeCount++;
            }

        }

        return safeCount;
    }

}
