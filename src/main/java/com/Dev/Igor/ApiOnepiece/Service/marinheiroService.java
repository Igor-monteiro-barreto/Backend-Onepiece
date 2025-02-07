package com.Dev.Igor.ApiOnepiece.Service;

import com.Dev.Igor.ApiOnepiece.Model.Marinheiro;
import com.Dev.Igor.ApiOnepiece.Repository.marinheiroRepository;
import org.springframework.stereotype.Service;

@Service
public class marinheiroService {
    private marinheiroRepository repository;
    public marinheiroService(marinheiroRepository repository){
        this.repository = repository;
    }

    public Marinheiro add(Marinheiro marinheiro) {
        return repository.save(marinheiro);
    }
}
