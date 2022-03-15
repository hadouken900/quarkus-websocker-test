package org.example.reactive_websocket_test.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.example.reactive_websocket_test.SimpleObject;
import org.example.reactive_websocket_test.util.Util;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class ObjectDecoder implements Decoder.Text<SimpleObject> {

    private final ObjectMapper jackson = Util.getJackson();

    @SneakyThrows
    @Override
    public SimpleObject decode(String s) {
        return jackson.readValue(s, SimpleObject.class);
    }

    @Override
    public boolean willDecode(String s) {
        return s != null;
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
