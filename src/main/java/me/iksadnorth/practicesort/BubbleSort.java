package me.iksadnorth.practicesort;

import org.springframework.stereotype.Component;

/**
 * 인접한 2개의 요소를 Swap 하면서 변경.<br>
 * 주의할 점은 1번 루프를 돌면 맨 마지막은 이미 최대값으로 결정되어 있기 때문에<br>
 * 1번 루프를 돌면 마지막 1개씩 제외시켜도 된다는 것이다.
 */
@Component
public class BubbleSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] array) {
        int length = array.length;

        for (int i = length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] <= array[j+1]) continue;
                SortUtil.swap(array, j, j+1);
            }
        }
    }
}
