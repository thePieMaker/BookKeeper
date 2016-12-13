package com.marieindustries.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String author;
	private String genre;
	private String rating;
	private boolean completed;
	
	private String[] genres = {"Biography", "Nature", "Fiction", "Literature", "Instructional", "Psychology", "Science", "Other"};
	
	public Book(){}

	public Book(String name, String author, String genre) {
		super();
		this.name = name;
		this.author = author;
		this.genre = genre;
	}
	
	

	public Book(String name, String author, String genre, String rating, boolean completed) {
		super();
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.rating = rating;
		this.completed = completed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String[] getGenres() {
		return genres;
	}

	public void setGenres(String[] genres) {
		this.genres = genres;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	
}
