import me.iksadnorth.BubbleSort;
import me.iksadnorth.InsertionSort;
import me.iksadnorth.SelectionSort;
import me.iksadnorth.Sort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class IntegerSortTest {

    void sortTest(Sort<Integer> method) {
        // given
        Integer[] array = {25, 1, 305, 21, 17, 94, 1042, 5};
        Integer[] answer = {1, 5, 17, 21, 25, 94, 305, 1042};

        // when
        method.sort(array);

        // then
        System.out.println(Arrays.toString(array));

        Assertions.assertArrayEquals(array, answer);
    }

    void estimateRunTime_sortTest(Sort<Integer> method) {
        // given
        Integer[] array = {25, 1, 305, 21, 17, 94, 1042, 5, 25, 1, 305, 21, 17, 94, 1042, 5, 25, 1, 305, 21, 17, 94, 1042, 5};
        int loops = 1000000;

        // when
        long start = System.currentTimeMillis();
        for (int i = 0; i < loops; i++) {
            method.sort(array);
        }
        long gap = System.currentTimeMillis() - start;

        // then
        String log = String.format("소요 시간 : %d ms", gap);
        System.out.println(log);
    }

    @Test
    void bubbleSortTest() {
        // given
        Sort<Integer> sort = new BubbleSort();

        // when & then
        sortTest(sort);
        estimateRunTime_sortTest(sort);
    }

    @Test
    void selectionSortTest() {
        // given
        Sort<Integer> sort = new SelectionSort();

        // when & then
        sortTest(sort);
        estimateRunTime_sortTest(sort);
    }

    @Test
    void insertionSortTest() {
        // given
        Sort<Integer> sort = new InsertionSort();

        // when & then
        sortTest(sort);
        estimateRunTime_sortTest(sort);
    }
}
