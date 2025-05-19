package com.blackcat.soundfolio.soundfolio.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class SongRequest {

    @NotBlank(message = "Title cannot be blank.")
    private String title;

    @NotBlank(message = "Artist cannot be blank.")
    private String artist;

    private String albumName;
    private String albumArtUrl;

    @DecimalMin(value = "1.0", message = "Rating must be at least 1.0")
    @DecimalMax(value = "5.0", message = "Rating must be at most 5.0")
    private Double rating;

    @Size(max = 1000, message = "Review must be 1000 characters or less")
    private String review;

    private List<String> moods; // mood names, e.g., ["chill", "nostalgic"]
}