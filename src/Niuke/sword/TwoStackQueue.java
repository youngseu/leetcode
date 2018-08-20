package Niuke.sword;

import java.util.Stack;

public class TwoStackQueue {

    /**
     * 用两个栈实现一个队列，完成两个函数appendTail和deletedHead,分别是在队列尾部插入节点
     * 和在队列头部删除节点的功能
     */
    private Stack<String> stack1 = new Stack<String>();
    private Stack<String> stack2 = new Stack<String>();

    public void appendTail(String s) {
        stack1.push(s);
    }

    public String deletedHead() throws Exception {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new Exception("队列为空，不能删除");
        }
        return stack2.pop();
    }

    public static void main(String[] args) throws Exception {
        TwoStackQueue test = new TwoStackQueue();
        test.appendTail("1");
        test.appendTail("2");
        test.deletedHead();
    }

}
