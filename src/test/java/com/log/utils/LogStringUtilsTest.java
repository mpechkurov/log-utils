package com.log.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogStringUtilsTest {

    private final String LOG_STRING = "2015-10-26T16:09:47,958 TRACE [OperationsImpl] entry with (processClient:17893)";
    private LogStringUtils logStringUtils;

    @Before
    public void setUp() {
        logStringUtils = new LogStringUtils();
    }

    @Test
    public void getServiceName() {
        assertEquals("processClient", logStringUtils.getServiceName(LOG_STRING));
    }
}