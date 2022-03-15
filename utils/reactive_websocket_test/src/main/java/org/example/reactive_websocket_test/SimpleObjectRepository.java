package org.example.reactive_websocket_test;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class SimpleObjectRepository implements PanacheRepositoryBase<SimpleObject, UUID> {
}
