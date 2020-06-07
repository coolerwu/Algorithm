package vip.wulang.algorithm.sort;

public class QuickSort {
    public static void main(String[] args) {

    }

    private static void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int l, r, base;
        l = 0;
        r = nums.length - 1;
        base = nums[0];
        while (l <= r) {
            while (base <= nums[r] && l <= r) {
                --r;
            }

            if (l < r) {
                
            }
        }
    }
}
