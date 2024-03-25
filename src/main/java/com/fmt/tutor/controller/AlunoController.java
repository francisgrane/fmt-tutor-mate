package com.fmt.tutor.controller;

import com.fmt.tutor.model.AlunoModel;
import com.fmt.tutor.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoModel> criarAluno(@RequestBody AlunoModel aluno) {
        AlunoModel novoAluno = alunoService.criarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @GetMapping
    public ResponseEntity<ArrayList<AlunoModel>> buscarTodosOsAlunos() {
        ArrayList<AlunoModel> alunos = alunoService.buscaTodosOsAlunos();
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

    @PutMapping("/{id}")
    public ResponseEntity<AlunoModel> atualizarAluno(@PathVariable Integer id, @RequestBody AlunoModel alunoAtualizado) {
        Optional<AlunoModel> alunoOptional = alunoService.buscarAlunoPorId(id);
        if (alunoOptional.isPresent()) {
            AlunoModel alunoExistente = alunoOptional.get();
            alunoExistente.setNome(alunoAtualizado.getNome());
            AlunoModel alunoAtualizadoSalvo = alunoService.atualizarAluno(alunoExistente);
            return ResponseEntity.ok(alunoAtualizadoSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Integer id) {
        alunoService.deletarAlunoPorId(id);
        return ResponseEntity.noContent().build();
    }

}
