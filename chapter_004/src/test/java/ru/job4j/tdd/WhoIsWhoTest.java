package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WhoIsWhoTest {

    @Ignore
    @Test(expected = Exception.class)
    public void templateKeysCheck() {
        new WhoIsWho().produce("${lastname}", new HashMap<>());
    }

    @Ignore
    @Test(expected = Exception.class)
    public void mapKeysCheck() {
        new WhoIsWho().produce("I am a ${name}, Who are ${subject}? ", Map.of("lastname", "Smith"));
    }
}
