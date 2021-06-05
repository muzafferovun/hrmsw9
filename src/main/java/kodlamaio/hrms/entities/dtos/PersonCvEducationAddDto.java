package kodlamaio.hrms.entities.dtos;

public class PersonCvEducationAddDto {
	private int personCv;
	private int personEducation;
	public PersonCvEducationAddDto() {
		super();
	}
	public PersonCvEducationAddDto(int personCv, int personEducation) {
		super();
		this.personCv = personCv;
		this.personEducation = personEducation;
	}
	public int getPersonCv() {
		return personCv;
	}
	public void setPersonCv(int personCv) {
		this.personCv = personCv;
	}
	public int getPersonEducation() {
		return personEducation;
	}
	public void setPersonEducation(int personEducation) {
		this.personEducation = personEducation;
	}
	
}
