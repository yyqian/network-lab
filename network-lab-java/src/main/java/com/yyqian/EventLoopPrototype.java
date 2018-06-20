package com.yyqian;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Author: Yinyin Qian
 * Date: 2018-06-20
 */
public class EventLoopPrototype {
    private static final ScheduledThreadPoolExecutor eventGenerator = (ScheduledThreadPoolExecutor) Executors
            .newScheduledThreadPool(1);
    private static int counter = 0;

    static class Event implements Runnable {
        @Override
        public void run() {
            System.out.println("Current counter: " + ++counter);
        }
    }

    private static List<Runnable> blockUntilEventsReady() {
        List<Runnable> events = new ArrayList<>();
        events.add(new Event());
        events.add(new Event());
        events.add(new Event());
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return events;
    }

    public static void main(String[] args) {
        // 单线程跑的
        while (true) {
            List<Runnable> readyEvents = blockUntilEventsReady();
            for (Runnable events : readyEvents) {
                events.run();
            }
        }
    }
}
