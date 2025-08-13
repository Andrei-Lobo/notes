package com.notesbackend.notes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.notesbackend.notes.model.Note;
import com.notesbackend.notes.model.User;
import com.notesbackend.notes.repository.NoteRepository;
import com.notesbackend.notes.repository.UserRepository;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteService(NoteRepository noteRepository, UserRepository userRepository){
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    public Note createNote(Long userId, String title, String content){
        User user = userRepository.findById(userId).orElseThrow();
        Note note = new Note(title, content, user);
        return noteRepository.save(note);
    }

    public List<Note> getNotesByUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow();
        return noteRepository.findByUser(user);
    }

    public Note updateNote(Long noteId, String title, String content){
        Note note = noteRepository.findById(noteId).orElseThrow();
        note.setTitle(title);
        note.setContent(content);
        return noteRepository.save(note);
    }

    public void deleteNote(Long noteId){
        noteRepository.deleteById(noteId);
    }
    
}
