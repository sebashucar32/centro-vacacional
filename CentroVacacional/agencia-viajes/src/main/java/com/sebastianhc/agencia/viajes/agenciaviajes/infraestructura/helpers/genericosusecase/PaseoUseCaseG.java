package com.sebastianhc.agencia.viajes.agenciaviajes.infraestructuras.helpers.genericosusecase;

import com.sebastianhc.agencia.viajes.agenciaviajes.dominios.model.gateways.PaseoGateway;
import com.sebastianhc.agencia.viajes.agenciaviajes.dominios.usecase.PaseoUseCase;
import org.springframework.stereotype.Service;

@Service
public class PaseoUseCaseG extends PaseoUseCase {
    public PaseoUseCaseG(PaseoGateway paseoGateway) {
        super(paseoGateway);
    }
}
