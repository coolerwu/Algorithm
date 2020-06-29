package vip.wulang.algorithm.sort;

/**
 * 找到 >= value的最小索引
 */
public class BinaryLessThanFind implements Find {
    @Override
    public int find(int[] arr, int value) {
        int l = 0;
        int r = arr.length - 1;
        int index = -1;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] > value) {
                r = mid - 1;
            } else {
                index = mid;
                l = mid + 1;
            }
        }

        return index;
    }
}
