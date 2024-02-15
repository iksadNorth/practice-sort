package me.iksadnorth;

/**
 * 앞 요소들을 1개씩 정렬해나가며 새로 정렬할 요소가 위치할 위치를 찾아가는 정렬.<br>
 * 약간 카드뭉치를 손에 들고 있을 때, 정렬하는 알고리즘이라고 봐도 무방하다.<br>
 */
public class InsertionSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] array) {
        int length = array.length;

        for (int i = 1; i < length; i++) {
            // target 설정. 원래 target 자리는 빈칸으로 둬도 됨.
            Integer target = array[i];
            array[i] = null;

            // 만약 target과 비교했을때, 크다면 빈칸으로 밀어넣기.
            int j;
            for (j = i; j > 0; j--) {
                if (target > array[j-1]) break;
                SortUtil.swap(array, j-1, j);
            }

            // 빈칸에 원래 target을 집어넣기.
            array[j] = target;
        }
    }
}
