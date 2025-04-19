package classical.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerAndConsumer {
    static final Object l = new Object();
    static AtomicInteger i = new AtomicInteger();
    public static void main(String[] args) {
        // 生产者
        Runnable p = () -> {
            while (true) {
                synchronized (l) {
                    while (i.get() >= 2) {
                        try {
                            l.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    assert i.get() < 2;
                    print1();
                    l.notify();
                }
            }
        };
        Thread producer = new Thread(p);
        Thread producer1 = new Thread(p);
        Thread producer2 = new Thread(p);

        Runnable c = () -> {
            while (true) {
                synchronized (l) {
                    while (i.get() <= 0) {
                        try {
                            l.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    assert i.get() < 0;
                    print2();
                    l.notify();
                }
            }
        };
        Thread consumer = new Thread(c);
        Thread consumer2 = new Thread(c);

        producer.start();
        producer1.start();
        producer2.start();
        consumer.start();
        consumer2.start();
    }

    private static void print1(){
        System.out.print("{");
        i.incrementAndGet();
    }

    private static void print2(){
        System.out.print("}");
        i.decrementAndGet();
    }
}
