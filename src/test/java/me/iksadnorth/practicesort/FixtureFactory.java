package me.iksadnorth.practicesort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FixtureFactory {
    private static final Map<Integer, Integer[]> table = new HashMap<>();

    private FixtureFactory() {}

    public static Integer[] getArrayFixture(Integer length) {
        if (!table.containsKey(length)) {
            Integer[] fixture = makeArrayFixture(length);
            table.put(length, fixture);
        }
        Integer[] answer = table.get(length);
        return Arrays.copyOf(answer, answer.length);
    }

    private static Integer[] makeArrayFixture(Integer length) {
        Integer[] array = new Integer[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt();
        }

        return array;
    }
}
