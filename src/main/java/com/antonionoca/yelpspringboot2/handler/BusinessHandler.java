package com.antonionoca.yelpspringboot2.handler;

import com.antonionoca.yelpspringboot2.model.repository.BusinessRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class BusinessHandler {

    private BusinessRepository businessRepository;

    public BusinessHandler(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(businessRepository.findAll()));
    }

    public Mono<ServerResponse> getOne(ServerRequest request) {

        Long businessId = Long.valueOf(request.pathVariable("id"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(businessRepository.findById(businessId)));
    }
}
