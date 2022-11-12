package com.sebashc.centrovacacional.gimnasio.app.services;

import com.sebashc.centrovacacional.gimnasio.app.models.documents.Plan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanService {
    public Flux<Plan> findAll();
    public Mono<Plan> findById(String id);
    public Mono<Plan> save(Plan plan);
    public Mono<Void> delete(Plan plan);
}
