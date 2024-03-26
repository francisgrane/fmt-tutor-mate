package com.fmt.tutor.service;

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
        return tutorRepository.findById(id);
    }

    public ArrayList<TutorModel> listarTodosOsTutores() {
        return (ArrayList<TutorModel>) tutorRepository.findAll();
    }

    public void deletarTutorPorId(Integer id) {
        tutorRepository.deleteById(id);
    }

    public TutorModel atualizarTutor(TutorModel tutorAtualizado) {
        return tutorRepository.save(tutorAtualizado);
    }
}
