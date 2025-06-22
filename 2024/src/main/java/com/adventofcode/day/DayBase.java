package com.adventofcode.day;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

public abstract class DayBase {
    public abstract void doit() throws Exception;

    protected File getResource(String name) {
        Objects.requireNonNull(name, "Invalid filename");

        URL resource = getClass().getClassLoader().getResource(name);
        if (resource == null) {
            throw new IllegalArgumentException("file not found: " + name);
        }
        try {
            return new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    protected List<String> readFile(File file) {
        try {
            return Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    protected List<String> readFile(String resource) {
        try {
            return Files.readAllLines(getResource(resource).toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
