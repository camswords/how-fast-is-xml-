package com.client.util;

public class ExecutingThread {

    public static void waitATinyBit() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException("failed to wait for a little bit", e);
        }
    }
}
