package com.agencia.viajes.dominio.usecase;

import lombok.RequiredArgsConstructor;
import com.agencia.viajes.dominio.model.Paseo;
import com.agencia.viajes.dominio.model.gateways.PaseoGateway;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class PaseoUseCase {
    private final PaseoGateway paseoGateway;

    public Flux<Paseo> buscarPaseos() {
        return paseoGateway.buscarPaseos();
    }
}
