package com.Dev.Igor.ApiOnepiece.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Marinheiros")
public class Marinheiro {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String cargo;
    private boolean Akumado;

    public boolean isAkumado() {
        return Akumado;
    }

    public void setAkumado(boolean akumado) {
        Akumado = akumado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
