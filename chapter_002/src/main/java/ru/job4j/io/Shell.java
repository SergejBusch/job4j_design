package ru.job4j.io;

import java.util.*;

public class Shell {
    ModifiedList<String> root = new ModifiedList<>();
    ModifiedList<String> dir = root;
    ArrayList<String> pwdPaths = new ArrayList<>();

    public Shell() {
        root.data = "/";
        pwdPaths.add(root.data);
    }

    public void cd(String path) {
        String[] paths;
        if ((paths = split(path)) != null) {
            for (String p : paths) {
                cd(p);
            }
        } else if  (path.equals("/")) {
            dir = root;
        } else if (path.equals("..")) {
            if (dir.parent != null) {
                dir = dir.parent;
                this.pwdPaths.remove(this.pwdPaths.size() - 2);
            }
        } else {
            if (!dir.children.isEmpty()) {
                for (ModifiedList<String> node : dir.children) {
                    if (node.data.equals(path)) {
                        dir = node;
                        this.pwdPaths.add(dir.data);
                    }
                }
            } else {
                var newNode = new ModifiedList<String>();
                newNode.parent = dir;
                newNode.data = path;
                dir.children.add(newNode);
                dir = newNode;
                this.pwdPaths.add(dir.data);
            }
        }
    }

    public String pwd() {
        if (pwdPaths.size() > 1) {
            StringBuilder path = new StringBuilder();
            for (int i = 1; i < pwdPaths.size(); i++) {
                path.append("/").append(pwdPaths.get(i));
            }
            return path.toString();
        }
        return dir.data;
    }

    private String[] split(String path) {
        String[] split;
        if (path.substring(1).contains("/")) {
            split =  path.substring(1).split("/");
            if (path.charAt(0) == '/') {
                String[] splitCopy = new String[split.length + 1];
                splitCopy[0] = "/";
                System.arraycopy(split, 0, splitCopy, 1, split.length);
                return splitCopy;
            }
            return split;
        }
        return null;
    }


}

class ModifiedList<E> extends ArrayList<E> {
    public ModifiedList<E> parent;
    public List<ModifiedList<E>> children = new ArrayList<>();
    public E data;
}

