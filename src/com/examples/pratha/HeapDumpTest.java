package com.examples.pratha;

import java.util.ArrayList;
import java.util.List;

public class HeapDumpTest {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("String " + i);
        }
        System.out.println("App running... Press Ctrl+C to exit.");

        // Keep it running so you can attach tools
        Thread.sleep(60000); // 60 seconds
    }
}
