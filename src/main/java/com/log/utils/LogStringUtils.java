package com.log.utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogStringUtils {

    public static final String ENTRY_LOG_STRING = "entry";
    public static final String REGEX_SERVICE_AND_ID = "\\((.*)\\)";
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss,SSS");

    String getServiceName(String line) {
        return getServiceNameAndId(line).split(":")[0];
    }

    public boolean isEntryRequest(String line) {
        return line.contains(ENTRY_LOG_STRING);
    }

    public void getRequestTime(String line, Map<String, Long> longestRequests, Map<String, LocalDateTime> bufferMap) {
        if (isEntryRequest(line)) {
            bufferMap.put(getServiceNameAndId(line), getDate(line));
        }
        if (!isEntryRequest(line)) {
            String key = getServiceNameAndId(line);
            String serviceName = key.split(":")[0];
            long durationSeconds = Duration.between(bufferMap.get(key), getDate(line)).getSeconds();
            //write to result
            if (longestRequests.containsKey(serviceName)) {
                if (longestRequests.get(serviceName) < durationSeconds) {
                    longestRequests.remove(serviceName);
                    longestRequests.put(serviceName, durationSeconds);
                }
            } else {
                longestRequests.put(serviceName, durationSeconds);
            }
            //delete temp data
            bufferMap.remove(key);
        }
    }

    public LocalDateTime getDate(String line) {
        return LocalDateTime.parse(line.split(" ")[0], timeFormatter);
    }

    public String getServiceNameAndId(String line) {
        Pattern pattern = Pattern.compile(REGEX_SERVICE_AND_ID);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
