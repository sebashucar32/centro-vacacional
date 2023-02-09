package com.sebastianhc.agencia.viajes.agenciaviajes.infraestructura.helpers.genericosusecase;

import model.gateways.PaseoGateway;
import org.springframework.stereotype.Service;
import usecase.PaseoUseCase;

@Service
public class PaseoUseCaseG extends PaseoUseCase {
    public PaseoUseCaseG(PaseoGateway paseoGateway) {
        super(paseoGateway);
    }
}
