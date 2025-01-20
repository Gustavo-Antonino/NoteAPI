package br.gustavoantonino.NoteAPI.service;

import br.gustavoantonino.NoteAPI.dto.RequestNoteDTO;
import br.gustavoantonino.NoteAPI.entity.Note;
import br.gustavoantonino.NoteAPI.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    @Transactional
    public Note createNote(RequestNoteDTO requestNoteDTO) {
        Note note = new Note(requestNoteDTO);
        return noteRepository.save(note);
    }

    @Transactional
    public void updateNote(Long id, RequestNoteDTO requestNoteDTO) {
        noteRepository.updateNote(id, requestNoteDTO.title(), requestNoteDTO.content());
    }

    @Transactional
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
