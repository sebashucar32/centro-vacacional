package model.gateways;

import model.Paseo;
import reactor.core.publisher.Flux;

public interface PaseoGateway {
    Flux<Paseo> buscarPaseos();
}
