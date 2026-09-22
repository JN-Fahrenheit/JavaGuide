import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 6, 54, 7, 1, 3};
        System.out.println("Original array:");
        for (int i : arr) {
            System.out.printf(i + " ");
        }
        selectSort(arr);
        System.out.println("");
        for (int i : arr) {
            System.out.printf(i + " ");
        }
    }

    private static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            if (min_index != i) {
                int tmp;
                tmp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = tmp;
            }
        }
        return arr;
    }


}
