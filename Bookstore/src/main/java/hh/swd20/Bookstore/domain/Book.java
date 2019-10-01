package hh.swd20.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	//attributes
	@Id
	private String isbn; //works as Id
	private String title;
	private String author;
	private int year;
	private double price;

	@ManyToOne
	@JoinColumn(name="category")
	private Category category;
	
	
	
	//constructors
	public Book() {
		super();
	}

	public Book(String isbn, String title, String author, int year, double price, Category category) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.year = year;
		this.price = price;
		this.category = category;
	}

	
	//setters and getters
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	public String getIsbn() {
		return isbn;
	}

	public double getPrice() {
		return price;
	}
	
	public Category getCategory() {
		return category;
	}

	
	//toString
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price
				+ "]"; //category not toString
	}
	
	
	
	
	
}
