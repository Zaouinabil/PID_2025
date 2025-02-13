package com.example.pid_2025.service;

import com.example.pid_2025.dal.ArtistRepository;
import com.example.pid_2025.entities.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArtistService {

    private  ArtistRepository artistRepository;
    public List<Artist> getallArtistes() {
        List<Artist> artists = new ArrayList<>();

        artistRepository.findAll().forEach(artists::add);

        return  artists;
    }

    public Optional<Artist> getArtist(long id) {
        return artistRepository.findById(id);
    }

    public void addArtist(Artist artist) {
        artistRepository.save(artist);
    }

    public void updateArtist(long id, Artist artist) {
        artistRepository.save(artist);
    }

    public void deleteArtist(long id) {
        artistRepository.deleteById(id);
    }


}
