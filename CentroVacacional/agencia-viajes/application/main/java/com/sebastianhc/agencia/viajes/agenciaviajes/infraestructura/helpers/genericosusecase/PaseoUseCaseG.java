package com.sebastianhc.agencia.viajes.agenciaviajes.infraestructura.helpers.genericosusecase;

import com.agencia.viajes.dominio.model.gateways.PaseoGateway;
import org.springframework.stereotype.Service;
import com.agencia.viajes.dominio.usecase.PaseoUseCase;

@Service
public class PaseoUseCaseG extends PaseoUseCase {
    public PaseoUseCaseG(PaseoGateway paseoGateway) {
        super(paseoGateway);
    }
}
