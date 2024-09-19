package com.liucc;

/**
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * <p>
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * <p>
 * 示例 1：
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 * <p>
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 */
public class Exercise02 {
    public static void main(String[] args) {
        String name = "alex";
//        String name = "leelee";
        String typed = "aaleex";
//        String typed = "lleeelee";
        System.out.println(isLongPressedName(name, typed));
    }

    /**
     * 实现思路：
     * 准备两个指针，一个用于扫描name，一个用于扫描typed
     * 对于用户键入的字符，其存在两种情况：
     *  1、正确键入名称name，此时，两个指针均后移
     *  2、重复键入。仅typed指针后移
     * 当扫描完毕后，检查name的所有字符是否全被扫描。如果均已被扫描
     * @param name
     * @param typed
     * @return
     */

    public static boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)){ //字符匹配
                i++;
                j++;
            } else if (j >0 && typed.charAt(j) == typed.charAt(j - 1)) {// 字符重复键入
                j++;
            }else {
                return false;
            }
        }
        // typed扫描完成后，检查name是否全部被扫描。如果i==name.length()，说明每个字符都已匹配
        return i==name.length();
    }
}
