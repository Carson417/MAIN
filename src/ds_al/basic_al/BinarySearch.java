package ds_al.basic_al;

/**
 * arr是升序数组，查询arr中和target值相等的索引
 * 后面的mostLeft、mostRight在找范围中很有用
 * 力扣 704，35，34
 */
public class BinarySearch {

    /**
     * i,j作为两边的范围，比较目标值与他们中间索引值，大于就变i，小于就变j
     * 这个方法是i，j都参与比较，相当于左闭右闭
     */
    public static int binarySearch_basic_ij(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        // 循环条件为什么是<= ，比如tar在left，当倒数第二次，left，mid，right连在一起，下一次操作，i和j会在同一位置，但是因为需要i<j
        while (left <= right) {
            // 无符号右移，左侧补0，为什么不除2：相加后超出整数范围
            int middle = (left + right) >>> 1;
            if (arr[middle] == target)
                return middle;
            else if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }


    /**
     * i,j作为两边的范围，比较目标值与他们中间索引值，大于就变i，小于就变j
     * 这个方法是i参与比较,j的前一个参与，相当于左闭右开
     */
    public static int binarySearch_basic_i(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            // 无符号右移，左侧补0，为什么不除2：相加后超出整数范围
            int middle = (left + right) >>> 1;
            if (arr[middle] == target)
                return middle;
            else if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return -1;
    }


    /**
     * 平衡版，只缩小范围
     */
    public static int binarySearch_basic_balance(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left + 1 < right) {
            int middle = (left + right) >>> 1;
            if (target < arr[middle])
                right = middle;
            else {
                // 右，或m
                left = middle;
            }
        }
        return (arr[left] == target) ? left : -1;
    }


    /**
     * 如果有很多相同值，选最左的
     * 向右的就是 i=m+1
     */
    public static int binarySearch_mostLeft(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int candidate = -1;
        // 循环条件为什么是<= ，比如tar在left，当倒数第二次，left，mid，right连在一起，下一次操作，i和j会在同一位置，但是因为需要i<j
        while (left <= right) {
            // 无符号右移，左侧补0，为什么不除2：相加后超出整数范围
            int middle = (left + right) >>> 1;
            if (arr[middle] == target) {
                candidate = middle;
                right = middle - 1;
            } else if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return candidate;
    }


    /**
     * 之前都是只返回-1，现在可以返回更有用的信息，>=target的最左侧索引的位置
     */
    public static int binarySearch_mostLeft_returnUseful(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            // 无符号右移，左侧补0，为什么不除2：相加后超出整数范围
            int middle = (left + right) >>> 1;
            if (target <= arr[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }


    /**
     * 反过来，就是<=target的最右索引
     */
    public static int binarySearch_mostRight_returnUseful(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            // 无符号右移，左侧补0，为什么不除2：相加后超出整数范围
            int middle = (left + right) >>> 1;
            if (target < arr[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left - 1;
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 3, 3, 3, 4, 5, 6, 7};
        int target = 3;
        System.out.println(binarySearch_mostLeft(arr, target));
    }
}
