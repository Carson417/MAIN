package ds_al.basic_al;

import java.util.Arrays;
import java.util.LinkedList;
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
 * 8.爆栈问题 --- 可使用尾递归优化，但是java不支持尾递归优化  --- 本质解决：改成循环
 * 9.汉诺塔
 * 10.杨辉三角
 * 11.杨辉三角优化：备忘录 ---二维数组
 * 12.杨辉三角优化：备忘录 ---一维数组 ---简单动规
 * <p>
 * 1）尾调用：方法的最后一步时调用一个方法：return a();
 * 一些语言的编译器会对尾调用优化：a->b->c,因为是尾调用，a到最后的return b()时，a之前所有操作已经完成，而且a()返回的是b()，跟a没关系了，所以a->b->c的嵌套关系可以变成a、b、c的平级关系
 * 注意只能是return b();  return b()+x 都不是尾调用， 想变成尾调用：将x变成参数
 * 2）尾递归：最后调用的是自己
 */
public class Recursion {

    /**
     * 1.阶乘
     * 0!=1,1!=1,f(n)=n*f(n-1)
     */
    public int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * 2.反向打印字符串
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
     * 3.二分查找
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
     * 4.斐波那契,求第n项
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
     * 5.斐波那契变种：兔子问题
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
     * 6.斐波那契变种：青蛙跳楼梯
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
     * 7.斐波那契优化：备忘录--剪枝
     */
    public static int fibonacci_memo(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return f(n, cache);
    }

    public static int f(int n, int[] cache) {
        if (cache[n] != -1) {
            return cache[n];
        }
        int x = f(n - 1, cache);
        int y = f(n - 2, cache);
        cache[n] = x + y;
        return cache[n];
    }

    /**
     * 9.汉诺塔
     */
    public static LinkedList<Integer> a = new LinkedList<>();
    public static LinkedList<Integer> b = new LinkedList<>();
    public static LinkedList<Integer> c = new LinkedList<>();

    static void init(int n) {
        for (int i = n; i > 0; i--) {
            a.addLast(i);
        }
    }

    /*
     * @param n 圆盘个数
     * @param a 源
     * @param b 借助
     * @param c 目标
     */
    static void move(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        if (n == 0) {
            return;
        }
        move(n - 1, a, c, b);
        // 最后一个直接从a到c
        c.addLast(a.removeLast());
        move(n - 1, b, a, c);
    }

    static void hanNuoTower() {
        a.removeLast();

    }


    /**
     * 10.杨辉三角
     */
    private static int element(int i, int j) {
        if (j == 0 || i == j) {
            return 1;
        }
        return element(i - 1, j - 1) + element(i - 1, j);
    }

    //@param n 杨辉三角高度
    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                // -:左对齐，4:宽度为4，d:整数
                System.out.printf("%-4d", element(i, j));
            }
            System.out.println();
        }
    }

    /*
     * 打印空格
     *
     * @param n 高度
     * @param i 行号
     */
    public static void printSpace(int n, int i) {
        int num = (n - 1 - i) * 2;
        for (int x = 0; x < num; x++) {
            System.out.println(" ");
        }
    }


    /**
     * 11.杨辉三角优化：二维数组备忘录
     */
    private static int element_memo(int[][] triangle, int i, int j) {
        // 如果已经计算就不递归了
        if (triangle[i][j] > 0) {
            return triangle[i][j];
        }
        // 没有计算过才走递归的逻辑
        if (j == 0 || i == j) {
            triangle[i][j] = 1;
            return 1;
        }
        triangle[i][j] = element_memo(triangle, i - 1, j - 1) + element_memo(triangle, i - 1, j);
        return triangle[i][j];
    }

    public static void print_memo(int n) {
        // 新建一个二维数组，每列不确定，具体到某行才知道 ---不用必须方方正正的二维数组
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            // 知道第几行，才知道这行有几列
            triangle[i] = new int[i + 1];
            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                // -:左对齐，4:宽度为4，d:整数
                System.out.printf("%-4d", element_memo(triangle, i, j));
            }
            System.out.println();
        }
    }


    /**
     * 12.杨辉三角优化：一维数组备忘录 ---简单动规
     * <p>
     * 比如某一行：1 3 3 1，那么下一行，从后往前看，1，1+3，3+3，3+1，1 = 1 4 6 4 1
     */
    private static void createRow(int[] row, int i) {
        if (i == 0) {
            row[0] = 1;
            return;
        }
        for (int x = i; x > 0; x--) {
            row[x] = row[x] + row[x - 1];
        }
    }

    public void printRow(int n) {
        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            createRow(row, n);
            for (int x = 0; x <= i; x++) {
                if (row[x] != 0) {
                    System.out.printf("%-4d", row[x]);
                }
            }
            System.out.println();
        }
    }
}
