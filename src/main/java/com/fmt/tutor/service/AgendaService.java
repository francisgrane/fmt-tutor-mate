package com.fmt.tutor.service;

import com.fmt.tutor.exception.ResourceNotFoundException;
import com.fmt.tutor.model.AgendaModel;
import com.fmt.tutor.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;

    @Autowired
    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public ArrayList<AgendaModel> listarTodasAsAgendas() {
        return (ArrayList<AgendaModel>) agendaRepository.findAll();
    }

    public Optional<AgendaModel> buscarAgendaPorId(Integer id) {
        if (!agendaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Agenda não encontrada.");
        }
        return agendaRepository.findById(id);
    }

    public AgendaModel criarAgenda(AgendaModel agenda) {
        return agendaRepository.save(agenda);
    }

    public AgendaModel atualizarAgenda(Integer id, AgendaModel updatedAgenda) {
        if (agendaRepository.existsById(id)) {
            return agendaRepository.save(updatedAgenda);
        } else {
            throw new ResourceNotFoundException("Id da Agenda não encontrado.");
        }
    }

    public void deletarAgendaPorId(Integer id) {
        if (!agendaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id da Agenda não encontrado.");
        } else {
            agendaRepository.deleteById(id);
        }
    }

    public List<AgendaModel> getAgendamentosPorAlunoId(Long alunoId) {
        return agendaRepository.findByAlunoIdOrderByDataAsc(alunoId);
    }

    public List<AgendaModel> getAgendamentosPorTutorId(Long tutorId) {
        return agendaRepository.findByTutorIdOrderByDataAsc(tutorId);
    }

}
