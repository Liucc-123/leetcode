package com.liucc;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Exercise07
 * @Description: 无重复字符的最长子串问题
 * @author: liuchuangchuang
 * @date: 2024/10/30 14:34
 * @version: V1.0
 */
public class Exercise07 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * 实现思路：
     * 哈希表map统计：指针j遍历字符串s，map记录字符map[j]最新出现的索引位置
     * 更新左边界位置i：本轮遍历字符与哈希表中统计字符冲突，将i更新至哈希表中的索引位置i=map.get(s.charAt(j))
     * 更新结果ans：去上轮ans和本轮双指针区间[i+1, j]之间的最大值
     *
     * abcabcbb
     * abba
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int i = -1, ans = 0, len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < len; j++) {
            char cur = s.charAt(j);
            if (map.containsKey(cur)) { // 冲突
                i = Math.max(map.get(cur), i); // 左边界指针右移
            }
            map.put(cur, j); // 哈希表map统计
            ans = Math.max(ans, j-i);
        }
        return ans;
    }
}
