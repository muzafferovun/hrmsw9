package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

public class PersonCvEducationGetDto {
	private int id;
	private int personCv;
	private String educationInfo;
	private LocalDate educationStartDate;
	private LocalDate educationEndDate;
	private boolean isGraduate;
	private int educationType;
	private String educationTypeName;
	private int institueId;
	private String institueName;
	private String institueinfo;
	private String instituelogo;
	private String instituewebsite;
	private int institueCity;
	private String institueCityName;
	public PersonCvEducationGetDto() {
		super();
	}
	public PersonCvEducationGetDto(int id, int personCv, String educationInfo, LocalDate educationStartDate,
			LocalDate educationEndDate, boolean isGraduate, int educationType, String educationTypeName, int institueId,
			String institueName, String institueinfo, String instituelogo, String instituewebsite, int institueCity,
			String institueCityName) {
		super();
		this.id = id;
		this.personCv = personCv;
		this.educationInfo = educationInfo;
		this.educationStartDate = educationStartDate;
		this.educationEndDate = educationEndDate;
		this.isGraduate = isGraduate;
		this.educationType = educationType;
		this.educationTypeName = educationTypeName;
		this.institueId = institueId;
		this.institueName = institueName;
		this.institueinfo = institueinfo;
		this.instituelogo = instituelogo;
		this.instituewebsite = instituewebsite;
		this.institueCity = institueCity;
		this.institueCityName = institueCityName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPersonCv() {
		return personCv;
	}
	public void setPersonCv(int personCv) {
		this.personCv = personCv;
	}
	public String getEducationInfo() {
		return educationInfo;
	}
	public void setEducationInfo(String educationInfo) {
		this.educationInfo = educationInfo;
	}
	public LocalDate getEducationStartDate() {
		return educationStartDate;
	}
	public void setEducationStartDate(LocalDate educationStartDate) {
		this.educationStartDate = educationStartDate;
	}
	public LocalDate getEducationEndDate() {
		return educationEndDate;
	}
	public void setEducationEndDate(LocalDate educationEndDate) {
		this.educationEndDate = educationEndDate;
	}
	public boolean isGraduate() {
		return isGraduate;
	}
	public void setGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}
	public int getEducationType() {
		return educationType;
	}
	public void setEducationType(int educationType) {
		this.educationType = educationType;
	}
	public String getEducationTypeName() {
		return educationTypeName;
	}
	public void setEducationTypeName(String educationTypeName) {
		this.educationTypeName = educationTypeName;
	}
	public int getInstitueId() {
		return institueId;
	}
	public void setInstitueId(int institueId) {
		this.institueId = institueId;
	}
	public String getInstitueName() {
		return institueName;
	}
	public void setInstitueName(String institueName) {
		this.institueName = institueName;
	}
	public String getInstitueinfo() {
		return institueinfo;
	}
	public void setInstitueinfo(String institueinfo) {
		this.institueinfo = institueinfo;
	}
	public String getInstituelogo() {
		return instituelogo;
	}
	public void setInstituelogo(String instituelogo) {
		this.instituelogo = instituelogo;
	}
	public String getInstituewebsite() {
		return instituewebsite;
	}
	public void setInstituewebsite(String instituewebsite) {
		this.instituewebsite = instituewebsite;
	}
	public int getInstitueCity() {
		return institueCity;
	}
	public void setInstitueCity(int institueCity) {
		this.institueCity = institueCity;
	}
	public String getInstitueCityName() {
		return institueCityName;
	}
	public void setInstitueCityName(String institueCityName) {
		this.institueCityName = institueCityName;
	}

	
}
