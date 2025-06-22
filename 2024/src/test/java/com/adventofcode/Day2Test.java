package com.adventofcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import com.adventofcode.day.Day2;

public class Day2Test {

    // https://adventofcode.com/2024/day/2
    @Test
    public void part_1() {
        List<String> listOfTwo = List.of("7 6 4 2 1", "1 3 6 7 9");

        assertEquals(2, new Day2().calculate(listOfTwo));

        // 7 6 4 2 1
        // 1 2 7 8 9
        // 9 7 6 2 1
        // 1 3 2 4 5
        // 8 6 4 4 1
        // 1 3 6 7 9
        List<String> testList = List.of("7 6 4 2 1", "1 2 7 8 9", "9 7 6 2 1", "1 3 2 4 5", "8 6 4 4 1", "1 3 6 7 9");
        assertEquals(2, new Day2().calculate(testList));

    }

    // https://adventofcode.com/2024/day/2#part2
    @Test
    public void part_2() {
        // 7 6 4 2 1
        // 1 2 7 8 9
        // 9 7 6 2 1
        // 1 3 2 4 5
        // 8 6 4 4 1
        // 1 3 6 7 9
        List<String> testList = List.of("7 6 4 2 1", "1 2 7 8 9", "9 7 6 2 1", "1 3 2 4 5", "8 6 4 4 1", "1 3 6 7 9");
        assertEquals(4, new Day2().calculate(testList, true));

    }
}
