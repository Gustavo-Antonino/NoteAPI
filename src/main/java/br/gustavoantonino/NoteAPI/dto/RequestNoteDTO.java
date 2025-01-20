package br.gustavoantonino.NoteAPI.dto;

import jakarta.validation.constraints.NotNull;

public record RequestNoteDTO(

        String id,
        @NotNull(message = "Title is required.")String title,
        @NotNull(message = "Content is required.")String content) {
}
