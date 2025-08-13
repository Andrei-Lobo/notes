package com.notesbackend.notes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notesbackend.notes.model.User;
import com.notesbackend.notes.model.Note;;

public interface NoteRepository extends JpaRepository<Note, Long>{

    List<Note> findbyUser(User user);
    
}
