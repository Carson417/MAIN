package ds_al.basic_al.sort;

/**
 * 冒泡排序（升序）
 * 相邻两元素进行比较，每次会将‘最大’的移到右边
 */
public class BubbleSort {


    public void sort(int[] a) {
        bubble(a, a.length - 1);
    }

    /**
     * 递归实现
     * j是未排序的右边界
     */
    private void bubble(int[] a, int j) {
        if (j == 0) {
            return;
        }
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
        bubble(a, j - 1);
    }


    /**
     * 递归实现优化：如果有些已经有序，之后的过程就不需要了
     * x相当于未有序的右边界，j是未排序的右边界，目的是有序的部分就不排了
     * 初始时x设为0，只要a[i]和a[i+1]发生交换，就把i索引赋给x ---交换代表无序，不换代表有序
     */
    private void bubble_optimization(int[] a, int j) {
        if (j == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                x = i;
            }
        }
        bubble(a, x);
    }
}
