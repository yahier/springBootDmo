package com.yahier.demo.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class TestAsync {

    @Async
    public Future<Boolean> test1() {
        Long start = System.currentTimeMillis();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("test1 duration:" + (end - start));
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> test2() {
        Long start = System.currentTimeMillis();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("test2 duration:" + (end - start));
        return new AsyncResult<>(true);
    }
}
