package Threads;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    Queue<Object> objects;
    int maxSize=0;
    String name;
    Semaphore producer;
    Semaphore consumer;
    public Producer(Queue<Object> object, int maxSize, String p, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.objects=object;
        this.maxSize=maxSize;
        this.name=p;
        this.producer=producerSemaphore;
        this.consumer=consumerSemaphore;
    }

    @Override
    public void run() {
        while(true){
            try {
                producer.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(objects.size()<maxSize){
                System.out.println(name +" is producing");
                objects.add(new Object());
            }
            consumer.release();

        }
    }
}
