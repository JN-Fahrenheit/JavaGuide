package Test_Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 删除有序数组中的重复项
 *
 * @author Anita
 * @date 2026-07-24 14:46
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        //int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums = new int[]{1, 1, 2};
        System.out.println("去重后返回结果：" + removeDuplicates(nums));
        //System.out.println("新数组的长度：" + removeDuplicates(nums).length);
    }

    private static String removeDuplicates(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int num : nums) {
            arrayList.add(num);
        }
        Integer[] array = new Integer[] {3,4,5,6,23,8};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));

        System.out.printf("测试结果" + list);

//        for (int j = 0; j < arrayList.size() - 1; j++) {
//            if (arrayList.get(j + 1).equals(arrayList.get(j))) {
//                arrayList.remove(j + 1);
//                System.out.println("下一个不同次输出arrayList" + arrayList);
//            }
//            if (j > 0 && arrayList.get(j - 1).equals(arrayList.get(j)) ) {
//                arrayList.remove(j - 1);
//                System.out.println("上一个不同次输出arrayList" + arrayList);
//            }
//        }

        for (int j = arrayList.size() - 2; j >= 0; j--) {
            // 用equals比较包装类，规避缓存陷阱
            if (arrayList.get(j).equals(arrayList.get(j + 1))) {
                arrayList.remove(j + 1);
            }
        }
        int[] result = arrayList.stream().mapToInt(Integer::intValue).toArray();
        return Arrays.toString(result);
    }
}
