package Threads;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer  implements  Runnable{
    Queue<Object> objects;
    int maxSize=0;
    String name;
    Semaphore consumer;
    Semaphore producer;
    public Consumer(Queue<Object> object, int maxSize, String c, Semaphore consumerSemaphore, Semaphore producer) {
        this.objects=object;
        this.maxSize=maxSize;
        this.name=c;
        this.consumer=consumerSemaphore;
        this.producer=producer;
    }

    @Override
    public void run() {
            while(true){
                try {
                    consumer.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(objects.size()>0){
                    System.out.println(name +" is consuming");
                    objects.remove();
                }
                producer.release();
            }
    }
}
