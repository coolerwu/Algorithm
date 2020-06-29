package vip.wulang.algorithm.sort;

import vip.wulang.util.UnMatchedException;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class SortUtil {
    private SortUtil() {
    }

    private static final ForkJoinPool pool = new ForkJoinPool();

    private static class Task  {
    }

    public static void start(Object obj, int maxSize, int maxValue) {
        Method sort;
        try {
            sort = Sort.class.getDeclaredMethod("sort", int[].class);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        int[] array = genRandomArray(maxSize, maxValue);
        try {
            sort.invoke(obj, (Object) array);
        } catch (Exception e) {
            e.printStackTrace();
        }
        compare(array);
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void compare(int[] src) {
        int index = 0;
        int[] clone = src.clone();
        Arrays.sort(clone);
        for (;index < src.length; index++) {
            if (src[index] != clone[index]) {
                throw new UnMatchedException("index: " + index + " is unmatched");
            }
        }
        System.out.println("success!!!");
    }

    public static int[] genRandomArray(int maxSize, int maxValue) {
        // Math.random()   [0,1)
        // Math.random() * N  [0,N)
        // (int)(Math.random() * N)  [0, N-1]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // [-? , +?]
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
