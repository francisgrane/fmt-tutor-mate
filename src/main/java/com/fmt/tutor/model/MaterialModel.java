package com.fmt.tutor.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.service.annotation.GetExchange;

@Entity
@Data
public class MaterialModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "agenda_id", nullable = false)
    private AgendaModel agenda;

    @Column(nullable = false)
    private String descricao;

    private String pathMaterial;

    public MaterialModel() {
    }

    public MaterialModel(AgendaModel agenda, String descricao, String pathMaterial) {
        this.agenda = agenda;
        this.descricao = descricao;
        this.pathMaterial = pathMaterial;
    }

    public Integer getId() {
        return id;
    }

    public AgendaModel getAgenda() {
        return agenda;
    }

    public void setAgenda(AgendaModel agenda) {
        this.agenda = agenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPathMaterial() {
        return pathMaterial;
    }

    public void setPathMaterial(String pathMaterial) {
        this.pathMaterial = pathMaterial;
    }

}
