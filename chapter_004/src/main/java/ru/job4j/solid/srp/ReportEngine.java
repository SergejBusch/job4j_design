package ru.job4j.solid.srp;

import java.util.function.Predicate;

public class ReportEngine implements ReportOutput, Salary, EmployersSalarySort, RemoveFields {
    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter, ReportFormat reportFormat,
                           SalaryTyp salaryTyp, SortTyp sortTyp, EmployerFields... fieldsToRemove) {
        var employers = store.findBy(filter);
        this.getFormattedSalary(employers, salaryTyp);
        this.sort(employers, sortTyp);
        this.removeFields(employers, fieldsToRemove);
        return getFormatReport(employers, reportFormat);
    }
}