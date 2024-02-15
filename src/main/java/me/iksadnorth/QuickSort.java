package me.iksadnorth;

/**
 * 배열을 반으로 쪼개가며, 정렬하는 방법.<br>
 * 대상 배열 중 1개의 요소를 기준으로 해당 요소보다 크면 오른쪽, 작으면 왼쪽으로 swap한다.<br>
 */
public class QuickSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] array) {
        // target 설정.
        int target = 0;
        int idxEnd = array.length - 1;

        // 피벗팅 수행.
        sort(array, target, idxEnd);
    }

    protected void sort(Integer[] array, int idxStart, int idxEnd) {
        // 만약 정렬할 요소 갯수가 1개면, break
        if (idxStart >= idxEnd) return;

        // 피벗팅 수행.
        int idxPivot = partition(array, idxStart, idxEnd);

        // target 기준 이하 배열 정렬.
        sort(array, idxStart, idxPivot-1);

        // target 기준 이상 배열 정렬.
        sort(array, idxPivot+1, idxEnd);
    }

    protected int partition(Integer[] array, int idxStart, int idxEnd) {
        // 첫 번째 요소를 기준으로 삼음.
        int target = idxStart;
        idxStart++;

        // 루프를 돌면서 모든 요소들이 기준과 대소비교 후 swap
        while (idxStart <= idxEnd) {
            boolean isNormalOnLeft = array[idxStart] < array[target];
            boolean isNormalOnRight = array[target] <= array[idxEnd];

            // 기준에 맞지 않는 것끼리 Swap 하기
            if (!isNormalOnLeft && !isNormalOnRight) {
                SortUtil.swap(array, idxStart, idxEnd);
                idxStart++; idxEnd--;
            }

            // 기준에 맞지 않는 왼쪽 인덱스 찾기
            else if (isNormalOnLeft) {
                idxStart++;
            }

            // 기준에 맞지 않는 오른쪽 인덱스 찾기
            else if (isNormalOnRight) {
                idxEnd--;
            }
        }

        // 기준점과 End 커서 요소끼리 Swap
        SortUtil.swap(array, target, idxEnd);
        return idxEnd;
    }
}
