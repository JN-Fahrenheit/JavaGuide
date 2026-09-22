public class BubbleSort {
    public static void main(String[] args) {
        int[] attr = {2, 13, 6, 54, 7};
        System.out.printf("初始数据");
        for (int j : attr) {
            System.out.printf(j + " ");
        }
        // 冒泡排序后
        System.out.printf("冒泡排序后：");
        bubbleSort(attr);
        for (int j : attr) {
            System.out.printf(j + " ");
        }
    }

    private static int[] bubbleSort(int[] attr) {
        for (int i = 1; i < attr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < attr.length - i; j++) {
                int tmp;
                if (attr[j + 1] < attr[j]) {
                    tmp = attr[j];
                    attr[j] = attr[j + 1];
                    attr[j + 1] = tmp;
                }
                flag = false;
            }
            if (flag) {
                break;
            }
        }
        return attr;
    }

}




