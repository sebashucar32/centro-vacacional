package com.sebashc.centrovacacional.gimnasio.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebashc.centrovacacional.gimnasio.app.models.documents.Plan;
import com.sebashc.centrovacacional.gimnasio.app.models.repository.PlanRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanRepository repository;

    @Override
    public Flux<Plan> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Plan> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Plan> save(Plan plan) {
        return repository.save(plan);
    }

    @Override
    public Mono<Void> delete(Plan producto) {
        return repository.delete(producto);
    }
}
