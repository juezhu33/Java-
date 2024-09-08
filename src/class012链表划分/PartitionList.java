package class012链表划分;

// 给你一个链表的头节点 head 和一个特定值 x
// 请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
// 你应当 保留 两个分区中每个节点的初始相对位置
// 测试链接 : https://leetcode.cn/problems/partition-list/

public class PartitionList {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode leftHead = null, rightHead = null;
            ListNode leftTail = null, rightTail = null;

            while (head != null) {
                if (head.val < x) {
                    if (leftHead == null) {
                        leftHead = head;
                        leftTail = head;
                    } else {
                        leftTail.next = head;
                        leftTail = leftTail.next;
                    }
                } else {
                    if (rightHead == null) {
                        rightHead = head;
                        rightTail = head;

                    } else {
                        rightTail.next = head;
                        rightTail = rightTail.next;
                    }
                }
                head = head.next;
            }
            if (rightTail != null)
                rightTail.next = null;

            if (leftHead == null)
                return rightHead;

            leftTail.next = rightHead;
            return leftHead;
        }
    }

    //优化版本
    public ListNode partition2(ListNode head, int x) {
        ListNode leftHead = null, leftTail = null;
        ListNode rightHead = null, rightTail = null;

        while (head != null) {
            ListNode next = head.next; // 保存下一个节点
            head.next = null; // 断开当前节点的 next 指针

            if (head.val < x) {
                if (leftHead == null) {
                    leftHead = head;
                    leftTail = head;
                } else {
                    leftTail.next = head;
                    leftTail = leftTail.next;
                }
            } else {
                if (rightHead == null) {
                    rightHead = head;
                    rightTail = head;
                } else {
                    rightTail.next = head;
                    rightTail = rightTail.next;
                }
            }

            head = next; // 移动到下一个节点
        }

        // 确保右侧链表的尾节点的 next 指针为 null，防止形成循环链表
        if (rightTail != null) {
            rightTail.next = null;
        }
        // 如果左侧链表为空，直接返回右侧链表的头节点
        if (leftHead == null) {
            return rightHead;
        }
        // 将左侧链表的尾节点连接到右侧链表的头节点
        leftTail.next = rightHead;
        return leftHead;
    }
}
