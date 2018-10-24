package com.lswq.consistenthash;

import java.util.HashMap;
import java.util.Map;

public class Server {
    private String name;
    private Map<Entry, Entry> entries;

    Server(String name) {
        this.name = name;
        entries = new HashMap<>();
    }

    public void put(Entry e) {
        entries.put(e, e);
    }

    public Entry get(Entry e) {
        return entries.get(e);
    }

    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"").append(name).append('\"');
        sb.append(",\"entries\":").append(entries);
        sb.append('}');
        return sb.toString();
    }
}
