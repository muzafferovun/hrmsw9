package kodlamaio.hrms.entities.dtos;

public class PersonProfessionGetDto {
	private int id;
	private int personId;
	private String personName;
	private String personSurname;
	private int professionId;
	private String professionName;
	private int sectorId;
	private String sectorName;
	private String professionDescription;
	private String professionAvatar;
	private String content;
	public PersonProfessionGetDto() {
		super();
	}
	public PersonProfessionGetDto(int id, int personId, String personName, String personSurname, int professionId,
			String professionName, int sectorId, String sectorName, String professionDescription,
			String professionAvatar, String content) {
		super();
		this.id = id;
		this.personId = personId;
		this.personName = personName;
		this.personSurname = personSurname;
		this.professionId = professionId;
		this.professionName = professionName;
		this.sectorId = sectorId;
		this.sectorName = sectorName;
		this.professionDescription = professionDescription;
		this.professionAvatar = professionAvatar;
		this.content = content;
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
	public int getSectorId() {
		return sectorId;
	}
	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	} 
}
