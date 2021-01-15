package ru.job4j.solid.srp;

import java.util.List;
import java.util.stream.Collectors;

public interface Salary {

    private static List<Employee> typ1(List<Employee> employees) {
        return employees.stream().peek(e ->
                e.setSalary(Double.parseDouble(SalaryFormats.DF_CANADA.format(
                        e.getSalary())))).collect(Collectors.toList());
    }

    private static List<Employee> typ2(List<Employee> employees) {
        return employees.stream().peek(e ->
                e.setSalary(Double.parseDouble(SalaryFormats.DF_CHINESE.format(
                        e.getSalary())))).collect(Collectors.toList());
    }

    default List<Employee> getFormattedSalary(List<Employee> employees, SalaryTyp typ) {
        switch (typ) {
            case SALARY_TYP_1:
                return typ1(employees);

            case SALARY_TYP_2:
                return typ2(employees);

            default:
                return employees;
        }

    }
}
