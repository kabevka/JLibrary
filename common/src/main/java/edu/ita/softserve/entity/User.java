package edu.ita.softserve.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@NamedQueries ({
	@NamedQuery(name = "getAvarageAgeByBookName",
			query = "select avg(u.age) from User u inner join u.instance.book as b  where u.instance.id = "
					+ "b.id and  b.name = :bookName"),					 
	@NamedQuery(name = "showAllDeptors",
			query = "select u from User u where u.dateOfGivenBack > current_date"),
	@NamedQuery(name = "showRegistrationTime",
			query = "select u.dateOfRegistration from User u where u.id = :uId"),
	@NamedQuery(name = "showUseravarageAge",
			query = "select avg(u.age) from User u"),
	@NamedQuery(name = "showCountOfApplicatioByTime",
			query = "select count(u.instance) from User u where u.dateOfGiven >= :start and"
					+ " u.dateOfGiven <= :end and u.id = :id "),
	@NamedQuery(name = "showUserByAllName",
			query = "Select u from User u where u.firstName = :fName and u.secondName = :sName"),
		
})
@Table(name = "user")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6671319195214019822L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "second_name")
	private String secondName;
	
	@Column(name = "age")
	private int age;

	@Column(name = "telephone_number")
	private long telephoneNumber;
	
	@Column(name = "date_of_registration")
	private Date dateOfRegistration;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instance_id")
	private Instance instance;
	
	@Column(name = "date_of_given")
	private Date dateOfGiven;
	
	@Column(name = "date_of_given_back")
	private Date dateOfGivenBack;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adress_id")
	private Adress adress;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String firstName, String secondName){
		this.firstName = firstName;
		this.secondName = secondName;
	}
	
	public User(String firstName, String secondName, int age, int telephoneNumber, Date dateOfRegistration,
			Adress adress) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.age = age;
		this.telephoneNumber = telephoneNumber;
		this.dateOfRegistration = dateOfRegistration;
		this.adress = adress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(long telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public Instance getInstance() {
		return instance;
	}

	public void setInstance(Instance instance) {
		this.instance = instance;
	}

	public Date getDateOfGiven() {
		return dateOfGiven;
	}

	public void setDateOfGiven(Date dateOfGiven) {
		this.dateOfGiven = dateOfGiven;
	}

	public Date getDateOfGivenBack() {
		return dateOfGivenBack;
	}

	public void setDateOfGivenBack(Date dateOfGivenBack) {
		this.dateOfGivenBack = dateOfGivenBack;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", age=" + age
				+ ", telephoneNumber=" + telephoneNumber + ", dateOfRegistration=" + dateOfRegistration + ", instance="
				+ instance + ", dateOfGiven=" + dateOfGiven + ", dateOfGivenBack=" + dateOfGivenBack + ", adress="
				+ adress + "]";
	}		
}
