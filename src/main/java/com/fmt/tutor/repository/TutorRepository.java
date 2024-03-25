package com.fmt.tutor.repository;

import com.fmt.tutor.model.TutorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<TutorModel, Integer> {
}
