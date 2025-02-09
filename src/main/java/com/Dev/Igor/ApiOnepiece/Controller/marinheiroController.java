package com.Dev.Igor.ApiOnepiece.Controller;

import com.Dev.Igor.ApiOnepiece.Model.Marinheiro;
import com.Dev.Igor.ApiOnepiece.Service.marinheiroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/marinheiros")
public class marinheiroController {
    private final marinheiroService service;
    public marinheiroController(marinheiroService service){
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Marinheiro> create(@RequestBody Marinheiro marinheiro){
        Marinheiro newmarinheiro = service.add(marinheiro);
        return new ResponseEntity<>(newmarinheiro, HttpStatus.CREATED);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<Marinheiro>> getAll(){
        List<Marinheiro> allMarinheiro = service.findAll();
        return new ResponseEntity<>(allMarinheiro, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Marinheiro>> getById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMarinheiro(@PathVariable Long id){
        service.deleteMarinheiro(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMarinheiro(@PathVariable Long id, @RequestBody Marinheiro marinheiro) {
        try {
            Marinheiro updatedMarinheiro = service.updateMarinheiro(id, marinheiro);
            return ResponseEntity.ok(updatedMarinheiro);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
