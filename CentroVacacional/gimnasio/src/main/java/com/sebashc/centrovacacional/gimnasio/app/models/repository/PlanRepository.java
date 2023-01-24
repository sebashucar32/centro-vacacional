package com.sebashc.centrovacacional.gimnasio.app.models.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sebashc.centrovacacional.gimnasio.app.models.documents.Plan;

public interface PlanRepository extends ReactiveMongoRepository<Plan, String> {

}
