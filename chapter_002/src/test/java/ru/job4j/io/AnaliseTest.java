package ru.job4j.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class AnaliseTest {

    private static int index = 0;

    @Test
    public void whenTwoTimeUnavailable() {
        try (var out = new PrintWriter(new FileOutputStream("../source.txt"))) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        new Analise().unavailable("../source.txt", "../target.txt");
        var resultData = List.of("10:57:01;10:59:01;", "11:01:02;11:02:02;");
        try (var in = new BufferedReader(new FileReader("../target.txt"))) {
            in.lines().forEach(n ->
                Assert.assertThat(n, is(resultData.get(index++))));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
