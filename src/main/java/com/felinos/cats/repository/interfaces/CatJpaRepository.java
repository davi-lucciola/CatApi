package com.felinos.cats.repository.interfaces;

import com.felinos.cats.entities.CatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatJpaRepository extends JpaRepository<CatEntity, Integer> {
}
