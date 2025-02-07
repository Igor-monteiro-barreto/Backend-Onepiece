package com.Dev.Igor.ApiOnepiece.Controller;

import com.Dev.Igor.ApiOnepiece.Model.Marinheiro;
import com.Dev.Igor.ApiOnepiece.Service.marinheiroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/marinheiros")
public class marinheiroController {
    private final marinheiroService service;
    public  marinheiroController(marinheiroService service){
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Marinheiro> create(@RequestBody Marinheiro marinheiro){
        Marinheiro newmarinheiro = service.add(marinheiro);
        return new ResponseEntity<>(newmarinheiro, HttpStatus.CREATED);
    }

}
