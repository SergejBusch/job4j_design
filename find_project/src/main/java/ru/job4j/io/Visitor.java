package ru.job4j.io;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Visitor extends SimpleFileVisitor<Path> {
    Predicate<Path> predicate;
    private final List<String> lines = new ArrayList<>();

    Visitor(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (predicate.test(file)) {
            lines.add(file.getFileName() + " " + file.toAbsolutePath().toString());
        }
        return FileVisitResult.CONTINUE;
    }

    public List<String> getLines() {
        return lines;
    }
}
