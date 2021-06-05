package kodlamaio.hrms.entities.dtos;


public class PersonCvAddDto {
	private int person;	
	private String cvCaption;
	private String cvContent;
	public PersonCvAddDto() {
		super();
	}
	public PersonCvAddDto(int person, String cvCaption, String cvContent) {
		super();
		this.person = person;
		this.cvCaption = cvCaption;
		this.cvContent = cvContent;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
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
