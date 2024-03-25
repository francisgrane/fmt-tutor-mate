package com.fmt.tutor.repository;

import com.fmt.tutor.model.AgendaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<AgendaModel, Integer> {
}
