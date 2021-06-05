package kodlamaio.hrms.entities.dtos;

public class PersonProfessionAddDto {
	private int personId;
	private int professionId;
	private String content;
	public PersonProfessionAddDto() {
		super();
	}
	public PersonProfessionAddDto(int personId, int professionId, String content) {
		super();
		this.personId = personId;
		this.professionId = professionId;
		this.content = content;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getProfessionId() {
		return professionId;
	}
	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
