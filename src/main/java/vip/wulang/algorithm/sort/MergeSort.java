package vip.wulang.algorithm.sort;

public class MergeSort implements Sort {
    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int l, int r) {
        if (r - l <= 0) {
            return;
        }

        int mid = l + ((r - l) >> 1);
//        int mid = (r + l) >> 1;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        int[] arr1 = new int[r - l + 1];
        int i = 0;

        int x = l;
        int y = mid + 1;

        while (x <= mid && y <= r) {
            if (arr[x] > arr[y]) {
                arr1[i] = arr[y];
                i++;
                y++;
            } else {
                arr1[i] = arr[x];
                i++;
                x++;
            }
        }

        while (x <= mid) {
            arr1[i] = arr[x];
            i++;
            x++;
        }

        while (y <= r) {
            arr1[i] = arr[y];
            i++;
            y++;
        }

        i = 0;
        for (int j = l; j <= r; j++) {
            arr[j] = arr1[i];
            i++;
        }
    }

    public static void main(String[] args) {
        SortUtil.start(new MergeSort(), 1000000, 50000);
    }
}
