package com.fmt.tutor.controller;

import com.fmt.tutor.exception.ResourceNotFoundException;
import com.fmt.tutor.model.AlunoModel;
import com.fmt.tutor.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<AlunoModel>> listarTodosOsAlunos() {
        ArrayList<AlunoModel> alunos = alunoService.listarTodosOsAlunos();
        if (alunos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(alunos);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoModel> buscarAlunoPorId(@PathVariable Integer id) {
        Optional<AlunoModel> alunoOptional = alunoService.buscarAlunoPorId(id);
        return alunoOptional.map(aluno -> ResponseEntity.ok().body(aluno))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AlunoModel> criarAluno(@RequestBody AlunoModel aluno) {
        AlunoModel novoAluno = alunoService.criarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoModel> atualizarAlunoPorId(@PathVariable Integer id, @RequestBody AlunoModel alunoAtualizado) {
        Optional<AlunoModel> alunoOptional = alunoService.buscarAlunoPorId(id);
        if (alunoOptional.isPresent()) {
            AlunoModel alunoExistente = alunoOptional.get();
            alunoExistente.setNome(alunoAtualizado.getNome());
            AlunoModel alunoAtualizadoSalvo = alunoService.atualizarAluno(id, alunoExistente);
            return ResponseEntity.ok(alunoAtualizadoSalvo);
        } else {
            throw new ResourceNotFoundException("Aluno não encontrado para atualizar.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAlunoPorId(@PathVariable Integer id) {
        Optional<AlunoModel> alunoOptional = alunoService.buscarAlunoPorId(id);
        if (alunoOptional.isPresent()) {
            alunoService.deletarAlunoPorId(id);
        } else {
            throw new ResourceNotFoundException("Aluno não encontrado para deletar.");
        }
        return null;
    }

}
