package org.example.reactive_websocket_test.encoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.example.reactive_websocket_test.SimpleObject;
import org.example.reactive_websocket_test.util.Util;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class ObjectEncoder implements Encoder.Text<SimpleObject> {

    private final ObjectMapper jackson = Util.getJackson();

    @SneakyThrows
    @Override
    public String encode(SimpleObject object) {
        return jackson.writeValueAsString(object);
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
