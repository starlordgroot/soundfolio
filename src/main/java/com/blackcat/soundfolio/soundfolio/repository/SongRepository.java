package com.blackcat.soundfolio.soundfolio.repository;

import com.blackcat.soundfolio.soundfolio.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findByArtistIgnoreCase(String artist);

}
