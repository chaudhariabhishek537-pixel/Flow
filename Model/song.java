package com.example.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class song {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String song_Tittle;
	private String artist;
	private String audio_Url;
	private String cover_image_Url;
	
	public song() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSong_Tittle() {
		return song_Tittle;
	}

	public void setSong_Tittle(String song_Tittle) {
		this.song_Tittle = song_Tittle;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAudio_Url() {
		return audio_Url;
	}

	public void setAudio_Url(String audio_Url) {
		this.audio_Url = audio_Url;
	}

	public String getCover_image_Url() {
		return cover_image_Url;
	}

	public void setCover_image_Url(String cover_image_Url) {
		this.cover_image_Url = cover_image_Url;
	}

	public song(int id, String song_Tittle, String artist, String audio_Url, String cover_image_Url) {
		super();
		this.id = id;
		this.song_Tittle = song_Tittle;
		this.artist = artist;
		this.audio_Url = audio_Url;
		this.cover_image_Url = cover_image_Url;
	}

	@Override
	public String toString() {
		return "song [id=" + id + ", song_Tittle=" + song_Tittle + ", Artist=" + artist + ", audio_Url=" + audio_Url
				+ ", cover_image_Url=" + cover_image_Url + "]";
	}
	
}
