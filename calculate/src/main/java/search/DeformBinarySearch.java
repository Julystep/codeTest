package calculate.src.main.java.search;


/**
 * 二分查找的变形
 * 循环有序数组的查找
 */
public class DeformBinarySearch {

    // 重复数组中查找第个匹配的数据
    public static boolean search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int head = 0;
        int tail = arr.length - 1;
        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (arr[mid] == target) {
                if (mid != 0 && arr[mid-1] == arr[mid]) {
                    tail = mid - 1;
                } else {
                    System.out.println(mid);
                    return true;
                }
            } else if (arr[mid] < target){
                head = mid + 1;
            } else if (arr[mid] > target) {
                tail = mid - 1;
            }
        }
        return false;
    }

    public static int searchFirstBeautiful(int[] arr, int n, int value) {
        if (n <= 0) return -1;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low < n && arr[low] == value) return low;
        else return -1;
    }

    public static int searchLastBeautiful(int[] arr, int n, int value) {
        if (n <= 0) return -1;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (high >= 0 && arr[high] == value) return high;
        else return -1;
    }

    public static int searchWhileBeautiful(int[] arr, int n, int value) {
        if (n <= 0) return -1;
        if (arr[0] == value) return 0;
        if (arr[n] == value) return n;
        int low = 0, high = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == value) return mid;
            if (arr[low] > arr[mid]) {
                if (arr[mid] < value && arr[high] >= value) low = mid + 1;
                else high = mid - 1;
            } else {
                if (arr[low] <= value && arr[mid] > value) high = mid - 1;
                else low = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(DeformBinarySearch.search(arr, 2));
        System.out.println(DeformBinarySearch.searchFirstBeautiful(arr, arr.length-1, 2));
        System.out.println(DeformBinarySearch.searchLastBeautiful(arr, arr.length-1, 2));

        int[] arr1 = new int[]{6, 7, 8, 9, 10, 11, 1, 2, 3, 4, 5};
        System.out.println(DeformBinarySearch.searchWhileBeautiful(arr1, arr1.length-1, 9));

    }

}
