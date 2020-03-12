package com.log.utils;

import java.util.Set;

public class LogParserDemo {
    public static void main(String[] args) {
        LogParser logParser = new LogParser();
        Set<ServiceData> result = logParser.getLogInfo("src/main/resources/test.log");
        result.forEach(System.out::println);
    }
}
