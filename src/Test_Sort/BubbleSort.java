package Test_Sort;

public class BubbleSort {


    public static void main(String[] args) {
        int[] arr = {2,13,6,54,7};
        System.out.println("Original array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println(); // 换行

        bubbleSort(arr); // 调用bubbleSort函数

        System.out.println("Sorted array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
    /*
    冒泡排序算法步骤
    1. 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
    2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
    3. 针对所有的元素重复以上的步骤，除了最后一个；
    4. 重复步骤 1~3，直到排序完成。
     */
    // 第一轮，从arr[0]开始，每相邻两个元素比较，总共比较len-1次(即：4次)，flag = false继续比较，flag要一直在内层循环设置为false,在内层发现不满足if的条件即flag=1，跳出当前交换
    // 第二轮，从arr[1]开始，每相邻两个元素比较，总共比较len-2次(即：3次)，flag = false;
    // 第三轮，从arr[2]开始，每相邻两个元素比较，总共比较len-3次(即：2次)，flag = false;
    // 第四轮，从arr[3]开始，每相邻两个元素比较，总共比较len-4次(即：1次)，flag = false;
    // 当完成所有比较后，此时flag是ture，可以退出比较，注意是：小数沉淀，有中间变量来置换
    private static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++){
            boolean flag =true;
            // 内层循环，进行相邻元素的比较和可能的交换
            for (int j = 0; j < arr.length -i; j++){
                // System.out.println("当前attr" + j + "的值为" + arr[j]);
                if (arr[j] > arr[j + 1]){
                    // tmp 是要记录要变化的那个数值
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    // change flag
                    flag = false;

                }
            }
            //内层循环结束后，判断是否完成，flag是true
            if (flag){
                break;
            }
        }
    }
 }
