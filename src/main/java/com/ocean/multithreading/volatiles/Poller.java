package com.ocean.multithreading.volatiles;

public class Poller implements Runnable {

    private volatile boolean running = true; // missing volatile

    @Override
    public void run() {
        System.out.println("Poller started");

        while (running) {
            // CPU work
            int x = 0;
            for (int i = 0; i < 1000000; i++) {
                x += i;
            }
        }

        System.out.println("Poller stopped");
    }

    public void stop() {
        running = false; // may not be visible
    }
}

class TestPollerBroken {
    public static void main(String[] args) throws Exception {
        Poller poller = new Poller();
        Thread t = new Thread(poller);
        t.start();

        Thread.sleep(1000);
        System.out.println("Requesting stop...");
        poller.stop();  // might not be seen

        t.join(); // may hang forever
        System.out.println("Main thread exiting");
    }
}
