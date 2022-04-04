package com.ase.models;

public enum AccountType {
    STANDARD(0,5f),
    BUDGET(1, 2.5f),
    PREMIUM(2, 1.25f),
    SUPER_PREMIUM(3, 0.75f);

    int type;
    float rate;

    private AccountType(int type, float rate) {
        this.type = type;
        this.rate = rate;
    }

    public int getType() {
        return type;
    }

    public float getRate() {
        return rate;
    }
}
