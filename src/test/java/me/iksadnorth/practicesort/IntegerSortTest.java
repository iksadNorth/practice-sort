package me.iksadnorth.practicesort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Map;

@Slf4j
@SpringBootTest
public class IntegerSortTest {
    private final Map<String, Sort<Integer>> tableSort;

    @Autowired
    public IntegerSortTest(Map<String, Sort<Integer>> tableSort) {
        this.tableSort = tableSort;
    }

    void sortTest(Sort<Integer> method) {
        // given
        Integer[] array = {25, 1, 305, 21, 17, 94, 1042, 5};
        Integer[] answer = {1, 5, 17, 21, 25, 94, 305, 1042};

        // when
        method.sort(array);

        // then
        log.info(Arrays.toString(array));

        Assertions.assertArrayEquals(array, answer);
    }

    void estimateRunTime_sortTest(Sort<Integer> method) {
        // given
        Integer[] array = FixtureFactory.getArrayFixture(100000);
        int loops = 1;

        // when
        long start = System.currentTimeMillis();
        for (int i = 0; i < loops; i++) {
            method.sort(array);
        }
        long gap = System.currentTimeMillis() - start;

        // then
        String logMessage = String.format("소요 시간 : %d ms", gap);
        log.info(logMessage);
    }

    @Test
    void allSortTest() {
        tableSort.forEach((name, sort) -> {
            log.info(name);
            sortTest(sort);
            estimateRunTime_sortTest(sort);
        });
    }
}
