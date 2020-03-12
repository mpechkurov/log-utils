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

public class LogParser {

    public Set<ServiceData> getLogInfo(String fileName) {
        LogStringUtils logStringUtils = new LogStringUtils();
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

            serviceData.forEach(s -> s.setLongestRequestTimeInSeconds(requestTime.get(s.getName())));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return serviceData;
    }
}
