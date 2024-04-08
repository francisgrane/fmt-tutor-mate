package com.fmt.tutor.controller;

import com.fmt.tutor.model.AgendaModel;
import com.fmt.tutor.service.AgendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendaService agendaService;

    public AgendamentoController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping("/alunos/{alunoId}")
    public ResponseEntity<List<AgendaModel>> getAgendamentosPorAlunoId(@PathVariable Long alunoId) {
        List<AgendaModel> agendamentos = agendaService.getAgendamentosPorAlunoId(alunoId);
        return ResponseEntity.ok(agendamentos);
    }

    @GetMapping("/tutores/{tutorId}")
    public ResponseEntity<List<AgendaModel>> getAgendamentosPorTutorId(@PathVariable Long tutorId) {
        List<AgendaModel> agendamentos = agendaService.getAgendamentosPorTutorId(tutorId);
        return ResponseEntity.ok(agendamentos);
    }

    @GetMapping("/proximo/aluno/{alunoId}")
    public ResponseEntity<List<AgendaModel>> getProximosAgendamentosPorAlunoId(@PathVariable Long alunoId) {
        List<AgendaModel> proximosAgendamentos = agendaService.getProximosAgendamentosPorAlunoId(alunoId);
        return ResponseEntity.ok(proximosAgendamentos);
    }

    @GetMapping("/proximo/tutor/{tutorId}")
    public ResponseEntity<List<AgendaModel>> getProximosAgendamentosPorTutorId(@PathVariable Long tutorId) {
        List<AgendaModel> proximosAgendamentos = agendaService.getProximosAgendamentosPorTutorId(tutorId);
        return ResponseEntity.ok(proximosAgendamentos);
    }

}
