package com.wswork.test_java.repositories;

import com.wswork.test_java.dtos.CarsResumeDto;
import com.wswork.test_java.models.CarsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CarsRepository extends JpaRepository<CarsModel, UUID> {

    @Query("""
           SELECT new com.wswork.test_java.dtos.CarsResumeDto(
               c.id,
               c.timestampCadastro,
               m.id,
               c.ano,
               c.combustivel,
               c.num_portas,
               c.cor,
               m.nome,
               m.valor_fipe
           )
           FROM CarsModel c
           JOIN c.modelo m
           """)
    List<CarsResumeDto> findAllResumo();
}
