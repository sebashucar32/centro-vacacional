package com.sebashc.centrovacacional.gimnasio.app.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebashc.centrovacacional.gimnasio.app.models.documents.Plan;
import com.sebashc.centrovacacional.gimnasio.app.services.PlanService;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/planes")
public class PlanHandler {
    @Autowired
    private PlanService service;

    public Mono<ServerResponse> mostrarPlanes(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Plan.class);
    }
}
