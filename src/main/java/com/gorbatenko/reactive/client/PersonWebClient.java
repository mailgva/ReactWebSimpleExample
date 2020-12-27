package com.gorbatenko.reactive.client;

import com.gorbatenko.reactive.model.Person;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class PersonWebClient {
    private WebClient client = WebClient.create("http://localhost:8080");

    private Mono<ClientResponse> result = client.get()
            .uri("/person")
            .accept(MediaType.APPLICATION_JSON)
            .exchange();

    public String getResult() {
        return ">> result = " + result.flatMap(res -> res.bodyToMono(Person.class)).block();
    }
}