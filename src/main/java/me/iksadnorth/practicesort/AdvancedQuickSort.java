package me.iksadnorth.practicesort;

import org.springframework.stereotype.Component;

/**
 * 배열을 반으로 쪼개가며, 정렬하는 방법.<br>
 * 대상 배열 중 1개의 요소를 기준으로 해당 요소보다 크면 오른쪽, 작으면 왼쪽으로 swap한다.<br>
 * 해당 알고리즘은 피벗값을 어찌 설정하느냐에 따라 성능이 달라진다.
 */
@Component
public class AdvancedQuickSort extends QuickSort {
    @Override
    protected int partition(Integer[] array, int idxStart, int idxEnd) {
        // 중간값을 피벗으로 선택.
        int pivotIndex = (idxStart + idxEnd) / 2;
        int pivotValue = array[pivotIndex];

        // 피벗을 마지막으로 이동.
        SortUtil.swap(array, pivotIndex, idxEnd);

        // 피벗보다 작은 값들이 들어갈 인덱스입니다.
        int storeIndex = idxStart;

        for (int i = idxStart; i < idxEnd; i++) {
            if (array[i] < pivotValue) {
                SortUtil.swap(array, i, storeIndex);
                storeIndex++;
            }
        }

        // 피벗을 올바른 위치로 이동.
        SortUtil.swap(array, storeIndex, idxEnd);
        return storeIndex;
    }
}
