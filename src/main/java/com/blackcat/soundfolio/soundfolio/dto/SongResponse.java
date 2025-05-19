package com.blackcat.soundfolio.soundfolio.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SongResponse {
    private Long id;
    private String title;
    private String artist;
    private String albumName;
    private String albumArtUrl;
    private Double rating;
    private String review;
    private List<String> moods; // just the mood names, not Mood objects
}
