package com.agencia.viajes.dominio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Tour {
    private Integer idTour;
    private String nombreTour;
    private Integer comidas;
    private LocalTime horaInicio;
    private LocalTime horaFin;
}
