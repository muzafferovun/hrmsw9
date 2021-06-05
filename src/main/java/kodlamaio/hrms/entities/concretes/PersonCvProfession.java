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
@Table(name="person_cv_professions")
public class PersonCvProfession {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
    @ManyToOne()
    @JoinColumn(name="person_cv_id")
	private PersonCv personCv;	
    @ManyToOne()
    @JoinColumn(name="profession_id")
	private PersonProfession personProfession;
	public PersonCvProfession() {
		super();
	}
	public PersonCvProfession(int id, PersonCv personCv, PersonProfession personProfession) {
		super();
		this.id = id;
		this.personCv = personCv;
		this.personProfession = personProfession;
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
	public PersonProfession getPersonProfession() {
		return personProfession;
	}
	public void setPersonProfession(PersonProfession personProfession) {
		this.personProfession = personProfession;
	}	

}
