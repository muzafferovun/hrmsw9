package kodlamaio.hrms.entities.dtos;



public class PersonCvProfessionGetDto {
	private int id;

	private int personId;
	private String personName;
	private String personSurname;

	private int cvId;
	private String cvCaption;

	private int professionId;
	private String professionName;
	private String professionDescription;
	private String professionAvatar;
	public PersonCvProfessionGetDto() {
		super();
	}
	public PersonCvProfessionGetDto(int id, int personId, String personName, String personSurname, int cvId,
			String cvCaption, int professionId, String professionName, String professionDescription,
			String professionAvatar) {
		super();
		this.id = id;
		this.personId = personId;
		this.personName = personName;
		this.personSurname = personSurname;
		this.cvId = cvId;
		this.cvCaption = cvCaption;
		this.professionId = professionId;
		this.professionName = professionName;
		this.professionDescription = professionDescription;
		this.professionAvatar = professionAvatar;
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
	public int getCvId() {
		return cvId;
	}
	public void setCvId(int cvId) {
		this.cvId = cvId;
	}
	public String getCvCaption() {
		return cvCaption;
	}
	public void setCvCaption(String cvCaption) {
		this.cvCaption = cvCaption;
	}
	public int getProfessionId() {
		return professionId;
	}
	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	public String getProfessionDescription() {
		return professionDescription;
	}
	public void setProfessionDescription(String professionDescription) {
		this.professionDescription = professionDescription;
	}
	public String getProfessionAvatar() {
		return professionAvatar;
	}
	public void setProfessionAvatar(String professionAvatar) {
		this.professionAvatar = professionAvatar;
	}
}
