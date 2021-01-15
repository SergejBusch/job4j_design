package ru.job4j.solid.srp;

import java.util.List;

public interface RemoveFields {
    default void removeFields(List<Employee> employers, EmployerFields... fields) {
       for (var field : fields) {
               for (var employee : employers) {
                   switch (field) {
                       case NAME:
                           employee.setName("");
                           break;
                       case FIRED:
                           employee.setFired(null);
                           break;
                       case HIRED:
                           employee.setHired(null);
                           break;
                       case SALARY:
                           employee.setSalary(-1);
                           break;
                       default:
                           //nothing
                   }
           }
        }
    }
}
