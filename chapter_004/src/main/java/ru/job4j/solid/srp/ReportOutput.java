package ru.job4j.solid.srp;

import java.util.List;
import java.util.stream.Collectors;

public interface ReportOutput {

    private static String getXmlReport(List<Employee> employees) {
        return employees.stream().collect(Collectors.toList()).toString() +
                " XmlReport";
    }

    private static String getHtmlReport(List<Employee> employees) {
        return employees.stream().collect(Collectors.toList()).toString() +
                " HtmlReport";
    }

    private static String getCsvReport(List<Employee> employees) {
        return employees.stream().collect(Collectors.toList()).toString() +
                " CsvReport";
    }

    default String getFormatReport(List<Employee> employees, ReportFormat format) {
        switch (format) {
            case HTML:
            return getHtmlReport(employees);

            case XML:
            return getXmlReport(employees);

            default:
            return getCsvReport(employees);
        }

    }
}
