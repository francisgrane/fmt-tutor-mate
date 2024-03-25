package com.fmt.tutor.service;

import com.fmt.tutor.model.AlunoModel;
import com.fmt.tutor.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoModel criarAluno(AlunoModel aluno) {
        return alunoRepository.save(aluno);
    }

    public Optional<AlunoModel> buscarAlunoPorId(Integer id) {
        return alunoRepository.findById(id);
    }

    public ArrayList<AlunoModel> listarTodosOsAlunos() {
        return (ArrayList<AlunoModel>) alunoRepository.findAll();
    }

    public AlunoModel atualizarAluno(AlunoModel aluno) {
        return alunoRepository.save(aluno);
    }

    public void deletarAlunoPorId(Integer id) {
        alunoRepository.deleteById(id);
    }
}
