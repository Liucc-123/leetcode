package com.liucc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Exercise06
 * @Description: 罗马数字转数字
 * @author: liuchuangchuang
 * @date: 2024/10/29 14:34
 * @version: V1.0
 */
public class Exercise06 {
    public static void main(String[] args) {

    }

    /**
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 情况一：
     * 也是通常情况，小的数字在大的数字右边 12：XII
     * 情况二：
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     *
     * 相同字母连写表示相加。 例如，II表示2，XXX表示30。
     * 小的数字在大的数字右边表示相加。 例如，VI表示6（5+1），XV表示15（10+5）。
     * 小的数字在大数字左边表示相减。 例如，IV表示4（5-1），IX表示9（10-1）。
     *
     * MCMXCIV ==》 M = 1000, CM = 900, XC = 90, IV = 4.
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<Character, Integer> ROME_MAP = new HashMap<>();
        ROME_MAP.put('I', 1);
        ROME_MAP.put('V', 5);
        ROME_MAP.put('X', 10);
        ROME_MAP.put('L', 50);
        ROME_MAP.put('C', 100);
        ROME_MAP.put('D', 500);
        ROME_MAP.put('M', 1000);

        Integer sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i); // 当前罗马数字
            char next = s.charAt(i+1); // 下一罗马数字
            if(i<s.length()-1 && ROME_MAP.get(cur) < ROME_MAP.get(next)){
                sum -= cur;
            }else {
                sum += cur;
            }
        }
        return sum;
    }
}
