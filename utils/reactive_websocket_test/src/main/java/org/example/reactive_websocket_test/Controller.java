package org.example.reactive_websocket_test;

import io.smallrye.mutiny.Multi;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api/controller")
@RequiredArgsConstructor
public class Controller {

    private final SimpleObjectRepository repository;

    @GET
    public Multi<SimpleObject> get() {
        return repository.streamAll();
    }
}
