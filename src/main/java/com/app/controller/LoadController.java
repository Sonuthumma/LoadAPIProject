package com.app.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Load;
import com.app.repository.LoadRepository;

@RestController
public class LoadController {

@Autowired
private LoadRepository loadRepository;

private Load load;

@GetMapping("/loads")
public ResponseEntity<List<Load>> getAllLoads() {
List<Load> loads = loadRepository.findAll();

if (loads.isEmpty()) {

return ResponseEntity.noContent().build();
}
return ResponseEntity.ok(loads);
}

@GetMapping("/loads/{id}")
public ResponseEntity<Load> getLoadById(@PathVariable String id) {
Optional<Load> optionalLoad = loadRepository.findById(id);

if (optionalLoad.isEmpty()) {

return ResponseEntity.notFound().build();
}

return ResponseEntity.ok(optionalLoad.get());
}

@PostMapping("/loads")
public ResponseEntity<String> addLoad(@RequestBody Load load) {

load.setShipperId(UUID.randomUUID().toString());
load.setDate(new Date());

loadRepository.save(load);

return ResponseEntity.status(HttpStatus.CREATED)
.body("Load with ID " + load.getShipperId() + " successfully added");
}

@PutMapping("/loads/{id}")
public ResponseEntity<String> updateLoad(@RequestBody Load load, @PathVariable String id) {

if (loadRepository.existsById(id)) {

loadRepository.save(load);
//entityManager.persist(load);
//Load load=new Load();
jakarta.persistence.EntityManager.persist(load);
return ResponseEntity.ok("Load with ID " + id + " updated successfully");
} else {

return ResponseEntity.status(HttpStatus.NOT_FOUND)
.body("Load with ID " + id + " not found. Update operation failed.");
}
}

@DeleteMapping("/loads/{id}")
    public ResponseEntity<String> deleteLoad(@PathVariable String id) {
        if (loadRepository.existsById(id)) {
            loadRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body("Load with ID " + id + " found and deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Load with ID " + id + " not found");
        }
    }
}