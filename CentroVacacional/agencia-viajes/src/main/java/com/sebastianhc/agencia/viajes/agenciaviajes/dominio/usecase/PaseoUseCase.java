package com.sebastianhc.agencia.viajes.agenciaviajes.dominio.usecase;

import com.sebastianhc.agencia.viajes.agenciaviajes.dominio.model.Paseo;
import com.sebastianhc.agencia.viajes.agenciaviajes.dominio.model.gateways.PaseoGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class PaseoUseCase {
    private final PaseoGateway paseoGateway;

    public Flux<Paseo> buscarPaseos() {
        return paseoGateway.buscarPaseos();
    }
}
