package com.fmt.tutor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "agenda")
public class AgendaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private AlunoModel aluno;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private TutorModel tutor;

    @Column(nullable = false)
    private LocalDate data;

    private String status;

    private String tema;

    private String descricao;

    public AgendaModel() {
    }

    public AgendaModel(AlunoModel aluno, TutorModel tutor, LocalDate data, String status, String tema, String descricao) {
        this.aluno = aluno;
        this.tutor = tutor;
        this.data = data;
        this.status = status;
        this.tema = tema;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public AlunoModel getAluno() {
        return aluno;
    }

    public void setAluno(AlunoModel aluno) {
        this.aluno = aluno;
    }

    public TutorModel getTutor() {
        return tutor;
    }

    public void setTutor(TutorModel tutor) {
        this.tutor = tutor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(Integer id) {
    }
}
