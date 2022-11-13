package com.sebashc.centrovacacional.gimnasio.app.application;

import com.sebashc.centrovacacional.gimnasio.app.handlers.PlanHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class router {
    @Bean
    public RouterFunction<ServerResponse> routes(PlanHandler handler) {
        return route(GET("/api/planes/mostrar"), handler::mostrarPlanes);
    }
}
