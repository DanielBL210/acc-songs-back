package com.accenture.songs.controller;

import com.accenture.songs.exception.ResourceNotFoundException;
import com.accenture.songs.model.SongModel;
import com.accenture.songs.repository.SongRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/songs")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class SongsController {

    @Autowired
    private SongRepository songRepository;

    public SongsController() {
    }

    public SongsController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    /*@GetMapping(path = "/helloworld", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody SongModel helloworld(){
        SongModel songModel=new SongModel("Hola Mundo","Esta.png","pepito","merengue","album","User",new Date(),new Date());
        return songModel;
    }*/

    @GetMapping("/getAll")
    public List<SongModel> getAllSongs(){
        return this.songRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<SongModel> getSongById(@PathVariable(value = "id") Long songId)
            throws ResourceNotFoundException {
        SongModel songModel = songRepository.findById(songId)
                .orElseThrow(() -> new ResourceNotFoundException("Song not found for this id :: " + songId));
        return ResponseEntity.ok().body(songModel);
    }

    @PostMapping("/save")
    public SongModel createSong(@RequestBody SongModel song) {
        System.out.println("Entro al servicio");
        SongModel sm=new SongModel();
        sm.asignDetails(song);
        sm.setCreate_at(new Date());
        sm.setUpdate_at(new Date());
        System.out.println("A punto de guardar "+sm.toString());
        return songRepository.save(sm);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SongModel> updateSong(@PathVariable(value = "id") Long songId,
                                               @RequestBody SongModel songDetails)
            throws ResourceNotFoundException {
        SongModel song=songRepository.findById(songId)
                .orElseThrow(() -> new ResourceNotFoundException("Song not found for this id :: " + songId));
        song.asignDetails(songDetails);
        song.setUpdate_at(new Date());
        return ResponseEntity.ok(this.songRepository.save(song));
    }

    @DeleteMapping("/deleteById/{id}")
    public Map<String,Boolean> deleteSong(@PathVariable(value = "id") Long songId) throws ResourceNotFoundException {
        SongModel song = songRepository.findById(songId)
                .orElseThrow(() -> new ResourceNotFoundException("Song not found for this id :: " + songId));
        songRepository.delete(song);
        Map<String,Boolean> response= new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }


}
