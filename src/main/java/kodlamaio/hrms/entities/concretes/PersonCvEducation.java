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
@Table(name="person_cv_educations")
public class PersonCvEducation {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
    @ManyToOne()
    @JoinColumn(name="person_cv_id")
	private PersonCv personCv;	
    @ManyToOne()
    @JoinColumn(name="person_educations_id")
	private PersonEducation personEducation;
	public PersonCvEducation() {
		super();
	}
	public PersonCvEducation(int id, PersonCv personCv, PersonEducation personEducation) {
		super();
		this.id = id;
		this.personCv = personCv;
		this.personEducation = personEducation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PersonCv getPersonCv() {
		return personCv;
	}
	public void setPersonCv(PersonCv personCv) {
		this.personCv = personCv;
	}
	public PersonEducation getPersonEducation() {
		return personEducation;
	}
	public void setPersonEducation(PersonEducation personEducation) {
		this.personEducation = personEducation;
	}	

}
