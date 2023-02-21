package com.felinos.cats.repository;

import com.felinos.cats.entities.CatEntity;
import com.felinos.cats.repository.interfaces.CatJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatRepository {

    @Autowired
    private CatJpaRepository catJpaRepository;

    public List<CatEntity> findAll() {
        return catJpaRepository.findAll();
    }

    public CatEntity findById(Integer id) {
        return catJpaRepository.findById(id).orElse(null);
    }

    public CatEntity saveAndFlush(CatEntity cat) {
        return catJpaRepository.saveAndFlush(cat);
    }

   public void deleteById(Integer id) {
        catJpaRepository.deleteById(id);
   }
}
