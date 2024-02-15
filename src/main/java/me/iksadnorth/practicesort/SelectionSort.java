package me.iksadnorth.practicesort;

import org.springframework.stereotype.Component;

/**
 * 정렬되지 않은 요소들 중 최솟값 혹은 최댓값을 찾아서 Swap하는 정렬.<br>
 */
@Component
public class SelectionSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int argMin = i;
            for (int j = i; j < length; j++) {
                if (array[argMin] <= array[j]) continue;
                argMin = j;
            }
            SortUtil.swap(array, i, argMin);
        }
    }
}
