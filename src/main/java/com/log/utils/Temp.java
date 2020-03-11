package com.log.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Temp {
    public static void main(String[] args) {
        String test = "2015-10-28T12:25:16,761 TRACE [OperationsImpl] exit with (addClient:97921)";

        Pattern pattern = Pattern.compile("\\((.*)\\)");
        Matcher matcher = pattern.matcher(test);
        if (matcher.find())
        {
            System.out.println(matcher.group(1).split(":")[0]);
        }

    }
}
