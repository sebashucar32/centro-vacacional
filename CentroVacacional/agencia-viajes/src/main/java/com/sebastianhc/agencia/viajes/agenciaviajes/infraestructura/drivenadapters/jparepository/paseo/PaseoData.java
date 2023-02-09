package com.sebastianhc.agencia.viajes.agenciaviajes.infraestructura.drivenadapters.jparepository.paseo;

import com.sebastianhc.agencia.viajes.agenciaviajes.infraestructuras.drivenadapters.jparepository.tour.TourData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "paseos")
public class PaseoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paseo")
    private Integer idPaseo;

    @Column(name = "nombre_ciudad")
    private String nombreCiudad;

    private String sede;

    private String imagen;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_paseo")
    private List<TourData> tours;
}
