package com.marieindustries.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Livre implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String author;
	private String genre;
	private String rating;
	private String completed;
	
	private String[] ratings = {"1 Star", "2 Stars", "3 Stars", "4 Stars", "5 Stars"};
	private String[] isCompleted = {"yes", "no"};
	private String[] genres = {"Biography", "Nature", "Fiction", "Literature", "Instructional", "Psychology", "Science", "Other"};
	
	public Livre(){}
	
	public Livre(String name, String author) {
		this.name = name;
		this.author = author;
	}

	public Livre(String name, String author, String genre, String rating, String completed) {
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

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}
	
	public String[] getIsCompleted() {
		return isCompleted;
	}
	
	public void setIsCompleted(String[] isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String[] getGenres() {
		return genres;
	}

	public void setGenres(String[] genres) {
		this.genres = genres;
	}
	
	public String[] getRatings() {
		return ratings;
	}

	public void setRatings(String[] ratings) {
		this.ratings = ratings;
	}
	
}
