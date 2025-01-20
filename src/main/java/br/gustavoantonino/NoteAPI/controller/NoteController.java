package br.gustavoantonino.NoteAPI.controller;

import br.gustavoantonino.NoteAPI.dto.RequestNoteDTO;
import br.gustavoantonino.NoteAPI.entity.Note;
import br.gustavoantonino.NoteAPI.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // Listar todas as notas
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    // Buscar uma nota por id
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Optional<Note> note = noteService.getNoteById(id);
        return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar uma nova nota
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody RequestNoteDTO requestNoteDTO) {
        Note createdNote = noteService.createNote(requestNoteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNote);
    }

    // Atualizar uma nota
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateNote(@PathVariable Long id, @RequestBody RequestNoteDTO requestNoteDTO) {
        noteService.updateNote(id, requestNoteDTO);
        return ResponseEntity.noContent().build();  // 204 No Content
    }

    // Deletar uma nota
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();  // 204 No Content
    }
}
