package com.lswq.nio.rpc.api;

public interface DemoI {
    String withReturn(String name);

    void noReturn(String name);

    String noArgument();
}
