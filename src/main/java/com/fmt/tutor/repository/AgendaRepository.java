package com.fmt.tutor.repository;

import com.fmt.tutor.model.AgendaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendaRepository extends JpaRepository<AgendaModel, Integer> {
    List<AgendaModel> findByAlunoIdOrderByDataAsc(Long alunoId);

    List<AgendaModel> findByTutorIdOrderByDataAsc(Long tutorId);
}
