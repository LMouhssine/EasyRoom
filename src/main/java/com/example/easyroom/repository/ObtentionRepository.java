package com.example.easyroom.repository;

import com.example.easyroom.model.Obtention;
import com.example.easyroom.model.ObtentionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObtentionRepository extends JpaRepository<Obtention, ObtentionId> {
}