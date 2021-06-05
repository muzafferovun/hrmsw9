package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

public class PersonExperiencesGetDto {
	private int id;
	private String info;
	private LocalDate startDate;
	private LocalDate endDate;
	private boolean isWorking;
	private String otherCompany;
	private int personId;
	private String personName;
	private String personSurname;
	private int positionId;
	private String positionName;
	private String positionAvatar;
	private int positionPopularity;
	private int companyId;
	private String companyName;
	private String companyEmail;
	private String companyLogo;
	private String companyPhone;
	public PersonExperiencesGetDto() {
		super();
	}
	public PersonExperiencesGetDto(int id, String info, LocalDate startDate, LocalDate endDate, boolean isWorking,
			String otherCompany, int personId, String personName, String personSurname, int positionId,
			String positionName, String positionAvatar, int positionPopularity, int companyId, String companyName,
			String companyEmail, String companyLogo, String companyPhone) {
		super();
		this.id = id;
		this.info = info;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isWorking = isWorking;
		this.otherCompany = otherCompany;
		this.personId = personId;
		this.personName = personName;
		this.personSurname = personSurname;
		this.positionId = positionId;
		this.positionName = positionName;
		this.positionAvatar = positionAvatar;
		this.positionPopularity = positionPopularity;
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyEmail = companyEmail;
		this.companyLogo = companyLogo;
		this.companyPhone = companyPhone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public boolean isWorking() {
		return isWorking;
	}
	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}
	public String getOtherCompany() {
		return otherCompany;
	}
	public void setOtherCompany(String otherCompany) {
		this.otherCompany = otherCompany;
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
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getPositionAvatar() {
		return positionAvatar;
	}
	public void setPositionAvatar(String positionAvatar) {
		this.positionAvatar = positionAvatar;
	}
	public int getPositionPopularity() {
		return positionPopularity;
	}
	public void setPositionPopularity(int positionPopularity) {
		this.positionPopularity = positionPopularity;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getCompanyLogo() {
		return companyLogo;
	}
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

}
