package com.liucc;

import java.util.*;

/**
 * @ClassName: Exercise03
 * @Description: TODO (用一句话描述该文件做什么)
 * @author: liuchuangchuang
 * @date: 2024/9/19 14:02
 * @version: V1.0
 */
public class Exercise03 {
    public static void main(String[] args) {
//        String s = "()";
        String s =  "){";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        // 如果是奇数,直接返回
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (char curBracket : s.toCharArray()){
            if (map.containsKey(curBracket)){ // 左括号
                stack.push(curBracket);
            } else if (stack.isEmpty() || map.get(stack.pop()) != curBracket) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
