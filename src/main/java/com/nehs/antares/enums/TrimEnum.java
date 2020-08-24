package com.nehs.antares.enums;

/**
 * 需要进行trim的URI
 */
public enum TrimEnum {

    getEmployeeListByName("/getEmployeeListByName");

    TrimEnum(String requestURI) {
        this.requestURI = requestURI;
    }

    private String requestURI;

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }
}
