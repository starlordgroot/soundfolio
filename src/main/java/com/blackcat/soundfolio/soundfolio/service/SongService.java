package com.blackcat.soundfolio.soundfolio.service;

import com.blackcat.soundfolio.soundfolio.dto.SongRequest;
import com.blackcat.soundfolio.soundfolio.dto.SongResponse;
import com.blackcat.soundfolio.soundfolio.model.Mood;
import com.blackcat.soundfolio.soundfolio.model.Song;
import com.blackcat.soundfolio.soundfolio.repository.MoodsRepository;
import com.blackcat.soundfolio.soundfolio.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final MoodsRepository moodRepository;

    public SongService(SongRepository songRepository, MoodsRepository moodRepository) {
        this.songRepository = songRepository;
        this.moodRepository = moodRepository;
    }

    public List<SongResponse> getAllSongs() {
        return songRepository.findAll().stream()
                .map(song -> SongResponse.builder()
                        .id(song.getId())
                        .title(song.getTitle())
                        .artist(song.getArtist())
                        .albumName(song.getAlbumName())
                        .rating(song.getRating())
                        .review(song.getReview())
                        .moods(song.getMoods().stream().map(m -> m.getName()).toList())
                        .build())
                .toList();
    }

    public SongResponse saveSong(SongRequest request) {
        Set<Mood> moods = new HashSet<>();

        if (request.getMoods() != null) {
            for (String moodName : request.getMoods()) {
                moodRepository.findByName(moodName.trim().toLowerCase()).ifPresent(moods::add);
            }
        }

        Song song = Song.builder()
                .title(request.getTitle())
                .artist(request.getArtist())
                .albumName(request.getAlbumName())
                .albumArtUrl(request.getAlbumArtUrl())
                .rating(request.getRating())
                .review(request.getReview())
                .moods(moods)
                .build();

        Song savedSong = songRepository.save(song);

        return SongResponse.builder()
                .id(savedSong.getId())
                .title(savedSong.getTitle())
                .artist(savedSong.getArtist())
                .albumName(savedSong.getAlbumName())
                .rating(savedSong.getRating())
                .review(savedSong.getReview())
                .moods(savedSong.getMoods().stream().map(m -> m.getName()).toList())
                .build();

    }
}