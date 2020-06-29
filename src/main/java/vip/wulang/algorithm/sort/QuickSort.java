package vip.wulang.algorithm.sort;

public class QuickSort implements Sort {
    @Override
    public void sort(int[] arr) {
        process(arr, 0, arr.length - 1);
    }

    private void process(int[] arr, int l, int r) {
        if (r - l <= 0) {
            return;
        }

        int partition = partition(arr, l, r);
        process(arr, l, partition - 1);
        process(arr, partition + 1, r );
    }

    private int partition(int[] arr, int l, int r) {
        if (r < l) {
            return -1;
        }
        if (r == l) {
            return r;
        }
        int base = arr[r];
        int index = r;

        while (l <= r) {
            while (l <= r && arr[l] <= base) {
                l++;
            }

            if (l <= r && arr[l] > base) {
                SortUtil.swap(arr, l, index);
                index = l;
            }

            while (l <= r && arr[r] > base) {
                r--;
            }

            if (l <= r && arr[r] <= base) {
                SortUtil.swap(arr, index, r);
                index = r;
            }
        }

        arr[index] = base;
        return index;
    }

    public static void main(String[] args) {
        SortUtil.start(new QuickSort(),5000000, 500000);
    }

    private void process1(int[] arr, int l, int r) {
        if (r - l <= 0) {
            return;
        }

        int partition = partition1(arr, l, r);
        process1(arr, l, partition - 1);
        process1(arr, partition + 1, r);
    }

    private int partition1(int[] arr, int l, int r) {
        if (r < l) {
            return -1;
        }
        if (l == r) {
            return r;
        }
        int base = arr[r];
        int lessEqual = l - 1;

        for (int i = l; i < r; i++) {
            if (arr[i] <= base) {
                SortUtil.swap(arr, i, ++lessEqual);
            }
        }

        SortUtil.swap(arr, r, ++lessEqual);
        return lessEqual;
    }
}
