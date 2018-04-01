package com.antonionoca.springboot2.router;

import com.antonionoca.springboot2.constants.Endpoint;
import com.antonionoca.springboot2.handler.BusinessHandler;
import com.antonionoca.springboot2.handler.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class Router {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler,
                                                BusinessHandler businessHandler) {

        return RouterFunctions
                .route(GET("/hello")
                    .and(accept(MediaType.TEXT_PLAIN)),
                    greetingHandler::hello)

                .andRoute(GET(Endpoint.BUSINESSES)
                    .and(accept(MediaType.TEXT_PLAIN)),
                    businessHandler::getAll)
                .andRoute(GET(Endpoint.BUSINESSES + "/{id}")
                    .and(accept(MediaType.TEXT_PLAIN)),
                    businessHandler::getOne);
    }
}
