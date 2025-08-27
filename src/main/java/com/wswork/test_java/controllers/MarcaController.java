package com.wswork.test_java.controllers;


import com.wswork.test_java.dtos.MarcaRecordDto;
import com.wswork.test_java.models.MarcaModel;

import com.wswork.test_java.repositories.MarcaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class MarcaController {

    @Autowired
    MarcaRepository marcaRepository;

    @PostMapping("/marca")
    public ResponseEntity<MarcaModel> saveMarca(@RequestBody @Validated MarcaRecordDto marcaRecordDto) {
        var marcaModel = new MarcaModel();
        BeanUtils.copyProperties(marcaRecordDto, marcaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(marcaRepository.save(marcaModel));
    }
    @GetMapping("/marca")
    public ResponseEntity<List<MarcaModel>> getAllMarcas() {
        return ResponseEntity.status(HttpStatus.OK).body(marcaRepository.findAll());
    }

    @PutMapping("/marca/{id}")
    public ResponseEntity<Object> updateMarca(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Validated MarcaRecordDto marcaRecordDto) {
        Optional<MarcaModel> marcaOptional = marcaRepository.findById(id);
        if (marcaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não encontrada.");
        }
        var marcaModel = marcaOptional.get();
        BeanUtils.copyProperties(marcaRecordDto, marcaModel);
        return ResponseEntity.status(HttpStatus.OK).body(marcaRepository.save(marcaModel));
    }

    @DeleteMapping("/marca/{id}")
    public ResponseEntity<Object> deleteMarca(@PathVariable(value = "id") UUID id) {
        Optional<MarcaModel> marcaOptional = marcaRepository.findById(id);
        if (marcaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não encontrada.");
        }
        marcaRepository.delete(marcaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Marca deletada com sucesso!");
    }

}
