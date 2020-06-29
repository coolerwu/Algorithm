package vip.wulang.algorithm.sort;

public class BubbleSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtil.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        SortUtil.start(new BubbleSort(),5000000, 5000000);
    }
}
