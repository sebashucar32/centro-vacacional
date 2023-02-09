package usecase;

import lombok.RequiredArgsConstructor;
import model.Paseo;
import model.gateways.PaseoGateway;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class PaseoUseCase {
    private final PaseoGateway paseoGateway;

    public Flux<Paseo> buscarPaseos() {
        return paseoGateway.buscarPaseos();
    }
}
