package org.example.reactive_websocket_test;

import io.smallrye.mutiny.Multi;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class SimpleService {

    private final SimpleObjectRepository repository;

    public Multi<SimpleObject> getAll() {
        return repository.streamAll();
    }
}
