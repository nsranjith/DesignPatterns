package Threads;

import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class Even implements Runnable{
    Semaphore even;
    Semaphore odd;
    AtomicInteger atomicInteger;

    public Even(Semaphore even, Semaphore odd, AtomicInteger atomicInteger) {
        this.even = even;
        this.odd = odd;
        this.atomicInteger = atomicInteger;
    }


    @SneakyThrows
    @Override
    public void run() {
        while(atomicInteger.get()<100) {
            even.acquire();
            System.out.println(atomicInteger.incrementAndGet());
            odd.release();
        }
    }
}
