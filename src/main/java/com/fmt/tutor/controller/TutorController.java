package com.fmt.tutor.controller;

import com.fmt.tutor.exception.ResourceNotFoundException;
import com.fmt.tutor.model.TutorModel;
import com.fmt.tutor.service.AgendaService;
import com.fmt.tutor.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    private TutorService tutorService;

    @Autowired
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<TutorModel>> listarTodosOsTutores() {
        ArrayList<TutorModel> tutores = (ArrayList<TutorModel>) tutorService.listarTodosOsTutores();
        if (tutores.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(tutores);
        }
    }

    @PostMapping
    public ResponseEntity<TutorModel> criarTutor(@RequestBody TutorModel tutor) {
        TutorModel novoTutor = tutorService.criarTutor(tutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTutor);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TutorModel> buscarTutor(@PathVariable Integer id) {
        Optional<TutorModel> tutorOptional = tutorService.buscarTutorPorId(id);
        return tutorOptional.map(tutor -> ResponseEntity.ok().body(tutor))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorModel> atualizarTutor(@PathVariable Integer id, @RequestBody TutorModel tutorAtualizado) {
        Optional<TutorModel> tutorOptional = tutorService.buscarTutorPorId(id);
        if (tutorOptional.isPresent()) {
            TutorModel tutorExistente = tutorOptional.get();
            tutorExistente.setNome(tutorAtualizado.getNome());
            tutorExistente.setEspecialidade(tutorAtualizado.getEspecialidade());
            TutorModel tutorAtualizadoSalvo = tutorService.atualizarTutor(id, tutorExistente);
            return ResponseEntity.ok(tutorAtualizadoSalvo);
        } else {
            throw new ResourceNotFoundException("Tutor não encontrado para atualizar.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTutor(@PathVariable Integer id) {
        Optional<TutorModel> tutorOptional = tutorService.buscarTutorPorId(id);
        if (tutorOptional.isPresent()) {
            tutorService.deletarTutorPorId(id);
        } else {
            throw new ResourceNotFoundException("Tutor não encontrado para deletar.");
        }
        return null;
    }
}
