package vip.wulang.algorithm.sort;

public class InsertionSort implements Sort {
    @Override
    public void sort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (arr[j] > arr[j + 1]) {
                    SortUtil.swap(arr, j, j + 1);
                    j--;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        SortUtil.start(new InsertionSort(), 500000, 50000);
    }
}
