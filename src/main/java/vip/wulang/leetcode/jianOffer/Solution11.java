package vip.wulang.leetcode.jianOffer;

public class Solution11 {
    public static void main(String[] args) {
        System.out.println(
                new Solution().minArray(
                        new int[] {
                                3,4,5,1,2
                        }
                )
        );
        System.out.println(
                new Solution().minArray(
                        new int[] {
                                10,1,10,10,10
                        }
                )
        );
    }
}

class Solution {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }


        int l = 0, r = numbers.length - 1;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);

            if (numbers[mid] > numbers[l]) {
                l = mid;
            } else if (numbers[mid] < numbers[r]) {
                r = mid;
            }
        }

        return 1;
    }

    public int minArray1(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int l = 0, r = numbers.length - 1;

        while (numbers[l] >= numbers[r]) {
            int mid = l + ((r - l) >> 1);

            if (numbers[mid] == numbers[l] && numbers[l] == numbers[r]) {
                int min = numbers[l];
                for (int i = l; i <= r; i++) {
                    min = Math.min(numbers[i], min);
                }
                return min;
            }

            if (r - l <= 1) {
                l = numbers[r] > numbers[l] ? l : r;
                break;
            }

            if (numbers[mid] >= numbers[l]) {
                l = mid;
            } else if (numbers[mid] <= numbers[r]) {
                r = mid;
            }
        }

        return numbers[l];
    }
}