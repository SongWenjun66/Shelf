package com.song.frame.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 判断
 */
public class TextUtil {
    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0) {
            return true;
        } else {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isListEmpty(List<?> str) {
        if (str == null || str.size() == 0) {
            return true;
        }

        return false;
    }

    public static boolean islenth0(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     *
     */

    private static Pattern phonePattern = Pattern.compile(PattenUtil.phone);

    public static boolean isPhoneNumber(String str) {
        if (TextUtil.isEmpty(str)) {
            return false;
        }
        //String check = "(134[012345678][0123456789]{7}|1[34578][012356789][0123456789]{8}|1[3578][01379][0123456789]{8}|1[34578][01256][0123456789]{8})$";

        Matcher matcher = phonePattern.matcher(str);
        return matcher.matches();
    }

    public static boolean isURl(String str) {
        if (TextUtil.isEmpty(str)) {
            return false;
        }
        Pattern regex = Pattern.compile(PattenUtil.checkurl);
        Matcher matcher = regex.matcher(str);
        return matcher.matches();
    }

    public static boolean isEmail(String str) {
        if (TextUtil.isEmpty(str)) {
            return false;
        }
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(str);
        return matcher.matches();
    }

    /**
     * 判定输入汉字
     *
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    /**
     * 检测String是否全是中文
     *
     * @param name
     * @return
     */
    public static boolean checkNameChese(String name) {
        boolean res = true;
        char[] cTemp = name.toCharArray();
        for (int i = 0; i < name.length(); i++) {
            if (!isChinese(cTemp[i])) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static boolean testRegular(String str) {

        String regEx = "[a-zA-z0-9]+";
//        Pattern pattern = Pattern.compile(regEx);
        if (str.matches(regEx)) {
            return true;
        }
        return false;
    }

    /**
     * 利用正则表达式判断字符串是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static boolean isstartok(String str) {
        Pattern pattern = Pattern.compile("(^[A-Za-z][A-Za-z0-9-_]+$)");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
