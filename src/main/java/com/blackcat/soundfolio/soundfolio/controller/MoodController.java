package com.blackcat.soundfolio.soundfolio.controller;

import com.blackcat.soundfolio.soundfolio.model.Mood;
import com.blackcat.soundfolio.soundfolio.repository.MoodsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songfolio/tags/moods")
public class MoodController {

    private final MoodsRepository moodRepository;

    public MoodController(MoodsRepository vibeRepository) {
        this.moodRepository = vibeRepository;
    }

    @GetMapping
    public List<Mood> getAllVibes() {
        return moodRepository.findAll();
    }
}