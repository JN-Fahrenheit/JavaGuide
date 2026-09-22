package Test_String;

import java.util.Arrays;

/*

 */
public class TransStr {
    public static void main(String[] args) {
        String str = "This is a sample an other test";
        //System.out.println("当前字符串中包含的数字是：" + getStingsNumber(str));
        //System.out.println("当前字符串反转后的结果是：" + getReverse(str));
        //System.out.println("当前字符串大小写互转后反转的结果是：" + getTransStr(str));
        int n = str.length();
        System.out.println("字符串中由空格隔开的单词反序，同时反转每个字符的大小写：" + tran(str, n));
        System.out.println("testString：" + teststring(str));
    }

    private static String teststring(String str) {
        StringBuilder newsb = new StringBuilder(str);
        newsb.append("test123");
        String newstr = newsb.toString();
        return newstr;
    }

    private static String tran(String s, int n) {
        //处理完第一个单词后遇到空格，就将这个单词放后面，把下个要处理的单词放在前面
        String res = "";
        String tempStr = "";
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z')
                tempStr += Character.toUpperCase(c);
            else if (c >= 'A' && c <= 'Z')
                tempStr += Character.toLowerCase(c);
            else {
                tempStr = c + tempStr;
                res = tempStr + res;
                tempStr = "";
            }
        }
        res = tempStr + res;
        return res;
    }


    private static String getReverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }


    private static String getTransStr(String str) {
        StringBuilder sb = new StringBuilder();
        String new_str = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append(Character.toUpperCase(c));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
            new_str = sb.reverse().toString();
        }
        return new_str;
    }

    private static String getStingsNumber(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }

        return sb.toString();
    }

}
