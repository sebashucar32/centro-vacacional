package com.sebastianhc.agencia.viajes.agenciaviajes.infraestructura.entrypoints.apirest;

import com.sebastianhc.agencia.viajes.agenciaviajes.dominio.model.Paseo;
import com.sebastianhc.agencia.viajes.agenciaviajes.infraestructura.helpers.genericosusecase.PaseoUseCaseG;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaseoRest {
    private final PaseoUseCaseG useCase;

    @GetMapping("/paseos")
    public Flux<Paseo> buscarPersonasParaViajar() {
        return useCase.buscarPaseos();
    }
}
