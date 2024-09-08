package class013队列和栈;

public class code {
    // 队列
    // enqueue 或 offer: 将元素添加到队列尾部。
    //	作用：向队列尾部添加一个新元素。

    //	dequeue 或 poll: 移除并返回队列头部的元素。
    //	作用：移除并返回队列头部的元素。

    //	peek: 返回队列头部的元素，但不移除它。
    //	作用：获取队列头部的元素值，但不改变队列的结构。

    public static class Queue {

        public int[] Queue;
        public int left;
        public int right;

        public Queue(int n) {
            Queue = new int[n];
            left = right = 0;
        }

        public boolean isEmpty() {
            return left == right;
        }

        //offer
        public void enQueue(int x) {
            Queue[right++] = x;
        }

        //poll
        public int deQueue() {
            return Queue[left++];
        }

        //head
        public int peek() {
            return Queue[left];
        }
    }

//    push: 将元素压入栈顶。
//    作用：向栈顶添加一个新元素。

//    pop: 弹出栈顶元素。
//    作用：移除并返回栈顶的元素。

//    peek 或 top: 返回栈顶元素，但不移除它。
//    作用：获取栈顶的元素值，但不改变栈的结构。

    public static class Stack {

        public int[] stack;
        public int size;

        public Stack(int n) {
            stack = new int[n];
            size = 0;
        }

        public void push(int x) {
            stack[size++] = x;
        }

        public int pop() {
            return stack[--size];
        }

        //top
        public int peek() {
            return stack[size - 1];
        }
    }


}
