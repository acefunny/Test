package thread;


import java.util.concurrent.atomic.AtomicInteger;

public class CirclTest implements Runnable{

    private static final AtomicInteger retries = new AtomicInteger(10);

    public void run() {

        System.out.println("Do something on DEV");
    }
}