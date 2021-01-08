package ru.job4j;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;

public class CacheTest {
    @Test
    public void whenCreateFiles() throws IOException {
        String name = "Vasya";
        Path names = Paths.get("../Names.txt");
        Files.writeString(names, name);

        String address = "Street 5";
        Path addresses = Paths.get("../Address.txt");
        Files.writeString(addresses, address);
        assertThat(names.getFileName().toString(), is("Names.txt"));
        assertThat(addresses.getFileName().toString(), is("Address.txt"));
    }

    @Test
    public void whenGetFileContent() throws IOException {
        var cache = new Cache();
        assertThat(cache.get("../Names.txt"), is("Vasya"));
        assertThat(cache.get("../Address.txt"), is("Street 5"));
    }
}
