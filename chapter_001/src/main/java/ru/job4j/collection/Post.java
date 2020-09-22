package ru.job4j.collection;

import java.util.*;

public class Post {

    public static Map<String, String> removeDuplicates(Map<String, String> mapInput) {
        Map<String, String> mailAsKeyUserAsValue = new HashMap<>();
        Map<String, String> result = new LinkedHashMap<>();

        for (Map.Entry<String, String> entry : mapInput.entrySet()) {
            String[] emails = entry.getValue().split(",");
            boolean duplicateExist = false;
            String user = null;
            List<Integer> notDuplicateIndexes = new ArrayList<>(emails.length);

            for (int i = 0; i < emails.length; i++) {
                if (mailAsKeyUserAsValue.get(emails[i])  != null) {
                    user = mailAsKeyUserAsValue.get(emails[i]);
                    duplicateExist = true;
                } else {
                    notDuplicateIndexes.add(i);
                }
            }
            if (!duplicateExist) {
                for (String email : emails) {
                    mailAsKeyUserAsValue.put(email, entry.getKey());
                }
                result.put(entry.getKey(), entry.getValue());
            } else {
                StringBuilder emailsString = new StringBuilder(result.get(user));
                for (Integer notDuplicateIndex : notDuplicateIndexes) {
                    emailsString.append(",");
                    emailsString.append(emails[notDuplicateIndex]);
                    mailAsKeyUserAsValue.put(emails[notDuplicateIndex], user);
                }
                result.put(user, emailsString.toString());
            }
        }
        return result;
    }
}
