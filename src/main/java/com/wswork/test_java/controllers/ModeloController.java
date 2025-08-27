package com.wswork.test_java.controllers;


import com.wswork.test_java.dtos.MarcaRecordDto;
import com.wswork.test_java.dtos.ModeloRecordDto;
import com.wswork.test_java.models.MarcaModel;
import com.wswork.test_java.models.ModeloModel;
import com.wswork.test_java.repositories.MarcaRepository;
import com.wswork.test_java.repositories.ModeloRepository;
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
public class ModeloController {

    @Autowired
    ModeloRepository modeloRepository;

    @Autowired
    MarcaRepository marcaRepository;

    @PostMapping("/modelos")
    public ResponseEntity<Object> saveModelos(@RequestBody @Validated ModeloRecordDto modeloRecordDto) {

        var marcaO = marcaRepository.findById(modeloRecordDto.marca_id());

        if(marcaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não encontrada.");
        }

        var modeloModel = new ModeloModel();
        BeanUtils.copyProperties(modeloRecordDto, modeloModel);
        modeloModel.setMarca(marcaO.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(modeloRepository.save(modeloModel));
    }
    @GetMapping("/modelos")
    public ResponseEntity<List<ModeloModel>> getAllModelo() {
        return ResponseEntity.status(HttpStatus.OK).body(modeloRepository.findAll());
    }
    @PutMapping("/modelos/{id}")
    public ResponseEntity<Object> updateModelo(
            @PathVariable UUID id,
            @RequestBody @Validated ModeloRecordDto modeloRecordDto) {

        var modeloOptional = modeloRepository.findById(id);
        if (modeloOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modelo não encontrado.");
        }

        var marcaOptional = marcaRepository.findById(modeloRecordDto.marca_id());
        if (marcaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não encontrada.");
        }

        var modelo = modeloOptional.get();
        BeanUtils.copyProperties(modeloRecordDto, modelo, "id", "marca");
        modelo.setMarca(marcaOptional.get()); // seta explicitamente a marca
        modeloRepository.save(modelo);
        return ResponseEntity.ok(modelo);
    }
    @DeleteMapping("/modelos/{id}")
    public ResponseEntity<Object> deleteModelo(@PathVariable(value = "id") UUID id) {
        Optional<ModeloModel> modeloOptional = modeloRepository.findById(id);
        if (modeloOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modelo não encontrado.");
        }
        modeloRepository.delete(modeloOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Modelo deletado com sucesso!");
    }
}