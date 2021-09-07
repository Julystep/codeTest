package calculate.src.main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 台阶递归：n个台阶，可以一步，可以两步, 有多少种走法？
 */
public class StepRecursion {
    Map<Integer, Integer> map = new HashMap<>();
    public int count(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int sum = count(n - 1) + count(n - 2);
        map.put(n, sum);
        return sum;
    }
    public int countFor(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int pre = 2;
        int prePre = 1;
        int ret = 0;
        for (int i = 3; i <= n; i++) {
            ret = pre + prePre;
            prePre = pre;
            pre = ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        StepRecursion stepRecursion = new StepRecursion();
        System.out.println(stepRecursion.count(10));
        System.out.println(stepRecursion.countFor(10));
    }

}
