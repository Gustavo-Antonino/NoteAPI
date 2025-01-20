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

    // Listar todas as notas
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    // Buscar uma nota por id
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    // Criar uma nova nota
    @Transactional
    public Note createNote(RequestNoteDTO requestNoteDTO) {
        Note note = new Note(requestNoteDTO);  // Converte o DTO para a entidade Note
        return noteRepository.save(note);
    }

    // Atualizar uma nota existente
    @Transactional
    public void updateNote(Long id, RequestNoteDTO requestNoteDTO) {
        noteRepository.updateNote(id, requestNoteDTO.title(), requestNoteDTO.content());
    }

    // Deletar uma nota por id
    @Transactional
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
