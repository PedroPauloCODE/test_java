package com.wswork.test_java.repositories;

import com.wswork.test_java.models.ModeloModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModeloRepository extends JpaRepository<ModeloModel, UUID> {
}
