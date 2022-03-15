package org.example.reactive_websocket_test.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.inject.Singleton;

public class Util {

    @Singleton
    public static ObjectMapper getJackson() {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        om.registerModule(new JavaTimeModule());
        return om;
    }
}
