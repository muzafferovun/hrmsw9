package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="person_educations")
public class PersonEducation {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
    @ManyToOne()
    @JoinColumn(name="person_id")
	private Person person;
    @ManyToOne()
    @JoinColumn(name="education_institues_id")
	private Education education;
	@Column(name="education_info")
	private String educationInfo;
	@Column(name="education_start_date")
	private LocalDate educationStartDate;
	@Column(name="education_end_date")
	private LocalDate educationEndDate;
	@Column(name="is_graduate")
	private boolean isGraduate;
	public PersonEducation() {
		super();
	}
	public PersonEducation(int id, Person person, Education education, String educationInfo,
			LocalDate educationStartDate, LocalDate educationEndDate, boolean isGraduate) {
		super();
		this.id = id;
		this.person = person;
		this.education = education;
		this.educationInfo = educationInfo;
		this.educationStartDate = educationStartDate;
		this.educationEndDate = educationEndDate;
		this.isGraduate = isGraduate;
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
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
	public String getEducationInfo() {
		return educationInfo;
	}
	public void setEducationInfo(String educationInfo) {
		this.educationInfo = educationInfo;
	}
	public LocalDate getEducationStartDate() {
		return educationStartDate;
	}
	public void setEducationStartDate(LocalDate educationStartDate) {
		this.educationStartDate = educationStartDate;
	}
	public LocalDate getEducationEndDate() {
		return educationEndDate;
	}
	public void setEducationEndDate(LocalDate educationEndDate) {
		this.educationEndDate = educationEndDate;
	}
	public boolean isGraduate() {
		return isGraduate;
	}
	public void setGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}
	
}
