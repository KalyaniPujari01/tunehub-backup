package com.kodnest.tunehub.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.SongService;
import com.kodnest.tunehub.serviceimpl.PlaylistServiceImpl;

@Controller
public class PlaylistController {



	@Autowired
	SongService songservice;


	@Autowired
	PlaylistServiceImpl playlistserviceipml;

	@GetMapping("/createplaylist")
	public String createPlaylists(Model model) {
		List<Song> songList=songservice.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createplaylist";
	}

	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist){

		playlistserviceipml.addplaylist(playlist);
		List<Song> songlist=playlist.getSongs();
		for (Song s:songlist) {
			s.getPlaylists().add(playlist);
			songservice.updateSong(s);
		}
		return "adminhome";

	}

	@GetMapping("/viewplaylists")
	public String viewplaylists(Model model){
		List<Playlist> Playlist =playlistserviceipml.fetchAllPlaylist();
		//return "view";
		model.addAttribute("allplaylist", Playlist);
		return "displayplaylist";
	}



}




