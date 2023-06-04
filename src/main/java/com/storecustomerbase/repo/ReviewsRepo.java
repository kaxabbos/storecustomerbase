package com.storecustomerbase.repo;

import com.storecustomerbase.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepo extends JpaRepository<Reviews, Long> {
}
