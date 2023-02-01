package com.sebastianhc.agencia.viajes.agenciaviajes.dominios.model.gateways;

import com.sebastianhc.agencia.viajes.agenciaviajes.dominios.model.Paseo;
import reactor.core.publisher.Flux;

public interface PaseoGateway {
    Flux<Paseo> buscarPaseos();
}
