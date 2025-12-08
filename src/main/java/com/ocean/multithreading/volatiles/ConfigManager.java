package com.ocean.multithreading.volatiles;

import java.util.*;

public class ConfigManager implements Runnable {

    private volatile Map<String, String> config = Map.of("feature", "off");

    @Override
    public void run() {

        while (true) {
            if ("on".equals(config.get("feature"))) {
                System.out.println(Thread.currentThread().getName() + " → Feature is ON");
            }
        }
    }

    public void updateConfig(Map<String, String> newConfig) {
        this.config = newConfig; // may never be seen by run()
    }
}

class TestConfigBroken {
    public static void main(String[] args) throws Exception {
        ConfigManager cm = new ConfigManager();

        Thread worker = new Thread(cm, "Worker");
        worker.start();

        Thread.sleep(2000);
        System.out.println("Updating config...");

        cm.updateConfig(Map.of("feature", "on"));

        worker.join();
    }
}
