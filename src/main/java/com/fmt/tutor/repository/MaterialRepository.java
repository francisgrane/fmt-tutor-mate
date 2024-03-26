package com.fmt.tutor.repository;

import com.fmt.tutor.model.MaterialModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<MaterialModel, Integer> {
}
