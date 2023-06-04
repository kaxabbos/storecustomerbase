package com.storecustomerbase.repo;

import com.storecustomerbase.model.Primarys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimarysRepo extends JpaRepository<Primarys, Long> {
}
