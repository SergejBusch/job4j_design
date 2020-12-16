package ru.job4j;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoGC {
    public static final long KB = 1000;
    public static final long MB = KB * KB;
    public static final Runtime ENVIRONMENT = Runtime.getRuntime();
    private static final Logger LOG = LoggerFactory.getLogger(DemoGC.class);
    User user = new User(4, 7, "taDa");

    public static void info() {
        LOG.info(VM.current().details());
        System.out.println(ClassLayout.parseClass(DemoGC.class).toPrintable());
        System.out.println(GraphLayout.parseInstance(new DemoGC()).toPrintable());
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }

    public static void main(String[] args) {
        org.apache.log4j.BasicConfigurator.configure();
        var user = new User(1, 1, "");
        for (int i = 0; i < 100; i++) {
            new User(10, i, "e");
        }
        info();
    }
}
