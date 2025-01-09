package ds_al.basic_al;

import java.util.List;

/**
 * 递归
 * 自己调自己
 * 递推关系： f(n) = f(n.next) 判断停止
 * <p>
 * 1.阶乘
 * 2.反向打印字符串
 * 3.二分查找
 * 4.斐波那契
 * 5.斐波那契变种：兔子问题
 * 6.斐波那契变种：青蛙跳楼梯
 * 7.斐波那契优化：记忆法/备忘录---剪枝
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


    /**
     * 斐波那契,求第n项
     */
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 斐波那契变种：兔子问题
     * <p>
     * 第一个月，一对未成熟的兔子
     * 第二个月，成熟
     * 第三个月及以后，他们每个月能产下一对新兔子
     * 所有兔子遵循此规律，求第n个月的兔子数
     * <p>
     * 递归关系：以第6月举例
     * 第6月的兔子 = 第5月的那些兔子 + 第5月成熟兔子生的兔子
     * 第5月成熟兔子生的兔子 = 第5月成熟兔子 = 第四月的兔子
     * 所以 f(n) = f(n-1) + f(n-2)
     */
    public int fibonacci_rabbit(int n) {
        if (n == 1 || n == 2) {
            return 2;
        }
        return fibonacci_rabbit(n - 1) + fibonacci_rabbit(n - 2);
    }

    /**
     * 斐波那契变种：青蛙跳楼梯
     * <p>
     * 楼梯有n阶
     * 青蛙要跳到楼顶，一次可以跳一阶或者两阶，只能向上跳
     * 问有多少种跳法
     * <p>
     * 递归关系：f(n) = f(n-1) + f(n-2)
     * 第n阶的种数 = 第n-1阶种数（最后一次跳1阶）+ 第n-2阶种数（最后一次跳2阶）
     */
    public int fibonacci_jumpStair(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return fibonacci_jumpStair(n - 1) + fibonacci_jumpStair(n - 2);
    }

    /**
     * 斐波那契优化：备忘录--剪枝
     */
//    public int fibonacci_memo(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//
//        int[] memo = new int[n];
//        memo[0] = 0;
//        memo[1] = 1;
//        memo[n-1]=fibonacci(n);
//
//        if()
//
//
//        return fibonacci(n - 1) + fibonacci(n - 2);
//    }
}
