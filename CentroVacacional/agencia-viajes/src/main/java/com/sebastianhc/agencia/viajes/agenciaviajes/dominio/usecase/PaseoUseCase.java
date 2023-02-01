package com.sebastianhc.agencia.viajes.agenciaviajes.dominios.usecase;

import com.sebastianhc.agencia.viajes.agenciaviajes.dominios.model.Paseo;
import com.sebastianhc.agencia.viajes.agenciaviajes.dominios.model.gateways.PaseoGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class PaseoUseCase {
    private final PaseoGateway paseoGateway;

    public Flux<Paseo> buscarPaseos() {
        return paseoGateway.buscarPaseos();
    }
}
