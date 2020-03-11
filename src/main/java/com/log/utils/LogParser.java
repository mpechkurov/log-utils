package com.log.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

//    1. Name of service
//    2. Amount of request to service
//    3. Max time of request execution

public class LogParser {
    public static void main(String[] args) {
        LogStringUtils logStringUtils = new LogStringUtils();
        String fileName = "src/main/resources/test.log";
        Set<String> services = new HashSet<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> services.add(logStringUtils.getServiceName(line)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(services);

    }
}
