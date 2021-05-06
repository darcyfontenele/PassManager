package com.passmanager.domain.model;

public enum FareEnum {

    AZONEUNIQUE(6),
    BZONEUNIQUE(7),
    AZONEDAILY(10),
    BZONEDAILY(12),
    AZONEWEEKLY(30),
    BZONEWEEKLY(45),
    AZONEMONTHLY(130),
    BZONEMONTHLY(170);

    private int value;

    FareEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
