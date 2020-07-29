package ru.job4j.statistics;

import java.util.*;

public class Analyze {
    private Info info;

    public Info diff(List<User> previous, List<User> current) {
        var info = new Info(0, 0, 0);
        var map = new HashMap<Integer, User>();
        previous.forEach(n -> map.put(n.id, n));
        for (User user : current) {
            if (map.containsKey(user.id)
                    && !map.get(user.id).name.equals(user.name)) {
                info.changed++;
            } else if (!map.containsValue(user)) {
                info.deleted++;
            }
            info.added = current.size()
                    + info.deleted
                    - previous.size();
        }
        return info;
        }

        public static class User {
            int id;
            String name;

            public User(int id, String name) {
                this.id = id;
                this.name = name;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                User user = (User) o;
                return id == user.id
                        && Objects.equals(name, user.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(id, name);
            }
        }

        public static class Info {
            int added;
            int changed;
            int deleted;

            public Info(int added, int changed, int deleted) {
                this.added = added;
                this.changed = changed;
                this.deleted = deleted;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                Info info = (Info) o;
                return added == info.added
                        && changed == info.changed
                        && deleted == info.deleted;
            }

            @Override
            public int hashCode() {
                return Objects.hash(added, changed, deleted);
            }
        }

}

