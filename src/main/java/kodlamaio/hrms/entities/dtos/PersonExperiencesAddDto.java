package kodlamaio.hrms.entities.dtos;



public class PersonExperiencesAddDto {
	private int personId;
	private int positionId;
	private String info;
	private String startDate;
	private String endDate;
	private boolean isWorking;
	private int companyId;
	private String otherCompany;
	public PersonExperiencesAddDto() {
		super();
	}
	public PersonExperiencesAddDto(int personId, int positionId, String info, String startDate, String endDate,
			boolean isWorking, int companyId, String otherCompany) {
		super();
		this.personId = personId;
		this.positionId = positionId;
		this.info = info;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isWorking = isWorking;
		this.companyId = companyId;
		this.otherCompany = otherCompany;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int professionId) {
		this.positionId = professionId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public boolean getIsWorking() {
		return isWorking;
	}
	public void setIsWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getOtherCompany() {
		return otherCompany;
	}
	public void setOtherCompany(String otherCompany) {
		this.otherCompany = otherCompany;
	}
	
}
