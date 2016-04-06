package edu.ita.softserve.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="instances_of_book")
public class Instance implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7278372994898302015L;

	public Instance() {
	isAvailable = true;
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="is_available", nullable=false)
    private boolean isAvailable;
    
    @ManyToOne(cascade = CascadeType.ALL, targetEntity=Book.class, fetch=FetchType.LAZY)
    private Book book;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    } 

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
	return "Instance [id=" + id + ", book=" + book + "]";	
    }  
}
