package Niuke.netease;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

//构造队列
//题目描述
//小明同学把1到n这n个数字按照一定的顺序放入了一个队列Q中。现在他对队列Q执行了如下程序：
//while(!Q.empty())              //队列不空，执行循环
//
//{
//
//    int x=Q.front();            //取出当前队头的值x
//
//    Q.pop();                 //弹出当前队头
//
//    Q.push(x);               //把x放入队尾
//
//    x = Q.front();              //取出这时候队头的值
//
//    printf("%d\n",x);          //输出x
//
//    Q.pop();                 //弹出这时候的队头
//
//}
//
//做取出队头的值操作的时候，并不弹出当前队头。
//小明同学发现，这段程序恰好按顺序输出了1,2,3,...,n。现在小明想让你构造出原始的队列，你能做到吗？[注：原题样例第三行
//5有错，应该为3，以下已修正]
//输入描述:
//第一行一个整数T（T ≤ 100）表示数据组数，每组数据输入一个数n（1 ≤ n ≤ 100000），输入的所有n之和不超过200000。
//输出描述:
//对于每组数据，输出一行，表示原始的队列。数字之间用一个空格隔开，不要在行末输出多余的空格.
//示例1
//输入
//4
//1
//2
//3
//10
//输出
//1
//2 1
//2 1 3
//8 1 6 2 10 3 7 4 9 5
public class ConstructQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        for (int j = 0; j < sum; j++) {
            int num = sc.nextInt();
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = num; i >= 1; i--) {
                deque.addFirst(i);
                Integer t = deque.pollLast();
                deque.addFirst(t);
            }
            Iterator<Integer> iterator = deque.iterator();
            StringBuffer sb = new StringBuffer();
            while (iterator.hasNext()) {
                sb.append(iterator.next() + " ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
