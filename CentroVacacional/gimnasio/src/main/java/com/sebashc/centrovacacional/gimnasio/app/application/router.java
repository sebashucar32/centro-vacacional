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
        return route(GET("/gimnasio/mostrarPlanes"), handler::mostrarPlanes)
                .andRoute(GET("gimnasio/verPlan/{id}"), handler::verPlan)
                .andRoute(POST("/gimnasio/guardarPlan"), handler::guardarPlan)
                .andRoute(PUT("gimnasio/actualizarPlan/{id}"), handler::editarPlan)
                .andRoute(DELETE("gimnasio/eliminarPlan/{id}"), handler::eliminarPlan);
    }
}
