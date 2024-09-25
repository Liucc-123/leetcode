package com.liucc;

/**
 * @ClassName: Exercise04
 * @Description: 合并两个有序链表
 * @author: liuchuangchuang
 * @date: 2024/9/25 17:16
 * @version: V1.0
 */
public class Exercise04 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node3;
        node3.next = node5;

        node2.next = node4;
        node4.next = node6;
        ListNode newNode = mergeTwoLists(node1, node2);
        while (newNode != null){
            System.out.printf("node[%d] = %d", newNode.val, newNode.val);
            System.out.println();
            newNode = newNode.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
