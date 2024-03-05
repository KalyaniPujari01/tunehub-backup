package com.kodnest.tunehub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Playlist;

@Service
public interface PlaylistService {

	public String addplaylist(Playlist playlist);
	public List<Playlist> fetchAllPlaylist();

}