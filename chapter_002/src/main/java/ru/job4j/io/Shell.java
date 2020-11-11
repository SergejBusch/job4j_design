package ru.job4j.io;

import java.util.*;

public class Shell {
    String dir = "/";
    Map<String, String> map;

    public Shell() {
        map = new LinkedHashMap<>();
        map.put("/", "/");
        map.put("user", "/user");
        map.put("local", "/user/local");
    }

    public void cd(String path) {
       split(path);
       if (path.equals("..")) {
           positionDecrement();
       } else {
           dir = map.getOrDefault(path, dir);

       }
    }

    public String pwd() {
        return dir;
    }

    private void split(String paths) {
        if (paths.substring(1).contains("/")) {
            for(String path : paths.substring(1).split("/")) {
                cd(path);
            }
        }
    }

    private void positionDecrement() {
       var list = new ArrayList<>(map.values());
       int index = list.indexOf(dir);
       dir = index > 0 ? list.get(--index) : dir;

    }


}
