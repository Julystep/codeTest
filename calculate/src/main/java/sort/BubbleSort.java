package calculate.src.main.java.sort;

/**
 * 冒泡排序
 * 思维误区：思考这个问题的时候一直想的是两个循环遍历操作，但是实际上是一个循环的比较就可以搞定了，另一个循环帮忙处理长度
 */
public class BubbleSort {

    public static int[] bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean ifSwapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int x = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = x;
                    ifSwapped = true;
                }
            }
            if (!ifSwapped) {
                System.out.println("提前排序完成");
                return arr;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 9, 4, 3, 1, 8, 7};
        for (int item : BubbleSort. bubble(arr)) {
            System.out.print(item + " ");
        }
    }

}
