package com.sebashc.centrovacacional.gimnasio.app.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.sebashc.centrovacacional.gimnasio.app.models.documents.Plan;
import com.sebashc.centrovacacional.gimnasio.app.services.PlanService;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


import java.io.OutputStreamWriter;
import java.net.URI;

@Component
public class PlanHandler {
    @Autowired
    private PlanService service;

    public Mono<ServerResponse> mostrarPlanes(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Plan.class);
    }

    public Mono<ServerResponse> verPlan(ServerRequest request) {
        String id = request.pathVariable("id");

        return service.findById(id).flatMap(p -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(p)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> guardarPlan(ServerRequest request) {
        Mono<Plan> plan = request.bodyToMono(Plan.class);

        return plan.flatMap(p -> service.save(p))
                .flatMap(p -> ServerResponse
                .created(URI.create("/gimnasio/guardarPlan".concat(p.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(p)));
    }

    public Mono<ServerResponse> editarPlan(ServerRequest request) {
        Mono<Plan> plan = request.bodyToMono(Plan.class);
        String id = request.pathVariable("id");

        Mono<Plan> planDb = service.findById(id);

        return planDb.zipWith(plan, (db, req) -> {
            db.setNombre(req.getNombre());
            db.setPrecio(req.getPrecio());
            db.setDescripcion(req.getDescripcion());
            return db;
        }).flatMap(planRes -> ServerResponse.created(URI.create("gimnasio/actualizarPlan".concat(planRes.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.save(planRes), Plan.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> eliminarPlan(ServerRequest request) {
        String id = request.pathVariable("id");
        Mono<Plan> planDb = service.findById(id);

        return planDb.flatMap(p -> service.delete(p)
                .then(ServerResponse.noContent().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
