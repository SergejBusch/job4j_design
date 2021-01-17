package ru.job4j.solid.srp;

import java.util.ArrayList;
import java.util.List;

public class PrintXml implements ReportPrinter {
    @Override
    public String print(List<Employee> employees) {
        return new ArrayList<>(employees).toString() +
                " XmlReport";
    }
}
