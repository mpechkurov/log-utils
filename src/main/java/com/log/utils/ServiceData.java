package com.log.utils;

import java.util.Objects;

public class ServiceData {
    private String name;
    private long requestAmount = 0;
    private long longestRequestTimeInSeconds;

    @Override
    public String toString() {
        return "ServiceData{" +
               "name='" + name + '\'' +
               ", requestAmount=" + requestAmount +
               ", longestRequestTimeInSeconds=" + longestRequestTimeInSeconds +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ServiceData that = (ServiceData) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public ServiceData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(long requestAmount) {
        this.requestAmount = requestAmount;
    }

    public long getLongestRequestTimeInSeconds() {
        return longestRequestTimeInSeconds;
    }

    public void setLongestRequestTimeInSeconds(long longestRequestTimeInSeconds) {
        this.longestRequestTimeInSeconds = longestRequestTimeInSeconds;
    }

    public void updateRequestAmount() {
        this.requestAmount += 1;
    }
}
