package me.iksadnorth.practicesort;

import org.springframework.stereotype.Component;

/**
 * 배열을 반으로 쪼개가며, 1개짜리들로 조각낸 뒤, 다시 2개씩 합치면서 정렬하는 방법.<br>
 */
@Component
public class MergeSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] array) {
        // target 설정.
        int target = 0;
        int idxEnd = array.length - 1;

        // result Array 생성.
        Integer[] result = new Integer[array.length];

        // 정렬 수행.
        sort(array, result, target, idxEnd);
    }

    protected void sort(Integer[] array, Integer[] result, int idxStart, int idxEnd) {
        // 요소 갯수가 1개면 중지.
        if (idxStart >= idxEnd) return;

        // 반절로 나눠서 재귀적 정렬 호출.
        int idxMid = (idxStart + idxEnd) / 2;

        sort(array, result, idxStart, idxMid);
        sort(array, result, idxMid+1, idxEnd);

        // 병합 과정
        merge(array, result, idxStart, idxMid, idxEnd);
    }

    protected void merge(Integer[] array, Integer[] result, int idxStart, int idxMid, int idxEnd) {
        // 분할된 list 병합
        int firstCursor = idxStart;
        int secondCursor = idxMid+1;

        for (int i = idxStart; i <= idxEnd; i++) {
            boolean isFirstCursorOutOfRange = firstCursor > idxMid;
            boolean isSecondCursorOutOfRange = secondCursor > idxEnd;

            if (isFirstCursorOutOfRange) {
                result[i] = array[secondCursor++];
            } else if (isSecondCursorOutOfRange) {
                result[i] = array[firstCursor++];
            } else if (array[firstCursor] <= array[secondCursor]) {
                result[i] = array[firstCursor++];
            } else {
                result[i] = array[secondCursor++];
            }
        }

        // 임시 배열값을 기존 배열에 반영
        update(array, result, idxStart, idxEnd);
    }

    protected void update(Integer[] array, Integer[] result, int idxStart, int idxEnd) {
        for (int i = idxStart; i <= idxEnd; i++) {
            array[i] = result[i];
        }
    }
}
