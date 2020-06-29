package vip.wulang.algorithm.sort;

public class SelectionSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            SortUtil.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        SortUtil.start(new SelectionSort(),5000000, 5000000);
    }
}
