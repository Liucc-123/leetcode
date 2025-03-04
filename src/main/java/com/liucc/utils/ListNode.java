/**
 * File: ListNode.java
 * Created Time: 2022-11-25
 * Author: krahets (krahets@163.com)
 */

package com.liucc.utils;

/* 链表节点 */
public class ListNode{
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
