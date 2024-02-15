package me.iksadnorth;

/**
 * 배열의 모든 요소를 힙 정렬 시킨 후, 차례차례 Pop 시켜서 정렬.<br>
 */
public class HeapSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] array) {
        int length = array.length;

        // 기존 배열을 최대 힙으로 정렬.
        for (int i = length/2-1; i >= 0; i--) {
            heapify(array, length, i);
        }

        // 배열 끝부터 시작해서 루트 노드와 Swap
        for (int i = length-1; i > 0; i--) {
            SortUtil.swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    protected void heapify(Integer[] array, int length, int targetIdx) {
        int argMax = targetIdx;
        int nodeLeft = 2*targetIdx + 1;
        int nodeRight = 2*targetIdx + 2;

        // 자식 노드와 비교해서 최댓값 찾기.
        if (nodeLeft < length && array[argMax] < array[nodeLeft]) argMax = nodeLeft;
        if (nodeRight < length && array[argMax] < array[nodeRight]) argMax = nodeRight;

        if (argMax == targetIdx) return;

        // 만약 정렬된 것이 아니었다면 정렬을 진행하고
        // 서브 트리까지 힙정렬 시도.
        SortUtil.swap(array, targetIdx, argMax);
        heapify(array, length, argMax);
    }
}
