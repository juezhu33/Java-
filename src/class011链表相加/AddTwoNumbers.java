package class011链表相加;

// 给你两个 非空 的链表，表示两个非负的整数
// 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
// 测试链接：https://leetcode.cn/problems/add-two-numbers/

//工程上的实现，一个类型的初始化函数可能很复杂，并不像刷题中的节点可以随意构造，此时你要怎么办？
//工程上的节点初始化的时候，内存占用可能很大，并不像刷题中的节点代价那么少，此时你要怎么办？
//不用假节点，目的是基于这样一种追求：一个结构的事情，就在这个结构自身上做调整，解决这个结构自身的问题，而不是再引入外部的东西。
public class AddTwoNumbers {

    // 不要提交这个类
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
        public static ListNode addTwoNumbers(ListNode h1, ListNode h2) {
            ListNode newHead = null;
            ListNode cur = null;
            int carry = 0;
            for (int sum, val;
                 h1 != null || h2 != null || carry != 0;
                 h1 = h1 == null ? null : h1.next,
                         h2 = h2 == null ? null : h2.next) {

                sum = (h1 == null ? 0 : h1.val)
                        + (h2 == null ? 0 : h2.val)
                        + carry;
                val = sum % 10;
                carry = sum / 10;
                if (newHead == null) {
                    newHead = new ListNode(val);
                    cur = newHead;
                } else {
                    cur.next = new ListNode(val);
                    cur = cur.next;
                }
            }
            return newHead;
        }
    }

    //优化版本
    public static ListNode addTwoNumbers(ListNode h1, ListNode h2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;
        while (h1 != null || h2 != null || carry != 0) {
            int sum = (h1 == null ? 0 : h1.val) + (h2 == null ? 0 : h2.val) + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (h1 != null) h1 = h1.next;
            if (h2 != null) h2 = h2.next;

        }
        return dummyHead.next;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution2 {
        public static ListNode addTwoNumbers(ListNode h1, ListNode h2) {

            //虚拟头节点，最后直接返回dummyHead.next;
            ListNode dummyHead = new ListNode(0);

            //cur表示当前节点，也可以将cur理解为指向末尾的节点指针
            //不需要给dummyHead赋值，即赋值操作为 cur.next = new ListNode(sum %10);
            //这也是为什么使用虚拟头节点，如果不用则
        /* if (newHead == null) {
            newHead = new ListNode(val);
            cur = newHead;
        } else {
            cur.next = new ListNode(val);
            cur = cur.next;
        }*/
            ListNode cur = dummyHead;


            //进位的数
            //不能放在循环体内，否则每次carry都会被初始化
            int carry = 0;

            //有一个链表还没走完，或者两个链表走完了但还有进位 进入循环
            while (h1 != null || h2 != null || carry != 0) {

                // 判断链表走完返回0，没走完返回当前值，加上进位初始默认为0
                int sum = (h1 == null ? 0 : h1.val) + (h2 == null ? 0 : h2.val) + carry;

                //获取进位 这里是/号 不是%号
                carry = sum / 10;

                //给新链表创造下个节点并赋值
                cur.next = new ListNode(sum % 10);

                //移动cur到刚才新创建的节点，也可以将cur理解为指向末尾的节点指针
                cur = cur.next;

                //移动节点指针到下一个节点
                if (h1 != null) h1 = h1.next;
                if (h2 != null) h2 = h2.next;

            }
            return dummyHead.next;
        }
    }
}

    /*for (int sum, val;
                 h1 != null || h2 != null || carry != 0;
                 h1 = h1 == null ? null : h1.next,
                 h2 = h2 == null ? null : h2.next)
    试着改成for循环吗
    */
