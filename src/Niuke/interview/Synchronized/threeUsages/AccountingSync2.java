package Niuke.interview.Synchronized.threeUsages;

//修饰静态方法，作用于当前类对象加锁，进入同步代码前要获得当前类对象的锁
//当synchronized作用于静态方法时，其锁就是当前类的class对象锁。由于静态成员不专属于任何一个实例对象，是类
//成员，因此通过class对象锁可以控制静态 成员的并发操作。
public class AccountingSync2 implements Runnable {
    static int i = 0;

    /**
     * 作用于静态方法,锁是当前class对象,也就是
     * AccountingSyncClass类对应的class对象
     */
    public static synchronized void increase() {
        i++;
    }

    /**
     * 非静态,访问时锁不一样不会发生互斥
     */
    public synchronized void increase4Obj() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //new新实例
        Thread t1 = new Thread(new AccountingSync2());
        //new新实例
        Thread t2 = new Thread(new AccountingSync2());
        //启动线程
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);
    }
}
