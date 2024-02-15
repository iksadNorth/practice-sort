import me.iksadnorth.SortUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SwapTest {
    @Test
    void swapTest_runNormally() {
        // given
        Integer[] array = {1, 2};
        Integer[] answer = {2, 1};

        // when
        SortUtil.swap(array, 0, 1);

        // then
        System.out.println(Arrays.toString(array));
        Assertions.assertArrayEquals(array, answer);
    }
    @Test
    void swapTest_runAbnormally() {
        // given
        Integer[] array = {1, 2};
        Integer[] answer = {1, 2};

        // when
        SortUtil.swap(array, 0, 1);

        // then
        System.out.println(Arrays.toString(array));
        Assertions.assertFalse(Arrays.equals(array, answer));
    }
}
