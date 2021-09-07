package calculate.src.main.java.sort;

/**
 * 选择排序
 */
public class SelectionSort {

    public static int[] selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int value = arr[j];
                    arr[j] = arr[i];
                    arr[i] = value;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 9, 4, 3, 1, 8, 7};
        for (int item : SelectionSort. selection(arr)) {
            System.out.print(item + " ");
        }
    }

}
