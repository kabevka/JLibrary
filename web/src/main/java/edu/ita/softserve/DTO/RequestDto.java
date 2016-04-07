package edu.ita.softserve.DTO;

public class RequestDto {
	
	private String name;
	private String description;
	private int amountOfPage;
	private int year;
	private String authorName;
	private String authorSurname;
	private String publicationName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getAmountOfPage() {
		return amountOfPage;
	}
	public void setAmountOfPage(int amountOfPage) {
		this.amountOfPage = amountOfPage;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getAuthorSurname() {
		return authorSurname;
	}
	public void setAuthorSurname(String authorSurname) {
		this.authorSurname = authorSurname;
	}
	public String getPublicationName() {
		return publicationName;
	}
	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	

}
