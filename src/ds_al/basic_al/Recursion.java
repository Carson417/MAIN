package ds_al.basic_al;

import java.util.List;

/**
 * 递归
 * 自己调自己
 * 递推关系： f(n) = f(n.next) 判断停止
 */
public class Recursion {

    /**
     * 阶乘
     * 0!=1,1!=1,f(n)=n*f(n-1)
     */
    public int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * 反向打印字符串
     * n为字符在整个字符串str的索引位置
     * 注意打印要在递归后 f(0)->f(1)->f(2)->停，打印 --- f(2)->f(1)->f(0)
     */
    public void reverseStr(int n, String str) {
        if (n == str.length()) {
            return;
        }
        reverseStr(n + 1, str);
        System.out.println(str.charAt(n));
    }


    /**
     * 二分查找
     */
    public int binaryResearch(int[] a, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) >>> 1;
        if (target > a[middle]) {
            return binaryResearch(a, target, middle + 1, right);
        } else if (target <= a[middle]) {
            return binaryResearch(a, target, left, middle - 1);
        } else {
            return middle;
        }
    }
}
