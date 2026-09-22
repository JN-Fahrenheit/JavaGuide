package Test_Sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {2,13,6,54,7};
        System.out.println("初始数据： " );
        for (int j : arr) {
            System.out.printf(j + " ");
        }
        selectsort(arr);
        System.out.println(); // 换行
        System.out.println("选择排序后： " );
        for (int j : arr) {
            System.out.printf(j + " ");
        }
    }

    private static int[] selectsort(int[] arr) {
        /*
        选择排序算法步骤[把数组分成「已排序左区」和「未排序右区」；每一轮在右区找到最小值下标，和左区当前起点交换，逐步填满左边有序区。]：
        1. 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
        2. 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
        3. 重复第 2 步，直到所有元素均排序完毕。
         */
        for (int i = 0; i < arr.length - 1; i++) {
            //当前最小值所在下标
            int minIndex = i;
            //j要从已排序后的i+1，比较时与未排序的部分比较，不是 j=0，不能回头遍历有序区
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    //更新当前最小值所在下标
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
        return arr;
    }
}
