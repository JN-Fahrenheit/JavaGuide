package Test_Array;

/**
 * 凯捷coding题(对接渣打银行)
 *  找到数组中出现次数大于等于2次的结果
 * @author Anita
 * @date 2026-07-27 19:52
 */
public class SameTest {
    public static void main(String[] args) {
        int[] arr = {1,2,5,1,1,1,2,1};
        count(arr);
    }

    private static void count(int[] arr) {
        boolean flag = true;
        int count =1;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp =arr[i];
            for (int j = 1; j <arr.length; j++) {
                if (arr[j] == temp){
                    temp = arr[j];
                    count++;
                }
            }
            if (flag)
                break;
        }
        System.out.println("当前重复值是"+ temp);
        System.out.println("出现了"+ count +"次");
    }

}
