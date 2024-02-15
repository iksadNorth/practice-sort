package me.iksadnorth.practicesort;

public class SortUtil {
    private SortUtil() {}

    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
