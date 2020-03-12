package com.log.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LogStringUtilsTest {

    private final String LOG_STRING_ENTRY = "2015-10-26T16:09:47,958 TRACE [OperationsImpl] entry with (processClient:17893)";
    private final String LOG_STRING_EXIT = "2015-10-26T16:10:39,248 TRACE [OperationsImpl] exit with (processClient:17893)";
    private LogStringUtils logStringUtils;

    @Before
    public void setUp() {
        logStringUtils = new LogStringUtils();
    }

    @Test
    public void getServiceName() {
        assertEquals("processClient", logStringUtils.getServiceName(LOG_STRING_ENTRY));
    }

    @Test
    public void isEntryRequest() {
        assertTrue(logStringUtils.isEntryRequest(LOG_STRING_ENTRY));
    }

    @Test
    public void isExitRequest() {
        assertFalse(logStringUtils.isEntryRequest(LOG_STRING_EXIT));
    }

    @Test
    public void getDate() {
        assertEquals("2015-10-26T16:09:47.958", logStringUtils.getDate(LOG_STRING_ENTRY).toString());
    }

    @Test
    public void getServiceNameAndId() {
        assertEquals("processClient:17893", logStringUtils.getServiceNameAndId(LOG_STRING_ENTRY));
    }

}