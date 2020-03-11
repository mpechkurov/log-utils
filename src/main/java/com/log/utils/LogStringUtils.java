package com.log.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogStringUtils {

    public static final String ENTRY_LOG_STRING = "entry";

    String getServiceName(String line) {
        Pattern pattern = Pattern.compile("\\((.*)\\)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return matcher.group(1).split(":")[0];
        }
        return null;
    }

    public boolean isEntryRequest(String line) {
        return line.contains(ENTRY_LOG_STRING);
    }
}
