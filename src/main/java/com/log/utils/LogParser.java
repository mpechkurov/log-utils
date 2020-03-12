package com.log.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

//    1. Name of service
//    2. Amount of request to service
//    3. Max time of request execution

public class LogParser {

    public static void main(String[] args) {
        LogStringUtils logStringUtils = new LogStringUtils();
        String fileName = "src/main/resources/test.log";
        Set<ServiceData> serviceData = new HashSet<>();
        Map<String, Long> requestTime = new HashMap<>();
        Map<String, LocalDateTime> bufferRequestMap = new HashMap<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> {
                               String serviceName = logStringUtils.getServiceName(line);
                               boolean isEntry = logStringUtils.isEntryRequest(line);
                               serviceData.add(new ServiceData(serviceName));
                               if (isEntry) {
                                   serviceData.stream().filter(o -> o.getName().equals(serviceName)).findFirst()
                                              .ifPresent(ServiceData::updateRequestAmount);
                               }
                               logStringUtils.getRequestTime(line, requestTime, bufferRequestMap);
                           });

        } catch (IOException e) {
            e.printStackTrace();
        }
        serviceData.forEach(System.out::println);
        System.out.println(requestTime);
    }
}
