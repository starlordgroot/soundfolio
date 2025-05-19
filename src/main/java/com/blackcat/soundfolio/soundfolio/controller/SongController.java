package com.blackcat.soundfolio.soundfolio.controller;

import com.blackcat.soundfolio.soundfolio.dto.SongRequest;
import com.blackcat.soundfolio.soundfolio.model.Song;
import com.blackcat.soundfolio.soundfolio.service.SongService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/songfolio/my-music/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping(path = "/create")
    public Song createSong(@Valid @RequestBody SongRequest request) {
        return songService.saveSong(request);
    }
}