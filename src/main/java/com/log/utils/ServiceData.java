package com.log.utils;

import java.util.Objects;

public class ServiceData {
    private String name;
    private String requestAmount;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ServiceData that = (ServiceData) o;
        return name.equals(that.name) &&
               Objects.equals(requestAmount, that.requestAmount);
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

    public String getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(String requestAmount) {
        this.requestAmount = requestAmount;
    }
}
