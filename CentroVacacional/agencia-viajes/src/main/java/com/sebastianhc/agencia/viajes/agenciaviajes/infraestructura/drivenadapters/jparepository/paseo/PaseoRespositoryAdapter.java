package com.sebastianhc.agencia.viajes.agenciaviajes.infraestructuras.drivenadapters.jparepository.paseo;

import com.sebastianhc.agencia.viajes.agenciaviajes.dominios.model.Paseo;
import com.sebastianhc.agencia.viajes.agenciaviajes.dominios.model.gateways.PaseoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

import static com.sebastianhc.agencia.viajes.agenciaviajes.infraestructuras.drivenadapters.jparepository.convertidor.ConvertidorPaseo.convertirPaseosDataAPaseos;

@Repository
public class PaseoRespositoryAdapter implements PaseoGateway {
    @Autowired
    private final PaseoDataRepository repository;

    public PaseoRespositoryAdapter(PaseoDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<Paseo> buscarPaseos() {
        List<PaseoData> paseos = repository.findAll();

        if (!paseos.isEmpty()) {
            return Flux.fromIterable(convertirPaseosDataAPaseos(paseos));
        } else {
            return Flux.empty();
        }
    }
}
