package kodlamaio.hrms.entities.dtos;

public class EducationListDto {
	private int id;
	private String name;
	private String info;
	private String logo;
	private String website;
	private int educationType;
	private String educationTypeName;
	private int city;
	private String cityName;
	public EducationListDto() {
		super();
	}
	public EducationListDto(int id, String name, String info, String logo, String website, int educationType,
			String educationTypeName, int city, String cityName) {
		super();
		this.id = id;
		this.name = name;
		this.info = info;
		this.logo = logo;
		this.website = website;
		this.educationType = educationType;
		this.educationTypeName = educationTypeName;
		this.city = city;
		this.cityName = cityName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
