package com.blackcat.soundfolio.soundfolio.repository;

import com.blackcat.soundfolio.soundfolio.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findByArtistIgnoreCase(String artist);

    @Query("SELECT s FROM Song s JOIN s.moods m WHERE LOWER(m.name) = LOWER(:mood)")
    List<Song> findByMoodNameIgnoreCase(@Param("mood") String mood);

    @Query("SELECT s FROM Song s JOIN s.moods m WHERE LOWER(m.name) = LOWER(:mood) AND LOWER(s.artist) = LOWER(:artist)")
    List<Song> findByArtistAndMood(@Param("artist") String artist, @Param("mood") String mood);

}
