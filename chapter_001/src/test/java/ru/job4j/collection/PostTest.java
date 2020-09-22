package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;

public class PostTest {

    @Test
    public void when5UserInputThen2UserOutput() {
        var mapInput = new LinkedHashMap<String, String>();
        mapInput.put("user1", "xxx@ya.ru,foo@gmail.com,lol@mail.ru");
        mapInput.put("user2", "foo@gmail.com,ups@pisem.net");
        mapInput.put("user3", "xyz@pisem.net,vasya@pupkin.com");
        mapInput.put("user4", "ups@pisem.net,aaa@bbb.ru");
        mapInput.put("user5", "xyz@pisem.net");

        var result = Map.of(
                "user1", "xxx@ya.ru,foo@gmail.com,lol@mail.ru,ups@pisem.net,aaa@bbb.ru",
                "user3", "xyz@pisem.net,vasya@pupkin.com"
        );
        Assert.assertThat(result, is(Post.removeDuplicates(mapInput)));
    }
}
