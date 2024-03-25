package com.fmt.tutor.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String especialidade;

    public TutorModel() {
    }

    public TutorModel(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

}
