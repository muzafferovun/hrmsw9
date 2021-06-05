package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="education_institues")
public class Education {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
    @ManyToOne()
    @JoinColumn(name="education_type_id")
	private EducationType educationType;

    @Column(name="name")
	private String name;
	@Column(name="info")
	private String info;
	@Column(name="logo")
	private String logo;
	@Column(name="website")
	private String website;
    @ManyToOne()
    @JoinColumn(name="city_id")
	private CountrieCitys city;
	public Education() {
		super();
	}
	public Education(int id, EducationType educationType, String name, String info, String logo, String website,
			CountrieCitys city) {
		super();
		this.id = id;
		this.educationType = educationType;
		this.name = name;
		this.info = info;
		this.logo = logo;
		this.website = website;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public EducationType getEducationType() {
		return educationType;
	}
	public void setEducationType(EducationType educationType) {
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
	public CountrieCitys getCity() {
		return city;
	}
	public void setCity(CountrieCitys city) {
		this.city = city;
	}
}
