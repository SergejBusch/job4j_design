package ru.job4j.io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class AnaliseTest {

    private static int index = 0;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenTwoTimeUnavailable() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (var out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        new Analise().unavailable(source.getPath(), target.getPath());
        var resultData = List.of("10:57:01;10:59:01;", "11:01:02;11:02:02;");
        try (var in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(n ->
                Assert.assertThat(n, is(resultData.get(index++))));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
