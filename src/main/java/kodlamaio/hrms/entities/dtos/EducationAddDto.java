package kodlamaio.hrms.entities.dtos;
public class EducationAddDto {
	private int educationType;
	private String name;
	private String info;
	private String logo;
	private String website;
	private int city;
	public EducationAddDto() {
		super();
	}
	public EducationAddDto(int educationType, String name, String info, String logo, String website, int city) {
		super();
		this.educationType = educationType;
		this.name = name;
		this.info = info;
		this.logo = logo;
		this.website = website;
		this.city = city;
	}
	public int getEducationType() {
		return educationType;
	}
	public void setEducationType(int educationType) {
		this.educationType = educationType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
}
