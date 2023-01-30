package com.sebastianhc.agencia.viajes.agenciaviajes.infraestructura.drivenadapters.jparepository.convertidor;

import com.sebastianhc.agencia.viajes.agenciaviajes.dominio.model.Paseo;
import com.sebastianhc.agencia.viajes.agenciaviajes.dominio.model.Tour;
import com.sebastianhc.agencia.viajes.agenciaviajes.infraestructura.drivenadapters.jparepository.paseo.PaseoData;
import com.sebastianhc.agencia.viajes.agenciaviajes.infraestructura.drivenadapters.jparepository.tour.TourData;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertidorPaseo {
    private ConvertidorPaseo() {
        throw new IllegalStateException("Utility class");
    }

    public static Paseo convertirPaseoDataAPaseo(PaseoData data) {
        return Paseo.builder()
                .idPaseo(data.getIdPaseo())
                .nombreCiudad(data.getNombreCiudad())
                .sede(data.getSede())
                .imagen(data.getImagen())
                .tours(convertirToursDataATours(data.getTours()))
                .build();
    }

    public static List<Paseo> convertirPaseosDataAPaseos(List<PaseoData> paseos) {
        return paseos.stream()
                .map(ConvertidorPaseo::convertirPaseoDataAPaseo)
                .collect(Collectors.toList());
    }

    public static Tour convertirTourDataATour(TourData data) {
        return Tour.builder()
                .idTour(data.getIdTour())
                .nombreTour(data.getNombreTour())
                .comidas(data.getComidas())
                .horaInicio(data.getHoraInicio())
                .horaFin(data.getHoraFin())
                .build();
    }

    public static List<Tour> convertirToursDataATours(List<TourData> tours) {
        return tours.stream()
                .map(ConvertidorPaseo::convertirTourDataATour)
                .collect(Collectors.toList());
    }
}
