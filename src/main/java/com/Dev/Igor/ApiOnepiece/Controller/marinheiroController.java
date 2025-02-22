package com.Dev.Igor.ApiOnepiece.Controller;

import com.Dev.Igor.ApiOnepiece.Model.Cargo;
import com.Dev.Igor.ApiOnepiece.Model.Marinheiro;
import com.Dev.Igor.ApiOnepiece.Repository.marinheiroRepository;
import com.Dev.Igor.ApiOnepiece.Service.marinheiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/marinheiros")
public class marinheiroController {
    @Autowired
    private marinheiroRepository marinheiroRepository;
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
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updatePatch(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        try {
            Optional<Marinheiro> marinheiroOptional = marinheiroRepository.findById(id);

            if (marinheiroOptional.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            Marinheiro marinheiro = marinheiroOptional.get();

            updates.forEach((campo, valor) -> {
                switch (campo) {
                    case "nome":
                        marinheiro.setNome((String) valor);
                        break;
                    case "idade":
                        marinheiro.setIdade((Integer) valor);
                        break;
                    case "cargo":
                        marinheiro.setCargo(Cargo.valueOf((String) valor));
                        break;
                    case "akumado":
                        marinheiro.setAkumado((Boolean) valor);
                        break;
                    default:
                        break;
                }
            });

            marinheiroRepository.save(marinheiro);
            return ResponseEntity.ok(marinheiro);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Valor inválido para o campo 'cargo'.");
        } catch (ClassCastException e) {
            return ResponseEntity.badRequest().body("Tipo de valor inválido para algum campo.");
        }
    }

}
