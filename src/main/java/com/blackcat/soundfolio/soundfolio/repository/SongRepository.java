package com.blackcat.soundfolio.soundfolio.repository;

import com.blackcat.soundfolio.soundfolio.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {


}
