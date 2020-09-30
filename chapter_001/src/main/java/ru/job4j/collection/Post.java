package ru.job4j.collection;
import java.util.*;

public class Post {

    public static Map<String, Set<String>> removeDuplicates(
            LinkedHashMap<String, Set<String>> mapInput) {
        Map<String, String> mailAsKeyUserAsValue = new HashMap<>();
        Map<String, Set<String>> result = new LinkedHashMap<>();

        for (Map.Entry<String, Set<String>> entry : mapInput.entrySet()) {
            String name;
            for (String mail : entry.getValue()) {
                if (mailAsKeyUserAsValue.containsKey(mail)) {
                    name = mailAsKeyUserAsValue.get(mail);
                    var temp = new TreeSet<>(result.get(name));
                    temp.addAll(entry.getValue());
                    result.put(entry.getKey(), temp);
                    result.remove(name);
                    break;
                }
            }
            result.putIfAbsent(entry.getKey(), entry.getValue());
            for (String mail : result.get(entry.getKey())) {
                mailAsKeyUserAsValue.put(mail, entry.getKey());
            }

        }
        return result;
    }
}
