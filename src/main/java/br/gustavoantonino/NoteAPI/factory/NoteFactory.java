package br.gustavoantonino.NoteAPI.factory;


import br.gustavoantonino.NoteAPI.entity.Note;
import br.gustavoantonino.NoteAPI.dto.RequestNoteDTO;

public class NoteFactory {

    public static Note createNoteFromDTO(RequestNoteDTO requestNoteDTO) {
        return new Note(requestNoteDTO);  
    }
}
