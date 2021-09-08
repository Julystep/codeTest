package calculate.src.main.java.sort;

/**
 * 分治排序
 * 归并排序最大的问题是要申请额外的空间，不能在本体上面进行排序
 */
public class MergeSort {

    public static void mergeAndSort(int[] a, int n) {
        int[] temp = new int[a.length];
        merge(a, 0, n - 1, temp);
    }

    public static void merge(int[] arr, int head, int tail, int[] temp) {

        if (head >= tail) return;
        int mid = (head + tail) / 2;
        // 分好了
        merge(arr, head, mid, temp);
        merge(arr, mid+1, tail, temp);
        // 分好了之后排序
//        sort(arr, head, mid, tail);
        sort(arr, head, mid, tail, temp);
    }

    /**
     * 我自己的邪路实现
     * @param arr
     * @param head
     * @param mid
     * @param tail
     */
    private static void sort(int[] arr, int head, int mid, int tail) {
        int[] first = new int[mid + 1  - head];
        int[] last = new int[tail  - mid];
        int j = 0;
        for (int i = head; i <= mid; i++) {
            first[j++] = arr[i];
        }
        j = 0;
        for (int i = mid + 1; i <= tail; i++) {
            last[j++] = arr[i];
        }
        int h = 0, t = 0, m = head;
        while (h < first.length && t < last.length) {
            if (first[h] <= last[t]) {
                arr[m++] = first[h];
                h++;
            } else {
                arr[m++] = last[t];
                t++;
            }
        }
        while (h < first.length) {
            arr[m++] = first[h];
            h++;
        }
        while (t < last.length) {
            arr[m++] = last[t];
            t++;
        }
    }

    /**
     * 正常写法
     * @param arr
     * @param head
     * @param mid
     * @param tail
     * @param temp
     */
    private static void sort(int[] arr, int head, int mid, int tail, int[] temp) {
        int h = head;
        int t = mid + 1;
        int flag = 0;
        while (h <= mid && t <= tail) {
            if (arr[h] <= arr[t]) {
                temp[flag++] = arr[h++];
            } else {
                temp[flag++] = arr[t++];
            }
        }
        while (h <= mid) {
            temp[flag++] = arr[h++];
        }
        while (t <= tail) {
            temp[flag++] = arr[t++];
        }
        flag = 0;
        for (int i = head; i <= tail; i++) {
            arr[i] = temp[flag++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 9, 4, 3, 1, 8, 7};
        MergeSort.mergeAndSort(arr, arr.length);
        for (int item : arr) {
            System.out.println(item);
        }
    }

}
