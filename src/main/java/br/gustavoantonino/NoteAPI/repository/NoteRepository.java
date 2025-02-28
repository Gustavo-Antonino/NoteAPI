package br.gustavoantonino.NoteAPI.repository;

import br.gustavoantonino.NoteAPI.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findAll();

    Optional<Note> findById(Long id);

    Note save(Note note);

    void deleteById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Note n SET n.title = :title, n.content = :content WHERE n.id = :id")
    void updateNote(@Param("id") Long id, @Param("title") String title, @Param("content") String content);
}
