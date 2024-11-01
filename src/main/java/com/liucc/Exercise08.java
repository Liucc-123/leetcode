package com.liucc;

/**
 * @ClassName: Exercise08
 * @Description: TODO (用一句话描述该文件做什么)
 * @author: liuchuangchuang
 * @date: 2024/10/31 15:55
 * @version: V1.0
 */
public class Exercise08 {
    public static void main(String[] args) {
        int[] num1 = {1, 4, 7};
        int[] num2 = {3, 5, 6, 8, 9};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

    /**
     * 寻找两个正序数组的中位数
     * 一组数据从小到大排序后：
     * 数据个数为奇数时： 中位数就是处于最中间位置的那个数。
     * 数据个数为偶数时： 中位数是处于中间两个数的平均值。
     * <p>
     * 怎么把两个数组中的数据合并成一个有序数组？
     * 奇数==》直接返回最中间的那个数 arr[n/2]
     * 偶数==》(arr[n/2] + arr[n/2 - 1]) / 2
     * 思路：采取双指针，同时遍历两个数组，依次将较小元素存放到新数组中
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sortedArray = new int[nums1.length + nums2.length];
        int i = 0, j = 0; //双指针，遍历两个数组
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){
                sortedArray[i+j] = nums1[i];
                i++;
            }else  {
                sortedArray[i+j] = nums2[j];
                j++;
            }
        }
        // 如果数组1还有剩余元素
        while (i < nums1.length){
            sortedArray[nums2.length + i] = nums1[i];
            i++;
        }
        // 如果数组2还有剩余元素
        while (j < nums2.length){
            sortedArray[nums1.length + j] = nums2[j];
            j++;
        }

        int len = sortedArray.length;
        if (len % 2 !=0){// 奇数
            return sortedArray[len/2];
        }else {
            return (double) (sortedArray[len/2] + sortedArray[len/2 -1]) /2;
        }
    }
}
