package com.gorbatenko.reactive.server;

import com.gorbatenko.reactive.handler.GreetingHandler;
import com.gorbatenko.reactive.handler.PersonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler, PersonHandler personHandler) {

        return RouterFunctions
                .route(RequestPredicates.GET("/hello")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), greetingHandler::hello)
                .andRoute(RequestPredicates.GET("/person")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), personHandler::person);

    }
}