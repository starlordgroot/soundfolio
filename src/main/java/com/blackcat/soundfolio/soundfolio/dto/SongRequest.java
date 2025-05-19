package com.blackcat.soundfolio.soundfolio.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class SongRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String artist;

    private String albumName;
    private String albumArtUrl;

    @DecimalMin("1.0")
    @DecimalMax("5.0")
    private Double rating;

    private String review;

    private List<String> moods; // mood names, e.g., ["chill", "nostalgic"]
}