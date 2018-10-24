package com.lswq.consistenthash;

public class Entry {
    private String key;

    Entry(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }
}
