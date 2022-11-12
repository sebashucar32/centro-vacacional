package com.sebashc.centrovacacional.gimnasio.app.models.documents;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "planes")
public class Plan {
	private String id;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
}
