package com.fmt.tutor.service;

import com.fmt.tutor.exception.ResourceNotFoundException;
import com.fmt.tutor.model.AlunoModel;
import com.fmt.tutor.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoModel criarAluno(AlunoModel aluno) {
        return alunoRepository.save(aluno);
    }

    public Optional<AlunoModel> buscarAlunoPorId(Integer id) {
        return alunoRepository.findById(id);
    }

    public ArrayList<AlunoModel> listarTodosOsAlunos() {
        return new ArrayList<>(alunoRepository.findAll());
    }

    public AlunoModel atualizarAluno(Integer id, AlunoModel alunoAtualizado) {
        if (alunoRepository.existsById(id)) {
            return alunoRepository.save(alunoAtualizado);
        } else {
            throw new ResourceNotFoundException("Id do Aluno não encontrado.");
        }
    }

    public void deletarAlunoPorId(Integer id) {
        if (!alunoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id do Aluno não encontrado.");
        }
        alunoRepository.deleteById(id);
    }
}
