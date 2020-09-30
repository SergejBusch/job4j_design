package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.is;

public class PostTest {

    @Test
    public void when5UserInputThen2UserOutput() {
        var mapInput = new LinkedHashMap<String, Set<String>>();
        mapInput.put("user1", new HashSet<>(Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")));
        mapInput.put("user2", new HashSet<>(Set.of("foo@gmail.com", "ups@pisem.net")));
        mapInput.put("user3", new HashSet<>(Set.of("xyz@pisem.net", "vasya@pupkin.com")));
        mapInput.put("user4", new HashSet<>(Set.of("ups@pisem.net", "aaa@bbb.ru")));
        mapInput.put("user5", new HashSet<>(Set.of("xyz@pisem.net")));

        var result = Map.of(
                "user4", new HashSet<>(Set.of("aaa@bbb.ru", "foo@gmail.com",
                        "lol@mail.ru", "ups@pisem.net", "xxx@ya.ru")),
                "user5", new HashSet<>(Set.of("vasya@pupkin.com", "xyz@pisem.net"))
        );
        Assert.assertThat(result, is(Post.removeDuplicates(mapInput)));
    }
}
