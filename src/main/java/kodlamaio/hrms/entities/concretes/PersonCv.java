package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="person_cv")
public class PersonCv {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
    @ManyToOne()
    @JoinColumn(name="person_id")
	private Person person;	
	@Column(name="cv_caption")
	private String cvCaption;
	@Column(name="cv_content")
	private String cvContent;
	
	public PersonCv() {
		super();
	}

	public PersonCv(int id, Person person, String cvCaption, String cvContent) {
		super();
		this.id = id;
		this.person = person;
		this.cvCaption = cvCaption;
		this.cvContent = cvContent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getCvCaption() {
		return cvCaption;
	}

	public void setCvCaption(String cvCaption) {
		this.cvCaption = cvCaption;
	}

	public String getCvContent() {
		return cvContent;
	}

	public void setCvContent(String cvContent) {
		this.cvContent = cvContent;
	}

}
