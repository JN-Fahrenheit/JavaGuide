package Test_String;
/*
找出最长公共前缀，当前不使用暴力解法，使用String的公共方法：
stratWith(String prefix):用于判断字符串是否以指定前缀开头，返回 boolean 值
subString(beginIndex):从指定索引到字符串末尾的子串，
substring(int beginIndex, int endIndex):获取从指定起始索引到结束索引（不包括）的子串
 */


import java.util.ArrayList;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String s;
        // startsWith(s)的用法，如果前缀不一致则返回false
        String test = "flower";
        System.out.println("测试startsWith方法：" + String.valueOf(test.startsWith("1")));
        System.out.println("测试substring方法：" + test.substring(0, test.length() - 1));
        s = getLongestCommonPrefix(strs);
        System.out.println("公共匹配" + s);
    }

    private static String getLongestCommonPrefix(String[] strs) {
        String s;
        s = strs[0];
        if (strs.length == 0) {
            return "";
        }
        for (String str : strs) {
            while (!str.startsWith(s)) {
                if (s.length() == 0) {
                    return "";
                }
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }
}

