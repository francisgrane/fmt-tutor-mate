package com.fmt.tutor.controller;

import com.fmt.tutor.exception.ResourceNotFoundException;
import com.fmt.tutor.model.AgendaModel;
import com.fmt.tutor.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    private final AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping
    public ResponseEntity<List<AgendaModel>> listarTodasAsAgendas() {
        List<AgendaModel> agendas = agendaService.listarTodasAsAgendas();
        if (agendas.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(agendas);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaModel> buscarAgendaPorId(@PathVariable Integer id) {
        Optional<AgendaModel> agendaOptional = agendaService.buscarAgendaPorId(id);
        return agendaOptional.map(agenda -> ResponseEntity.ok().body(agenda))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AgendaModel> criarAgenda(@RequestBody AgendaModel agenda) {
        AgendaModel newAgenda = agendaService.criarAgenda(agenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAgenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendaModel> atualizarAgendaPorId(@PathVariable Integer id, @RequestBody AgendaModel agendaAtualizada) {
        Optional<AgendaModel> agendaOptional = agendaService.buscarAgendaPorId(id);
        if (agendaOptional.isPresent()) {
            AgendaModel agendaExistente = agendaOptional.get();
            AgendaModel agendaAtualizadaSalvo = agendaService.atualizarAgenda(id, agendaExistente);
            return ResponseEntity.ok(agendaAtualizadaSalvo);
        } else {
            throw new ResourceNotFoundException("Agenda não encontrada para atualizar.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgendaPorId(@PathVariable Integer id) {
        Optional<AgendaModel> agendaOptional = agendaService.buscarAgendaPorId(id);
        if (agendaOptional.isPresent()) {
            agendaService.deletarAgendaPorId(id);
        } else {
            throw new ResourceNotFoundException("Agenda não encontrada para deletar.");
        }
        return null;
    }
}