package com.stc.assessment.systemdesign.enums;

public enum ItemType {
    SPACE("Space"),
    FOLDER("Folder"),
    FILE("File),");

    private final String value;

    ItemType(String value) {
        this.value = value;
    }

    ItemType findByValue(String value) {
        for (ItemType e : ItemType.values()) {
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
