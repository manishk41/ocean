package com.ocean.multithreading.volatiles;

class WorkerService implements Runnable {

    private boolean running = true;

    @Override
    public void run() {
        System.out.println("Worker started...");

        while (running) {
            // simulate doing work
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
        }

        System.out.println("Worker stopped.");
    }

    public void stopWorker() {
        running = false;   // happens-before the run() loop exit
    }
}

class Main {

    public static void main(String[] args) throws Exception {
        WorkerService service = new WorkerService();
        Thread t = new Thread(service);
        t.start();

        Thread.sleep(2000);  // let it run
        service.stopWorker(); // visible because running is volatile
    }
}