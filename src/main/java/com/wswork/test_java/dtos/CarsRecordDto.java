package com.wswork.test_java.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CarsRecordDto(@NotNull(message = "Insira um ano válido.")Integer ano,
                            @NotBlank(message = "Insira um nome de combustível válido.") String combustivel,
                            @NotNull(message = "Insira um nº válido.") Integer num_portas,
                            @NotBlank(message = "Insira uma cor válida.") String cor,
                            @NotNull(message = "Insira um Id de um Modelo válido.") UUID modelo_id) {
}
