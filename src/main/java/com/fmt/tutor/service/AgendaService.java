package com.fmt.tutor.service;

import com.fmt.tutor.model.AgendaModel;
import com.fmt.tutor.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;

    @Autowired
    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public List<AgendaModel> getAllAgendas() {
        return agendaRepository.findAll();
    }

    public Optional<AgendaModel> getAgendaById(Integer id) {
        return agendaRepository.findById(id);
    }

    public AgendaModel createAgenda(AgendaModel agenda) {
        return agendaRepository.save(agenda);
    }

    public AgendaModel updateAgenda(Integer id, AgendaModel updatedAgenda) {
        if (agendaRepository.existsById(id)) {
            updatedAgenda.setId(id);
            return agendaRepository.save(updatedAgenda);
        } else {
            throw new IllegalArgumentException("Agenda with ID " + id + " not found.");
        }
    }

    public void deleteAgenda(Integer id) {
        agendaRepository.deleteById(id);
    }
}
