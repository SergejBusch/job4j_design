package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int i = 33;
        double d = 70.5;
        char a = 'a';
        float f = 5.5f;
        short s = 8;
        boolean b = s + f > i;
        byte by = 9;
        long l = 10;
        LOG.debug(" {},  {},  {},  {},  {},  {},  {},  {}", i, d, a, f, s, b, by, l);
    }
}