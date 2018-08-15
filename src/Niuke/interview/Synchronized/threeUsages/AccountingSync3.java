package Niuke.interview.Synchronized.threeUsages;

//修饰代码块，指定加锁对象，对给定对象加锁，进入同步代码库前要获得给定对象的锁
//除了使用关键字修饰实例方法和静态方法外，还可以使用同步代码块，在某些情况下，我们编写的方法体可能比较大，同时存在
//一些比较耗时的操作，而需要同步的代码又只有一小部分，如果直接对整个方法进行同步操作，可能会得不偿失，此时我们可以
//使用同步代码块的方式对需要同步的代码进行包裹，这样就无需对整个方法进行同步操作了

//需要注意的是如果一个线程A调用一个实例对象的非static synchronized方法，而线程B需要调用这个实例对象所属类的静态
//synchronized方法，是允许的，不会发生互斥现象，因为访问静态 synchronized 方法占用的锁是当前类的class对象，而访
//问非静态 synchronized 方法占用的锁是当前实例对象锁，看如下代码
public class AccountingSync3 implements Runnable {
    static AccountingSync3 instance = new AccountingSync3();
    static int i = 0;

    @Override
    public void run() {
        //省略其他耗时操作....
        //使用同步代码块对变量i进行同步操作,锁对象为instance
        synchronized (instance) {
            for (int j = 0; j < 1000000; j++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
