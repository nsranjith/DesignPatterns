package Threads;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Odd implements Runnable{

    Semaphore even;
    Semaphore odd;
    AtomicInteger atomicInteger;

    public Odd(Semaphore even, Semaphore odd, AtomicInteger atomicInteger) {
        this.even = even;
        this.odd = odd;
        this.atomicInteger = atomicInteger;
    }


    @SneakyThrows
    @Override
    public void run() {
        while(atomicInteger.get()<100) {
            odd.acquire();
            System.out.println(atomicInteger.incrementAndGet());
            even.release();
        }
    }
}
