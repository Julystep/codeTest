package calculate.src.main.java.sort;

/**
 * 分治算法
 * 有个有点，空间复杂O(nlogn)
 */
public class QuickSort {

    public static void quickAndSort(int[] arr, int n) {
        quick(arr, 0, n-1);
    }

    private static void quick(int[] arr, int head, int tail) {
        if (head >= tail) return;
        int q = partition(arr, head, tail);
        quick(arr, head, q - 1);
        quick(arr, q + 1, head);
    }

    private static int partition(int[] arr, int head, int tail) {
        int flag = arr[tail];
        while (head < tail) {
            while (head < tail && arr[head] < flag) {
                head++;
            }
            while (head < tail && arr[tail] > flag) {
                tail --;
            }
            int c = arr[head];
            arr[head] = arr[tail];
            arr[tail] = c;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 9, 4, 3, 1, 8, 7};
        QuickSort.quickAndSort(arr, arr.length);
        for (int item : arr) {
            System.out.println(item);
        }
    }

}
