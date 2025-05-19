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
    private final ITunesLookupService itunesLookupService;

    public SongService(SongRepository songRepository, MoodsRepository moodRepository, ITunesLookupService itunesLookupService) {
        this.songRepository = songRepository;
        this.moodRepository = moodRepository;
        this.itunesLookupService = itunesLookupService;
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


        ITunesLookupService.ItunesMetadata metadata = itunesLookupService.fetchSongMetadata(request.getTitle(), request.getArtist());


        Song song = Song.builder()
                .title(request.getTitle())
                .artist(request.getArtist())
                .albumName(request.getAlbumName() != null ? request.getAlbumName() : (metadata != null ? metadata.albumName() : null))
                .albumArtUrl(request.getAlbumArtUrl() != null ? request.getAlbumArtUrl() : (metadata != null ? metadata.albumArtUrl() : null))
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