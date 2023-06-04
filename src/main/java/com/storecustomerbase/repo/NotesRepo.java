package com.storecustomerbase.repo;

import com.storecustomerbase.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepo extends JpaRepository<Notes, Long> {

}
