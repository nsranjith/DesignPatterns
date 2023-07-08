package Threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Client {

    public static void main(String[] args) {
//        Queue<Object> object = new ConcurrentLinkedDeque<>();
//        int maxSize = 6;
//
//        Semaphore producerSemaphore = new Semaphore(maxSize);
//        Semaphore consumerSemaphore = new Semaphore(0);
//
//        Producer p = new Producer(object, maxSize,"p", producerSemaphore, consumerSemaphore);
//        Producer p1 = new Producer(object, maxSize,"p1",producerSemaphore, consumerSemaphore);
//        Producer p2= new Producer(object, maxSize,"p2",producerSemaphore, consumerSemaphore);
//
//        Consumer c = new Consumer(object, maxSize,"c",consumerSemaphore,producerSemaphore );
//        Consumer c1 = new Consumer(object, maxSize,"c1",consumerSemaphore,producerSemaphore);
//        Consumer c2 = new Consumer(object, maxSize,"c2",consumerSemaphore,producerSemaphore);
//        Consumer c3 = new Consumer(object, maxSize,"c3",consumerSemaphore,producerSemaphore);
//        Consumer c4 = new Consumer(object, maxSize,"c4",consumerSemaphore,producerSemaphore);
//
//        Thread t1 = new Thread(p);
//        Thread t2 = new Thread(p1);
//        Thread t3 = new Thread(p2);
//
//        Thread tc1 = new Thread(c);
//        Thread tc2 = new Thread(c1);
//        Thread tc3= new Thread(c2);
//        Thread tc4 = new Thread(c3);
//        Thread tc5 = new Thread(c4);
//
//        t1.start();
//        t2.start();
//        t3.start();
//        tc4.start();
//        tc1.start();
//        tc5.start();
//        tc2.start();
//        tc3.start();
        AtomicInteger atomicInteger=new AtomicInteger(-1);
        Semaphore even=new Semaphore(1);
        Semaphore odd=new Semaphore(0);
        Thread t1=new Thread(new Even(even,odd,atomicInteger));
        Thread t2=new Thread(new Odd(even,odd,atomicInteger));
        t1.start();
        t2.start();
    }

}
