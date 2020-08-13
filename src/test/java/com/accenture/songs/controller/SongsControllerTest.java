package com.accenture.songs.controller;

import com.accenture.songs.exception.ErrorDetails;
import com.accenture.songs.model.SongModel;
import com.accenture.songs.repository.SongRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

class SongsControllerTest {


    private SongRepository songRepositoryMock = Mockito.mock(SongRepository.class);

    @Autowired
    SongsController songsController=new SongsController(songRepositoryMock);

    @BeforeEach
    void setUp() {
        SongModel sm =new SongModel();
        sm.setTitle("Beat It");
        sm.setImage("MJ");
        sm.setArtist("Michael Jackson");
        sm.setGenre("Pop");
        sm.setAlbum("Thriller");
        sm.setUser_song("Andres");
        sm.setCreate_at(new Date());
        sm.setUpdate_at(new Date());
        Optional<SongModel> osm= Optional.of(sm);
        Mockito.when(songRepositoryMock.findById(5L)).thenReturn(osm);

        List<SongModel> lsm=new ArrayList<>();
        lsm.add(sm);
        Mockito.when(songRepositoryMock.findAll()).thenReturn(lsm);
        Mockito.when(songRepositoryMock.save(Mockito.any())).thenReturn(sm);

    }



    @Test
    void getAllSongs() {
        List<SongModel> lsm=songsController.getAllSongs();
        Assertions.assertEquals(lsm.size(),1);
    }

    @Test
    void getSongById() {
        ResponseEntity<SongModel> sm;
        try {
            sm=songsController.getSongById(5L);
            System.out.println(sm.getBody().toString());
            Assertions.assertEquals(sm.getBody().getTitle(),"Beat It");
        }catch (Exception e){
            System.out.println("Error "+e.getMessage());
            ErrorDetails ed = new ErrorDetails(new Date(),e.getMessage(),e.getLocalizedMessage());
            Assertions.fail();
        }
    }

    @Test
    void createSong() {
        SongModel sm =new SongModel();
        sm.setTitle("Beat It");
        sm.setImage("MJ");
        sm.setArtist("Michael Jackson");
        sm.setGenre("Pop");
        sm.setAlbum("Thriller");
        sm.setUser_song("Andres");
        sm.setCreate_at(new Date());
        sm.setUpdate_at(new Date());
        SongModel smresp=songsController.createSong(sm);
        System.out.println("ERSA "+smresp);
        System.out.println("SM "+sm.toString());
        Assertions.assertEquals(smresp.getTitle(),sm.getTitle());
    }

    @Test
    void updateSong() {
        SongModel sm =new SongModel();
        sm.setTitle("Beat It");
        sm.setImage("MJ");
        sm.setArtist("Michael Jackson");
        sm.setGenre("Pop");
        sm.setAlbum("Thriller");
        sm.setUser_song("Andres");
        sm.setCreate_at(new Date());
        sm.setUpdate_at(new Date());
        try {
            SongModel smresp=songsController.updateSong(5L, sm).getBody();
            System.out.println("ERSA "+smresp);
            Assertions.assertEquals(smresp.getTitle(),sm.getTitle());
        }catch (Exception e){
            System.out.println("Error "+e.getMessage());
            ErrorDetails ed = new ErrorDetails(new Date(),e.getMessage(),e.getLocalizedMessage());
            Assertions.fail();
        }
    }

}