package org.example.reactive_websocket_test;

import io.vertx.pgclient.PgPool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.reactive_websocket_test.decoder.ObjectDecoder;
import org.example.reactive_websocket_test.encoder.ObjectEncoder;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@ServerEndpoint(value = "/api/websocket",
        decoders = ObjectDecoder.class,
        encoders = ObjectEncoder.class)
public class Websocket {

    private final SimpleService simpleService;
    private final SimpleObjectRepository repository;
    private final PgPool pgPool;

    @OnOpen
    public void onOpen(Session session) {
        log.info("ON OPEN");
        simpleService.getAll().subscribe().with(item -> sendItem(session, item));
        log.info("pool size " + pgPool.size());
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        log.info("ON CLOSE");
    }

    @OnError
    public void onError(Session session, Throwable throwable) throws IOException {
        log.error("ON ERROR", throwable);
    }

    @OnMessage
    public void onMessage(SimpleObject simpleObject, Session session) {
        log.info("ON MESSAGE");
    }

    private void sendItem(Session session, SimpleObject item) {
        session.getAsyncRemote().sendObject(item, result -> {
            if (result.getException() != null) {
                result.getException().printStackTrace();
            }
        });
    }

}
