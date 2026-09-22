package Test_Sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {21, 13, 6, 54, 7};
        System.out.println("原始数据：");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
        System.out.println("排序结果：");
        insertionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /*
    插入排序算法步骤
    1. 从第一个元素开始，该元素可以认为已经被排序；
    2. 取出下一个元素，在已经排序的元素序列中从后向前扫描；
    3. 如果该元素（已排序）大于新元素，将该元素移到下一位置；
    4. 重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置；
    5. 将新元素插入到该位置后；
    6. 重复步骤 2~5。
     */
    private static int[] insertionSort(int[] arr) {
        //注意从第二个元素起算，因为认为第一个元素已认定好排序
        for (int i = 1; i < arr.length; i++) {
            // preIndex：有序区间最后一个元素下标；//有序区间下的下标，当前从第一个开始
            int preIndex = i - 1;
            // current：本次要向前插入的待排序元素
            int current = arr[i];
            // 循环条件：下标不越界 && 当前元素 < 前面有序
            // 元素 → 需要前移
            while (preIndex >= 0 && current < arr[preIndex]) {
                // 前面更大的元素向后挪一位，腾出空位
                arr[preIndex + 1] = arr[preIndex];
                // 继续向前比较
                preIndex -= 1;
            }
            // 退出while：找到插入位置，把current放入
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    /*
    初始：21, 13, 6, 54, 7
    第一轮：13 21 6 54 7 【13和21比较】
    第二轮：6 13 21 54 7 【6和21比较后，6和13比较】
    第三轮：6 13 21 54 7 【54，不满足】
    第四轮：6 13 21 54 7 【7和54比较，7和21比较，7和13比较，7和6比较不满足】


    初始：6，5，4，3，2，1
     */

}

