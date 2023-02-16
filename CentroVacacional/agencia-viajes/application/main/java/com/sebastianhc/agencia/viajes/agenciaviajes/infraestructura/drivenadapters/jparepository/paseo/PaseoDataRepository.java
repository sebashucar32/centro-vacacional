package com.sebastianhc.agencia.viajes.agenciaviajes.infraestructura.drivenadapters.jparepository.paseo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface PaseoDataRepository extends JpaRepository<PaseoData, Integer>,
        QueryByExampleExecutor<PaseoData> {

}
