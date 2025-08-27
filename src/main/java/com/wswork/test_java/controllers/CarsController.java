package com.wswork.test_java.controllers;

import com.wswork.test_java.dtos.CarsRecordDto;
import com.wswork.test_java.dtos.CarsResumeDto;
import com.wswork.test_java.models.CarsModel;
import com.wswork.test_java.repositories.CarsRepository;
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
public class CarsController {

    @Autowired
    CarsRepository carsRepository;

    @Autowired
    ModeloRepository modeloRepository;

    @PostMapping("/cars")
    public ResponseEntity<Object> saveCar(@RequestBody @Validated CarsRecordDto carsRecordDto) {

        var modeloOptional = modeloRepository.findById(carsRecordDto.modelo_id());
        if (modeloOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modelo não encontrado.");
        }

        var carsModel = new CarsModel();
        BeanUtils.copyProperties(carsRecordDto, carsModel);
        carsModel.setModelo(modeloOptional.get());

        var savedCar = carsRepository.save(carsModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarsResumeDto>> getCars() {
        var carros = carsRepository.findAllResumo();
        return ResponseEntity.ok(carros);
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable(value = "id") UUID id,
                                            @RequestBody @Validated CarsRecordDto carRecordDto) {
        Optional<CarsModel> car0 = carsRepository.findById(id);
        if(car0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found.");
        }
        var carroModel = car0.get();
        BeanUtils.copyProperties(carRecordDto, carroModel);
        return ResponseEntity.status(HttpStatus.OK).body(carsRepository.save(carroModel));
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable(value = "id") UUID id) {
        Optional<CarsModel> car0 = carsRepository.findById(id);
        if(car0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found.");
        }
        carsRepository.delete(car0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Car deleted successfully");
    }

}
