package tools;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Test
 *
 * @author xianxing
 * @since 2023/10/27
 **/

public class Test {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 1, 3};
        Arrays.sort(arr);
//        Arrays.sort(arr,  (a, b)-> b - a);
        System.out.println(Arrays.toString(arr));

    }
}
