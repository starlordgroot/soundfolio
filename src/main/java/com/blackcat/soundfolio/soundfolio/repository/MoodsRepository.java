package com.blackcat.soundfolio.soundfolio.repository;

import com.blackcat.soundfolio.soundfolio.model.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoodsRepository extends JpaRepository<Mood, Long> {
    Optional<Mood> findByName(String name);
}
