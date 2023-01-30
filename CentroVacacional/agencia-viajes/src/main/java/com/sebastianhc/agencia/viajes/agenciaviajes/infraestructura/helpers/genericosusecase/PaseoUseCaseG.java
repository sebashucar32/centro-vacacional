package com.sebastianhc.agencia.viajes.agenciaviajes.infraestructura.helpers.genericosusecase;

import com.sebastianhc.agencia.viajes.agenciaviajes.dominio.model.gateways.PaseoGateway;
import com.sebastianhc.agencia.viajes.agenciaviajes.dominio.usecase.PaseoUseCase;
import org.springframework.stereotype.Service;

@Service
public class PaseoUseCaseG extends PaseoUseCase {
    public PaseoUseCaseG(PaseoGateway paseoGateway) {
        super(paseoGateway);
    }
}
