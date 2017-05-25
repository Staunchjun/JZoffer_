package NewCode;

/**
 * Created by Administrator on 2017/5/25.
 * 每个线程的run方法中用join方法限定了三个线程的执行顺序。
 * 即便是第二个线程先启动执行了，由于t1.join()方法，
 * 使得线程2需要等待线程1运行结束后才能继续运行。
 * 所以三个线程的启动顺序无关紧要！！！
 */
public class JoinTest2 {

    // 1.现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行

    public static void main(String[] args) {

        final Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("t1");
            }
        });
        final Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    // 引用t1线程，等待t1线程执行完
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2");
            }
        });
        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    // 引用t2线程，等待t2线程执行完
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3");
            }
        });
        t3.start();//这里三个线程的启动顺序可以任意，大家可以试下！
        t2.start();
        t1.start();
    }
}