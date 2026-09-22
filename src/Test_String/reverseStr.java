package Test_String;

/**
 * 凯捷coding题(对接渣打银行)
 * 有2个数，分别是123和456，先将他们倒序排列再求和
 *
 * @author Anita
 * @date 2026-07-27 19:49
 */
public class reverseStr {
    public static void main(String[] args) {
        int a = 123;
        int b = 456;
        // 字符串反转
        String revA = new StringBuilder(String.valueOf(a)).reverse().toString();
        String revB = new StringBuilder(String.valueOf(b)).reverse().toString();
        int numA = Integer.parseInt(revA);
        int numB = Integer.parseInt(revB);
        int sum = numA + numB;
        System.out.println("总和：" + sum);
    }
}
