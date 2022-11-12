package com.sebashc.centrovacacional.gimnasio.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebashc.centrovacacional.gimnasio.app.models.documents.Plan;
import com.sebashc.centrovacacional.gimnasio.app.services.PlanService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/planes")
public class PlanController {
    @Autowired
    private PlanService service;

    @GetMapping("/mostrar")
    public Mono<ResponseEntity<Flux<Plan>>> mostrarPlanes(){
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.findAll())
        );
    }
}
