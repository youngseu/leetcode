package Niuke.interview;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FockJoinTest extends RecursiveTask<Long> {//继承RecursiveTask来实现
    //设立一个最大计算容量
    private final int DEFAULT_CAPACITY = 10000;


    //用2个数字表示目前要计算的范围
    private int start;

    private int end;

    public FockJoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {//实现compute方法
        //分为两种情况进行出来
        long sum = 0;
        //如果任务量在最大容量之内
        if (end - start < DEFAULT_CAPACITY) {
            for (int i = start; i < end; i++) {
                sum += i;
            }
        } else {//如果超过了最大容量，那么就进行拆分处理
            //计算容量中间值
            int middle = (start + end) / 2;
            //进行递归
            FockJoinTest fockJoinTest1 = new FockJoinTest(start, middle);
            FockJoinTest fockJoinTest2 = new FockJoinTest(middle + 1, end);
            //执行任务
            fockJoinTest1.fork();
            fockJoinTest2.fork();
            //等待任务执行并返回结果
            sum = fockJoinTest1.join() + fockJoinTest2.join();
        }

        return sum;
    }


    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FockJoinTest fockJoinTest = new FockJoinTest(1, 100000000);
        long fockhoinStartTime = System.currentTimeMillis();
        //前面我们说过，任务提交中invoke可以直接返回结果
        long result = forkJoinPool.invoke(fockJoinTest);
        System.out.println("fock/join计算结果耗时" + (System.currentTimeMillis() - fockhoinStartTime));

        long sum = 0;
        long normalStartTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            sum += i;
        }
        System.out.println("普通计算结果耗时" + (System.currentTimeMillis() - normalStartTime));
    }

}