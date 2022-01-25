package com.example.Spring.Webflux.Test;

import reactor.core.publisher.Flux;

public class ServicioUpperCase {
    private final Flux<String> source;

    ServicioUpperCase(Flux<String> source) {
        this.source = source;
    }

    Flux<String> getUpperCase() {
        return source.map(String::toUpperCase);
    }
}
