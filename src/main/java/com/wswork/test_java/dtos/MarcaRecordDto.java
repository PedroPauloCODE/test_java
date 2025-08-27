package com.wswork.test_java.dtos;


import jakarta.validation.constraints.NotBlank;

public record MarcaRecordDto(
        @NotBlank(message = "O nome da marca não pode ser vazio")
        String nome_marca
) {
}
