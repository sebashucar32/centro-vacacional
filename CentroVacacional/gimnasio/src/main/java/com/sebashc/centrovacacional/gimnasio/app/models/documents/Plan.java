package com.sebashc.centrovacacional.gimnasio.app.models.documents;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "planes")
public class Plan {
	private String id;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;

    public Plan(String nombre, BigDecimal precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }
}
