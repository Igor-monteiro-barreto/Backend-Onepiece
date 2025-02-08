package com.Dev.Igor.ApiOnepiece.Service;

import com.Dev.Igor.ApiOnepiece.Model.Marinheiro;
import com.Dev.Igor.ApiOnepiece.Repository.marinheiroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class marinheiroService {
    private marinheiroRepository repository;
    public marinheiroService(marinheiroRepository repository){
        this.repository = repository;
    }

    public Marinheiro add(Marinheiro marinheiro) {
        return repository.save(marinheiro);
    }

    public List<Marinheiro> findAll(){
        return repository.findAll();
    }
    public ResponseEntity<List<Marinheiro>> findById(Long id) {
        Optional<Marinheiro> marinheiro = repository.findById(id);
        if (marinheiro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        return ResponseEntity.status(HttpStatus.OK).body(List.of(marinheiro.get()));
    }

    public void deleteMarinheiro(Long id){
        repository.deleteById(id);
    }

}
