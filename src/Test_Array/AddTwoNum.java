package Test_Array;

import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static java.lang.Math.max;

/**
 * 计算数值总和
 *
 * @author Anita
 * @date 2026-07-23 18:53
 */
public class AddTwoNum {
    public static void main(String[] args) {
        int[] num = {3, 2, 4};
        int target = 6;
        twoSum(num, target);
        int a = 1, b = 2;
        int c = compareNum(a, b);
        System.out.printf("比较两个数值的大小:" + c);
        System.out.println("排序数值并获取最大值" + getMax());
    }

    private static int getMax() {
        int a1=2,b1=33,c1=4;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(a1);
        list.add(b1);
        list.add(c1);
        list.sort(Integer::compareTo); //从小到大的升序排序
        list.sort(Comparator.reverseOrder()); //从小到大的降序排序
        /*ArrayList<Integer> sort_array = new ArrayList<Integer>();
        sort_array =  list.stream().sorted(Comparator.comparing().reversed()).collect(Collectors.toCollection(ArrayList::new));*/
        //int max = sort_array.get(0);
        int max = list.get(0);
        int min = list.get(list.size()-1);
        return max;
    }

    private static int compareNum(int a, int b) {
        //return  max(a,b);
        return a > b ? a : b;
    }

    private static void twoSum(int[] num, int target) {
        for (int i = 0; i < num.length; i++) {
            for (int j = 1; j < num.length; j++) {
                if (num[i] + num[j] == target) {
                    System.out.println("[" + i + "," + j + "]");
                }
            }
        }
    }
}

