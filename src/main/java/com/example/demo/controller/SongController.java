package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Song;
import com.example.demo.service.SongService;

@Controller
public class SongController {
	@Autowired
	SongService service;
	@PostMapping("/addSong")
	public String  addSong(@ModelAttribute Song song)
	{
		boolean songStatus=service.songExists(song.getName());
		if(songStatus==false)
		{
			service.addSong(song);	
			System.out.println("Song Added Successfully");
		}
		else {
			System.out.println("Song Already Exist");
		}
		
		return  "Admin";
	}
	@GetMapping("/viewSongs")
	public String viewSong(Model model)
	{
		List<Song>SongList=service.fetchAllSongs();
		model.addAttribute("songs", SongList);
		return "displaySongs";
	}
	@GetMapping("/playSongs")
	public String playSongs(Model model)
	{
		boolean premiumUser=false;
		if(premiumUser==true)
		{
		List<Song>SongList=service.fetchAllSongs();
		model.addAttribute("songs", SongList);
		return "displaySongs";
	}
	else {
		return "makePayment";
	  }
	}
	

}
