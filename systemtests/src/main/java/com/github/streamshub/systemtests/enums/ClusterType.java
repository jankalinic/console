package com.github.streamshub.systemtests.enums;

public enum ClusterType {
    MICROSHIFT("microshift");

    private final String value;

    ClusterType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static ClusterType fromValue(String value) {
        for (ClusterType type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }
}