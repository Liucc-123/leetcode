package com.liucc;

/**
 * @ClassName: Exercise05
 * @Description: 数组元素和与数字和的绝对差
 * @author: liuchuangchuang
 * @date: 2024/9/26 16:10
 * @version: V1.0
 */
public class Exercise05 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int result = differenceOfSum(nums);
        System.out.println("result=" + result);
    }

    /**
     * 数组元素和与数字和的绝对差
     * @param nums 示例：[1,15,6,3]
     * @return
     */
    public static int differenceOfSum(int[] nums) {
        int itemSum = 0;
        int numSum = 0;
        StringBuilder numStr = new StringBuilder(); // 使用StringBuilder来构建字符串

        // 同时计算元素和与构建数字和字符串
        for (int num : nums) {
            itemSum += num;
            numStr.append(num);
        }

        // 遍历字符串计算数字和
        for (char c : numStr.toString().toCharArray()) {
            numSum += c - '0'; // 将字符转换为数字
        }

        // 返回元素和与数字和的绝对差
        return Math.abs(itemSum - numSum);
    }
}
