package com.accenture.songs.repository;

import com.accenture.songs.model.SongModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository  extends JpaRepository<SongModel,Long> {
}
