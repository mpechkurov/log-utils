package com.log.utils;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogParserTest {

    public static final String TEMP_LOG = "src/main/resources/temp.log";
    private LogParser logParser;

    @Before
    public void setUp() {
        logParser = new LogParser();
    }

    @Test
    public void getLogInfo() {
        Set<ServiceData> expectedResult = new HashSet<>();
        ServiceData serviceData1 = new ServiceData("processAction");
        serviceData1.setRequestAmount(2);
        serviceData1.setLongestRequestTimeInSeconds(121);
        expectedResult.add(serviceData1);

        ServiceData serviceData2 = new ServiceData("processClient");
        serviceData2.setRequestAmount(1);
        serviceData2.setLongestRequestTimeInSeconds(52);
        expectedResult.add(serviceData2);

        Set<ServiceData> actualResult = logParser.getLogInfo(TEMP_LOG);

        assertEquals(expectedResult, actualResult);
    }

}