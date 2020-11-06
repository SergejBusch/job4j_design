package ru.job4j.io;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Shell {
    private final String root = "/";
    private LinkedList<String> rootDirs = new LinkedList<>();
    private File temp;
    private ListIterator<String> listIterator;

    public Shell() {
        rootDirs.addAll(List.of("root", "user", "local"));
        temp = new File("root/user/local");
        temp.mkdirs();
        temp = new File("root");
        listIterator = rootDirs.listIterator(1);
    }

    public void cd(String path) {
        if (path.charAt(0) == root.charAt(0)) {
            if (path.length() > 1) {
                String pathFromFirstIndex = path.substring(1);
                if (pathFromFirstIndex.contains("/")) {
                    String[] dirs = pathFromFirstIndex.split("/");
                    listIterator = rootDirs.listIterator(1);
                    for (String dir : dirs) {
                        cd(dir);
                    }
                }
            } else {
                temp = new File("root");
            }
        } else {
            if (path.equals("..")) {
                if (listIterator.hasPrevious()) {
                    temp = getPath(rootDirs.indexOf(listIterator.previous()));
                }
            } else if (listIterator.hasNext()) {
                String dir;
                if (path.equals(dir = listIterator.next())) {
                    temp = getPath(rootDirs.indexOf(dir) + 1);
                } else {
                    listIterator.previous();
                }
            }
        }
    }

    public String pwd() {
        String result = temp.getPath().replace("root/", root);
        result = result.equals("root") ? root : result;
        return result;
    }

    private File getPath(int index) {
        if (index > 0) {
            List<String> list = rootDirs.subList(0, index);
            StringBuilder tempPath = new StringBuilder();
            for (String temp : list) {
                tempPath.append(temp).append("/");
            }
            return new File(tempPath.toString());
        }
        return temp;
    }
}
