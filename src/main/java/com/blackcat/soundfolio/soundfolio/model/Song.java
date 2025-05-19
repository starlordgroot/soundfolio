package com.blackcat.soundfolio.soundfolio.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String artist;
    private String albumName;
    private String albumArtUrl;

    private Double rating; // 0 - 5, ex. 4.5 stars.
    private String review;

    private LocalDate listenedDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Boolean isPrivate = false;

    //Many-to-many, Songs can have multiple "vibes".
    @ManyToMany
    @JoinTable(
            name = "song_vibe",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "vibe_id")
    )
    private Set<Vibe> vibes = new HashSet<>();

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

}
