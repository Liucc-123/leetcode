package com.liucc;

import java.util.HashMap;
import java.util.Map;

/**
 * 求两数之和：
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它下们的数组标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Exercise01 {
    public static void main(String[] args) {
        int[] nums = {11,7,2,15};
        int target = 9;
//        int[] result = twoNums(nums, target);
//        int[] result = twoNums2(nums, target);
        int[] result = twoNums3(nums, target);

        System.out.println("[" + result[0] + "," + result[1] + "]");
    }

    /**
     * 一次迭代法
     * 思路：在二次迭代法的思路上，可以发现，在一次迭代中也可实现查询当前遍历值是否和target相等
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoNums3(int[] nums, int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
            }
            map.put(nums[i], i);

        }
        return result;
    }


    /**
     * 两次迭代法
     * 思路：在第一次迭代，将数组的每个坐标的值及坐标存储起来
     * 第二次迭代中，查找有无 值和第一次坐标值之和等于target的值，且坐标不能是同一个坐标
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoNums2(int[] nums, int target){
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            // 查找有无 值和第一次坐标值之和等于target的值，且坐标不能是同一个坐标
            if (map.containsKey(target-nums[i]) && map.get(target - nums[i]) != i){
                result[0] = i;
                result[1] = map.get(target-nums[i]);
            }
        }
        return result;
    }

    /**
     * 求两数之和 暴力解法
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
