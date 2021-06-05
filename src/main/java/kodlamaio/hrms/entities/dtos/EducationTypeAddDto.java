package kodlamaio.hrms.entities.dtos;

public class EducationTypeAddDto {
	private String educationTypeName;

	public EducationTypeAddDto(String educationTypeName) {
		super();
		this.educationTypeName = educationTypeName;
	}

	public EducationTypeAddDto() {
		super();
	}

	public String getEducationTypeName() {
		return educationTypeName;
	}

	public void setEducationTypeName(String educationTypeName) {
		this.educationTypeName = educationTypeName;
	}

}
