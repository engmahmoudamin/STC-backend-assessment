package com.stc.assessment.systemdesign.enums;

public enum PermissionLevel {
    FULL_ACCESS("FULL"),
    READ_ACCESS("READ"),
    EDIT_ACCESS("EDIT");

    private final String value;

    PermissionLevel(String value) {
        this.value = value;
    }

    PermissionLevel findByValue(String value) {
        for (PermissionLevel e : PermissionLevel.values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}
