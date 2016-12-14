package com.marieindustries.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "book", uniqueConstraints = @UniqueConstraint(columnNames = { "username" }) )

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "book_id", unique = true, nullable = false)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username", nullable = false)
	private User user;
	@Column(name = "name", nullable = false, length = 45)
	private String name;
	private String author;
	private String genre;
	private String rating;
	private boolean completed;
	
	private String[] genres = {"Biography", "Nature", "Fiction", "Literature", "Instructional", "Psychology", "Science", "Other"};
	
	public Book(){}

	public Book(String name, String author) {
		super();
		this.name = name;
		this.author = author;
	}

	public Book(String name, String author, String genre, String rating, boolean completed, User user) {
		super();
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.rating = rating;
		this.completed = completed;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
