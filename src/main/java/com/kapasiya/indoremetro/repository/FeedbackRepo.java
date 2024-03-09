package com.kapasiya.indoremetro.repository;

import com.kapasiya.indoremetro.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {

}