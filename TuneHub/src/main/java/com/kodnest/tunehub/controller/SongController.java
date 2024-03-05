package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.service.SongService;
import com.kodnest.tunehub.serviceimpl.SongServiceImpl;

@Controller
public class SongController {


	@Autowired
	SongServiceImpl songserviceimpl;

	@PostMapping("/addsong")
	public String addsong(@ModelAttribute Song song) {

		String link = song.getLink();
		
		boolean status = songserviceimpl.linkExists(link);
		if(status == false) {
			songserviceimpl.addSong(song);
			System.out.println("song added");
		}
		else {
			System.out.println("song already exists");
		}
		
		return "newsong";
	}
	
	@GetMapping("/viewsongs")
	public String viewsongs(Model model) {
		List<Song> songList = songserviceimpl.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "displaysongs";
	}
	
	@GetMapping("/playsongs")
	public String playsongs(Model model) {
		boolean premium = true;
		
		if(premium) {
		List<Song> songList = songserviceimpl.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "displaysongs";
		} else {
			return "subscriptionform";
		}
	}
	
	
	
	
	
	
	
	
	
	
}
