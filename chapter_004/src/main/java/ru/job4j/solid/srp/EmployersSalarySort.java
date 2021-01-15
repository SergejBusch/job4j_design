package ru.job4j.solid.srp;

import java.util.Comparator;
import java.util.List;

public interface EmployersSalarySort {

    private static void descSort(List<Employee> employeeList) {
        employeeList.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
    }

    private static void naturalSort(List<Employee> employeeList) {
        employeeList.sort(Comparator.comparingDouble(Employee::getSalary));
    }

    @SuppressWarnings("checkstyle:Exception")
    default void sort(List<Employee> employeeList, SortTyp typ) {
        if (typ == SortTyp.DESC) {
            descSort(employeeList);
        } else {
            naturalSort(employeeList);
        }
    }
}
