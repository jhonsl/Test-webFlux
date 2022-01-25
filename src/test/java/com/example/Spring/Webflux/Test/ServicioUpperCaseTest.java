package com.example.Spring.Webflux.Test;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

public class ServicioUpperCaseTest {

    final TestPublisher<String> testPublisher = TestPublisher.create();

    @Test
    void testUpperCase() {
        ServicioUpperCase servicioUpperCase = new ServicioUpperCase(testPublisher.flux());
        StepVerifier.create(servicioUpperCase.getUpperCase())
                .then(() -> testPublisher.emit("datos", "GeNeRaDoS", "Sofka"))
                .expectNext("DATOS", "GENERADOS", "SOFKA")
                .verifyComplete();
    }
}
