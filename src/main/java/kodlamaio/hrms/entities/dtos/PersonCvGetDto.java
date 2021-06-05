package kodlamaio.hrms.entities.dtos;

public class PersonCvGetDto {
	private int id;
	private int personId;
	private String personName;
	private String personSurname;
	private String photo;
	private String cvCaption;
	private String cvContent;
	public PersonCvGetDto() {
		super();
	}
	public PersonCvGetDto(int id, int personId, String personName, String personSurname, String photo, String cvCaption,
			String cvContent) {
		super();
		this.id = id;
		this.personId = personId;
		this.personName = personName;
		this.personSurname = personSurname;
		this.photo = photo;
		this.cvCaption = cvCaption;
		this.cvContent = cvContent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonSurname() {
		return personSurname;
	}
	public void setPersonSurname(String personSurname) {
		this.personSurname = personSurname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
