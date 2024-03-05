package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.repository.PlaylistRepository;
import com.kodnest.tunehub.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{


	@Autowired
	PlaylistRepository playlistrepository;

	public String addplaylist(Playlist playlist) {
		playlistrepository.save(playlist);
		return "adminhome";
		
	}
	
	public List<Playlist> fetchAllPlaylist() {
		List<Playlist> allplaylist = playlistrepository.findAll();
		return allplaylist;
	}
}
