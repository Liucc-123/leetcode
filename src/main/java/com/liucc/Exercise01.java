package com.liucc;

/**
 * 求两数之和：
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 */
public class Exercise01 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoNums(nums, target);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }

    /**
     * 求两数之和
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoNums(int[] nums, int target){
        int[] result = new int[2];
        for (int i = 0; i <nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
