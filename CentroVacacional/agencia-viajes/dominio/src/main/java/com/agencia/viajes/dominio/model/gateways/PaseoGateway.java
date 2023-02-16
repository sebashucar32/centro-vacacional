package com.agencia.viajes.dominio.model.gateways;

import com.agencia.viajes.dominio.model.Paseo;
import reactor.core.publisher.Flux;

public interface PaseoGateway {
    Flux<Paseo> buscarPaseos();
}
