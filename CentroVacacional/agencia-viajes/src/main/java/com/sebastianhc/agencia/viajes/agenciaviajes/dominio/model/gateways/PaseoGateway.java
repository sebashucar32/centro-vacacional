package com.sebastianhc.agencia.viajes.agenciaviajes.dominio.model.gateways;

import com.sebastianhc.agencia.viajes.agenciaviajes.dominio.model.Paseo;
import reactor.core.publisher.Flux;

public interface PaseoGateway {
    Flux<Paseo> buscarPaseos();
}
