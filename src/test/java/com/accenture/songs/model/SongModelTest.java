package com.accenture.songs.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SongModelTest {

    @Test
    void asignDetails() {
        SongModel song=new SongModel("Billie Jean","MJ","Michael Jackson","Pop","Thriller","Alberto",new Date(),new Date());
        SongModel model=new SongModel();
        model.asignDetails(song);
        boolean result = song.getAlbum().equals(model.getAlbum())
                && song.getArtist().equals(model.getArtist())
                && song.getGenre().equals(model.getGenre())
                && song.getImage().equals(model.getImage())
                && song.getTitle().equals(model.getTitle())
                && song.getUser_song().equals(model.getUser_song());
        Assertions.assertEquals(result,true);
    }
}