package com.client;

public interface Action<RETURN_TYPE> {

    RETURN_TYPE execute();

    void setUp();

    void cleanUp();
}
