package kodlamaio.hrms.entities.dtos;

public class PersonCvProfessionAddDto {
	private int personCv;
	private int personProfession;
	public PersonCvProfessionAddDto() {
		super();
	}
	public PersonCvProfessionAddDto(int personCv, int personProfession) {
		super();
		this.personCv = personCv;
		this.personProfession = personProfession;
	}
	public int getPersonCv() {
		return personCv;
	}
	public void setPersonCv(int personCv) {
		this.personCv = personCv;
	}
	public int getPersonProfession() {
		return personProfession;
	}
	public void setPersonProfession(int personProfession) {
		this.personProfession = personProfession;
	}
}
