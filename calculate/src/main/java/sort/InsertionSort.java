package calculate.src.main.java.sort;

/**
 * 插入排序
 * 我这里想的是从前往后，这样就O(n3)了，不好
 */
public class InsertionSort {

    public static int[] insert(int[] arr) {
        for (int i = 1; i < arr.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (arr[i] < arr[j]) {
                    int item = arr[i];
                    System.arraycopy(arr, j, arr, j + 1, i - j);
                    arr[j] = item;
                }
            }
        }
        return arr;
    }

    public static int[] insertMoreBeautiful(int[] arr) {
        for (int i = 1; i < arr.length; i ++) {
            int item = arr[i];
            int j = i - 1;
            for (; j >= 0; j --) {
                if (arr[j] > item) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = item;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 9, 4, 3, 1, 8, 7};
        for (int item : InsertionSort. insertMoreBeautiful(arr)) {
            System.out.print(item + " ");
        }
        System.out.println();
        int[] arr1 = new int[]{5, 6, 9, 4, 3, 1, 8, 7};
        for (int item : InsertionSort. insert(arr1)) {
            System.out.print(item + " ");
        }
    }

}
