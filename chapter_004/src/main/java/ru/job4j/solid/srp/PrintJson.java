package ru.job4j.solid.srp;

import java.util.ArrayList;
import java.util.List;

public class PrintJson implements ReportPrinter {
    @Override
    public String print(List<Employee> employees) {
        return new ArrayList<>(employees).toString() +
                " JsonReport";
    }
}
