package com.wswork.test_java.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record ModeloRecordDto(@NotBlank(message = "Insira um nome válido.") String nome,
                              @NotNull(message = "Insira um valor válido.") BigDecimal valor_fipe,
                              @NotNull(message = "Insira um Id de marca válida.") UUID marca_id)
{
}
