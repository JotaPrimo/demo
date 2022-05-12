package com.example.crudjpa.demo.models;

import org.hibernate.validator.constraints.br.CPF;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "professores")
public class Professor {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotEmpty(message = "A nome deve ser informada")
    @Size(min = 3, message = "A nome deve ter no mínimo 3 caracteres")
    private String nome;


    @NotNull(message = "A materia deve ser informada")
    @NotEmpty(message = "A materia deve ser selecionada")
    @Size(min = 4, message = "A materia deve ter no mínimo 4 caracteres")
    private String materia;

    @NotBlank(message = "O CPF deve ser informado")
    @CPF(message = "CPF inválido")
    private  String cpf;


    @NotEmpty(message = "Campo obrigatório")
    @Size(min = 4, message = "A formacão deve ter no mínimo 4 caracteres")
    private String formacao;

    public Professor() {
    }

    public Professor(String nome, String materia, String cpf, String formacao) {
        this.nome = nome;
        this.materia = materia;
        this.cpf = cpf;
        this.formacao = formacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
}
