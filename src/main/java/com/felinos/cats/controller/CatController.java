package com.felinos.cats.controller;

import com.felinos.cats.entities.BasicResponse;
import com.felinos.cats.entities.CatEntity;
import com.felinos.cats.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gatos")
public class CatController {

    @Autowired
    private CatRepository catRepository;

    @GetMapping
    public ResponseEntity<List<CatEntity>> findAll() {

        List<CatEntity> gatos = catRepository.findAll();

        if (gatos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(gatos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatEntity> findById(@PathVariable Integer id) {
        CatEntity cat = catRepository.findById(id);
        if (cat == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCat(@RequestBody CatEntity gato) {
        return new ResponseEntity<>(catRepository.saveAndFlush(gato), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity  editCat(@RequestBody CatEntity gato) {

        if (gato.getId() == null) {
            return new ResponseEntity<>(
                    new BasicResponse("O Id é Obrigatorio!"), HttpStatus.BAD_REQUEST);
        }

        CatEntity cat = catRepository.findById(gato.getId());
        if (cat == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCat(@PathVariable Integer id) {
        CatEntity cat = catRepository.findById(id);
        if (cat == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        catRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
