package calculate.src.main.java.search;

import java.math.BigDecimal;

/**
 * 简单的二分查找
 * 求一个数的算数平方根
 */
public class BinarySearch {

    public static boolean search(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return false;
        }
        int mid = 0;
        int head = 0;
        int tail = arr.length - 1;
        while (head <= tail) {
            mid = (head + tail) / 2;
            // 有一种防止数组长度过长而超出Integer最大数据量的情况 mid = head + (tail - head) / 2
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target){
                head = mid + 1;
            } else if (arr[mid] > target) {
                tail = mid - 1;
            }
        }
        return false;

    }

    /**
     * 递归实现
     * @param arr
     * @param target
     * @return
     */
    public static boolean searchRecursion(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return false;
        }
        return recursion(arr, 0, arr.length-1, target);

    }

    private static boolean recursion(int[] arr, int low, int high, int target) {
        if (low > high) return false;
        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return true;
        } else if (arr[mid] < target){
            return recursion(arr, mid + 1, high, target);
        } else  {
            return recursion(arr, low, mid - 1, target);
        }
    }

    private static BigDecimal square(BigDecimal target) {

        BigDecimal twoBits = new BigDecimal(2);
        while (target.scale() < 6) {
            BigDecimal decimal = target.divide(twoBits);
            if (decimal.multiply(decimal).equals(target)) {
                return decimal;
            } else if (decimal.multiply(decimal).compareTo(target) < 0) {
                target = decimal.multiply(target);
            } else {
                target = decimal;
            }
        }
        return target;

    }

    private static float calSort(float x) {
        float low = 0;
        float high = x;
        while (Math.abs(high - low) >= 0.000001) {
            float mid = (high + low) / 2;
            float mid2 = mid * mid;
            if (mid2 - x > 0.000001) {
                high = mid;
            } else if (x - mid2 > 0.000001) {
                low = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(BinarySearch.searchRecursion(arr, 11));

        System.out.println(BinarySearch.square(new BigDecimal(25)));
        System.out.println(BinarySearch.calSort(25));
    }

}
