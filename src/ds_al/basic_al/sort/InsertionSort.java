package ds_al.basic_al.sort;

/**
 * 插入排序
 * 就像打牌一样
 * 每次从未排序左边界取一张，插入到左侧已排序的牌中
 */
public class InsertionSort {

    public void sort(int[] a) {
        // 默认 0 索引是排好序的
        Insertion1(a,1);
    }


    /**
     * 实现1
     * @param low 未排序的下边界
     */
    private void Insertion1(int[] a, int low) {
        if (low == a.length) {
            return;
        }
        // 已排序区域指针
        int i = low - 1;
        // 找到插入位置
        while (i >= 0 && a[i] > a[low]) {
            a[i + 1] = a[i];
            i--;
        }
        // 插入   --- 为什么是i+1：找到时i--了，所以这里再加回来
        a[i + 1] = a[low];

        Insertion1(a, low + 1);
    }

}
