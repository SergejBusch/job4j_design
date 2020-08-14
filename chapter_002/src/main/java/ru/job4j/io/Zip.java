package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, Path target) {
        try (var zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target.toFile().getPath())))) {
            for (Path n : sources) {
                zip.putNextEntry(new ZipEntry(n.toFile().getPath()));
                try (var out = new BufferedInputStream(new FileInputStream(n.toFile().getPath()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void packSingleFile(Path source, Path target) {
        packFiles(List.of(source), target);
    }

    public static void main(String[] args) throws IOException {
        var argZip = new ArgZip(args);
        if (!argZip.valid()) {
            return;
        }
        var search = new SearchFiles(p -> !p.toFile()
                .getName().endsWith(argZip.exclude()));
        Files.walkFileTree(Paths.get(argZip.directory()), search);
        var list = search.getPaths();
        new Zip().packFiles(list, Paths.get(argZip.output()));
    }
}