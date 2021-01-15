package ru.job4j.solid.srp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100.55);
        Employee worker2 = new Employee("Vasya", now, now, 333.88);
        store.add(worker);
        store.add(worker2);
        ReportEngine engine = new ReportEngine(store);
        String result = engine.generate(em -> true, ReportFormat.HTML, SalaryTyp.SALARY_TYP_1,
                SortTyp.DESC, EmployerFields.FIRED, EmployerFields.HIRED);
        assertThat(result, is("[name='Vasya', hired=null, fired=null, salary=334.0\n" +
                        ", name='Ivan', hired=null, fired=null, salary=101.0\n" +
                        "] HtmlReport"));
    }

}