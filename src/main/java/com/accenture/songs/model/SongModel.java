package com.accenture.songs.model;



import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "songs")
public class SongModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String title;

    @Column(nullable = false)
    @NotNull
    private String image;

    @Column(nullable = false)
    @NotNull
    private String artist;

    @Column(nullable = false)
    @NotNull
    private String genre;

    @Column(nullable = false)
    @NotNull
    private String album;

    @Column(nullable = false)
    @NotNull
    private String user_song;

    @Column(nullable = true)

    private Date create_at;

    @Column(nullable = true)

    private Date update_at;

    public SongModel() {
    }

    public SongModel(String title, String image, String artist, String genre, String album, String user_song, Date create_at, Date update_at) {
        this.title = title;
        this.image = image;
        this.artist = artist;
        this.genre = genre;
        this.album = album;
        this.user_song = user_song;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getUser_song() {
        return user_song;
    }

    public void setUser_song(String user_song) {
        this.user_song = user_song;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public void asignDetails(SongModel details){
        setAlbum(details.getAlbum());
        setArtist(details.getArtist());
        setGenre(details.getGenre());
        setImage(details.getImage());
        setTitle(details.getTitle());
        setUser_song(details.getUser_song());
    }

    @Override
    public String toString() {
        return "SongModel {" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", album='" + album + '\'' +
                ", user='" + user_song + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }
}
