package com.blackcat.soundfolio.soundfolio.controller;

import com.blackcat.soundfolio.soundfolio.dto.SongRequest;
import com.blackcat.soundfolio.soundfolio.dto.SongResponse;
import com.blackcat.soundfolio.soundfolio.model.Song;
import com.blackcat.soundfolio.soundfolio.service.SongService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songfolio/my-music/")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping(path = "/all")
    public List<SongResponse> getAllSongs(){
        return songService.getAllSongs();
    }

    @PostMapping(path = "/create")
    public SongResponse createSong(@Valid @RequestBody SongRequest request) {
        return songService.saveSong(request);
    }

    @GetMapping(path = "/songs")
    public List<SongResponse> getSongs(
            @RequestParam(required = false) String artist,
            @RequestParam(required = false) String mood) {
        return songService.getFilteredSongs(artist, mood);
    }

}