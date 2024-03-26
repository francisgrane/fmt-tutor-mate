package com.fmt.tutor.service;

import com.fmt.tutor.exception.ResourceNotFoundException;
import com.fmt.tutor.model.TutorModel;
import com.fmt.tutor.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public TutorModel criarTutor(TutorModel tutor) {
        return tutorRepository.save(tutor);
    }

    public Optional<TutorModel> buscarTutorPorId(Integer id) {
        if (!tutorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tutor não encontrado.");
        }
        return tutorRepository.findById(id);
    }

    public ArrayList<TutorModel> listarTodosOsTutores() {
        return (ArrayList<TutorModel>) tutorRepository.findAll();
    }

    public void deletarTutorPorId(Integer id) {
        if (!tutorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id do Tutor não encontrado.");
        } else {
            tutorRepository.deleteById(id);
        }
    }

    public TutorModel atualizarTutor(Integer id, TutorModel tutorAtualizado) {
        if (tutorRepository.existsById(id)) {
            return tutorRepository.save(tutorAtualizado);
        } else {
            throw new ResourceNotFoundException("Id do Tutor não encontrado.");
        }
    }
}
