package ru.job4j.io;

import java.nio.file.Paths;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        if (args.length != 6) {
            throw new IllegalStateException("Error");
        }
        this.args = args;
    }

    public boolean valid() {
        return args[0].equals("-d")
                && Paths.get(args[1]).toFile().isDirectory()
                && args[2].equals("-e")
                && args[3].startsWith("*.")
                && args[4].equals("-o")
                && args[5].endsWith(".zip");
    }

    public String directory() {
        return args[1];
    }

    public String exclude() {
        return args[3].substring(2);
    }

    public String output() {
        return args[5];
    }
}