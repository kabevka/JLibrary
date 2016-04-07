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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -458793870572406618L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="name", nullable=true)
    private String name;
    
    @Column(name="description", nullable=true)
    private String description;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", nullable = true)
    private Author author;
    
    
    
    @Column(name="amount_of_page", nullable=true)

    private Integer amountOfPage;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "publication_id", nullable = true)
    private Publication publication;
    
      
    @Column(name="year", nullable=true)
    private Integer year;
    
    public Long getId() {
        return id;
    }
    
    public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
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

    
    
    public Integer getAmountOfPage() {
		return amountOfPage;
	}

	public void setAmountOfPage(Integer amountOfPage) {
		this.amountOfPage = amountOfPage;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
    
   	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description=" + description + ", amountOfPage=" + amountOfPage
				+ ", year=" + year + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amountOfPage;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((publication == null) ? 0 : publication.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return name.equals(other.getName()) && description.equals(other.getDescription()) &&
			amountOfPage.equals(other.getAmountOfPage()) && year.equals(other.getYear());
	}
}