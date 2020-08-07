package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class DuplicateSearch implements FileVisitor<Path> {
    private List<Path> allFiles = new ArrayList<>();

    @Override
    public FileVisitResult preVisitDirectory(
            Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        var add = true;
        for (Path path : allFiles) {
            if (!Files.isDirectory(file)
                    && path.toFile().getName().equals(file.toFile().getName())
                    && path.toFile().length() == file.toFile().length()) {
                System.out.println("Duplicate found!" + System.lineSeparator()
                        + "name : "  + path.toFile().getName() + System.lineSeparator()
                        + "location : " + path.toFile().getPath() + System.lineSeparator()
                        + "and : " + file.toFile().getPath() + System.lineSeparator()
                        + "----");
                add = false;
            }
        }
        if (!Files.isDirectory(file) && add) {
            allFiles.add(file);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        Files.walkFileTree(path, new DuplicateSearch());
    }
}
