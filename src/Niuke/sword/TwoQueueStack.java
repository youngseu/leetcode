package Niuke.sword;

import java.util.LinkedList;

//用两个队列实现一个栈
public class TwoQueueStack {
    private LinkedList<String> queue1;
    private LinkedList<String> queue2;

    public TwoQueueStack() {
        queue1 = new LinkedList<String>();
        queue2 = new LinkedList<String>();
    }

    public String pop() {
        String re = null;
        if (queue1.size() == 0 && queue2.size() == 0) {
            return null;
        }
        if (queue2.size() == 0) {
            while (queue1.size() > 0) {
                re = queue1.removeFirst();
                if (queue1.size() != 0) {
                    queue2.addLast(re);
                }
            }
        } else if (queue1.size() == 0) {
            while (queue2.size() > 0) {
                re = queue2.removeFirst();
                if (queue2.size() != 0) {
                    queue1.addLast(re);
                }
            }
        }
        return re;
    }

    public String push(String str) {
        if (queue1.size() == 0 && queue2.size() == 0) {
            queue1.addLast(str);
        } else if (queue1.size() != 0) {
            queue1.addLast(str);
        } else if (queue2.size() != 0) {
            queue2.addLast(str);
        }
        return str;
    }

}
