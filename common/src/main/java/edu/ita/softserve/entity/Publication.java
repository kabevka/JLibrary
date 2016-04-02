package edu.ita.softserve.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="publication")
public class Publication implements Serializable{
   	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
   
    	
	@Column (name = "name", length = 45, unique = true)
	private String name;
	
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity=Book.class)
	private List<Book> books;
	
	public void addBook(Book book) {
		if (!books.contains(book)) {
			books.add(book);
		}
	}
	
    public List<Book> getBooks() {
        return books;

    }

 
	public Publication() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}	
	
	
}
