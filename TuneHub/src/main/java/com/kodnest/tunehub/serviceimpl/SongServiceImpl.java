package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.repository.SongRepository;
import com.kodnest.tunehub.service.SongService;

@Service
public class SongServiceImpl  implements SongService{

	@Autowired
	SongRepository songrepository;

	@Override
	public String addSong(Song song) {
		songrepository.save(song);
		return "song added successfully";
	}

	public boolean linkExists(String link) {
		if(songrepository.findByLink(link) != null) {
			return true;
		}
		else {
			return false;
		}
		
	}

	public List<Song> fetchAllSongs() {
		List<Song> songs = songrepository.findAll();
		return songs;
	}

	@Override
	public void updateSong(Song s) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}
