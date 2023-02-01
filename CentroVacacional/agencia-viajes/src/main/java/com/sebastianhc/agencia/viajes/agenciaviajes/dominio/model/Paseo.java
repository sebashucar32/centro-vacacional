package com.sebastianhc.agencia.viajes.agenciaviajes.dominios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Paseo {
    private Integer idPaseo;
    private String nombreCiudad;
    private String sede;
    private String imagen;
    private List<Tour> tours;
}
