package com.fmt.tutor.controller;

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
    public ResponseEntity<AgendaModel> buscarAgenda(@PathVariable Integer id) {
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
    public ResponseEntity<AgendaModel> atualizarAgenda(@PathVariable Integer id, @RequestBody AgendaModel updatedAgenda) {
        AgendaModel updated = agendaService.atualizarAgenda(id, updatedAgenda);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgenda(@PathVariable Integer id) {
        agendaService.deletarAgendaPorId(id);
        return ResponseEntity.noContent().build();
    }
}
