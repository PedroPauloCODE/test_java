package com.wswork.test_java.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record CarsResumeDto(
        UUID id,
        LocalDateTime timestampCadastro,
        UUID modelo_id,
        Integer ano,
        String combustivel,
        Integer numPortas,
        String cor,
        String nomeModelo,
        BigDecimal valor
) {
}