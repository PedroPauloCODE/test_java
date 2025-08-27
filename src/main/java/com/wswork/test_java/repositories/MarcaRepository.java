package com.wswork.test_java.repositories;

import com.wswork.test_java.models.MarcaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MarcaRepository extends JpaRepository<MarcaModel, UUID> {
}

