package com.log.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogStringUtils {

    String getServiceName(String line) {
        Pattern pattern = Pattern.compile("\\((.*)\\)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return matcher.group(1).split(":")[0];
        }
        return null;
    }
}
