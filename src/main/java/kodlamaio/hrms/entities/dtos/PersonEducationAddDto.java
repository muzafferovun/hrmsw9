package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;


public class PersonEducationAddDto {
	int personId;
	int educationId;
	private String educationInfo;
	private String educationStartDate;
	private String educationEndDate;
	private boolean isGraduate;
	public PersonEducationAddDto() {
		super();
	}
	public PersonEducationAddDto(int personId, int educationId, String educationInfo, String educationStartDate,
			String educationEndDate, boolean isGraduate) {
		super();
		this.personId = personId;
		this.educationId = educationId;
		this.educationInfo = educationInfo;
		this.educationStartDate = educationStartDate;
		this.educationEndDate = educationEndDate;
		this.isGraduate = isGraduate;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getEducationId() {
		return educationId;
	}
	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}
	public String getEducationInfo() {
		return educationInfo;
	}
	public void setEducationInfo(String educationInfo) {
		this.educationInfo = educationInfo;
	}
	public String getEducationStartDate() {
		return educationStartDate;
	}
	public void setEducationStartDate(String educationStartDate) {
		this.educationStartDate = educationStartDate;
	}
	public String getEducationEndDate() {
		return educationEndDate;
	}
	public void setEducationEndDate(String educationEndDate) {
		this.educationEndDate = educationEndDate;
	}
	public boolean isGraduate() {
		return isGraduate;
	}
	public void setGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}
	
}
