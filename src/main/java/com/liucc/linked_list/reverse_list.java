package com.liucc.linked_list;

import com.liucc.utils.ListNode;

/**
 * 反转链表
 * 题目链接：https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&envId=selected-coding-interview
 */
public class reverse_list {
    public static void main(String[] args) {
        // 创建链表 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode reversedHead = reverseList(head);
        // 输出反转后的链表
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
        }
    }

    /**
     * 迭代法（双指针）
     * 适合链表非常大的情况
     * 
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        // 如果链表为空或者只有一个节点，无需反转
        if (head == null || head.next == null) {
            return head;
        }
        // 初始化指针
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            // 暂存后继结点
            ListNode temp = cur.next;
            // 修改指针指向
            cur.next = prev;
            // 暂存当前节点
            prev = cur; // prev指针后移
            cur = temp; // cur指针后移
        }
        return prev;
    }

    /**
     * 递归（适合链表规模小的情况）
     * 
     * @param head
     * @return
     */
    // public static ListNode reverseList(ListNode head) {
    //     // 如果链表为空或者只有一个节点，无需反转
    //     if (head == null || head.next == null) {
    //         return head;
    //     }
    //     // 反转链表
    //     ListNode newHead = reverseList(head.next);
    //     // 在回溯过程中，反转指针的指向
    //     head.next.next = head;
    //     head.next = null;
    //     return newHead; // 返回新链表的头节点
    // }

}
