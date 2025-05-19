package com.blackcat.soundfolio.soundfolio.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.json.*;

import java.net.URI;

@Service
public class ITunesLookupService {

    private final RestTemplate restTemplate = new RestTemplate();

    public ItunesMetadata fetchSongMetadata(String title, String artist) {
        String query = artist + " " + title;

        URI uri = UriComponentsBuilder.fromHttpUrl("https://itunes.apple.com/search")
                .queryParam("term", query)
                .queryParam("media", "music")
                .queryParam("limit", 1)
                .build()
                .encode()
                .toUri();

        String response = restTemplate.getForObject(uri, String.class);
        JSONObject json = new JSONObject(response);

        if (json.getInt("resultCount") > 0) {
            JSONObject result = json.getJSONArray("results").getJSONObject(0);

            String album = result.optString("collectionName", null);
            String artUrl = result.optString("artworkUrl100", null);

            return new ItunesMetadata(album, artUrl);
        }

        return null;
    }

    public record ItunesMetadata(String albumName, String albumArtUrl) {}

}
