public class InsertionSort {
    public static void main(String[] args) {
        System.out.println("原始数据：");
        int[] arr = {21, 13, 6, 54, 7};
        for (int i : arr) {
            System.out.printf(i + " ");
        }
        insertSort(arr);
        System.out.println("");
        System.out.println("排序后");
        for (int i : arr) {
            System.out.printf(i + " ");
        }
    }

    private static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length ; i++) {
            //有序区间下的下标，当前从第一个开始
            int index = i -1;
            //待排序的当前数值
            int current = arr[i];
            while(index >= 0 && current < arr[index]){
                //前面的那个元素需要往前挪位置
                arr[index+1] = arr[index];
                //继续向前比较
                index--;
            }
            //当结束比较后，退出while
            arr[index+1] = current;
        }
        return arr;
    }


}
