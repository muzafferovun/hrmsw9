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

@Table(name="sector_professions")
public class SectorProfession {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
   @ManyToOne()
   	@JoinColumn(name="sector_id")
	private Sector sector;
	@Column(name="profession_name")
	private String profession_name;
	@Column(name="profession_description")
	private String profession_description;
	@Column(name="profession_avatar")
	private String profession_avatar;
	public SectorProfession() {
		super();
	}
	public SectorProfession(int id, Sector sector, String profession_name, String profession_description,
			String profession_avatar) {
		super();
		this.id = id;
		this.sector = sector;
		this.profession_name = profession_name;
		this.profession_description = profession_description;
		this.profession_avatar = profession_avatar;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	public String getProfession_name() {
		return profession_name;
	}
	public void setProfession_name(String profession_name) {
		this.profession_name = profession_name;
	}
	public String getProfession_description() {
		return profession_description;
	}
	public void setProfession_description(String profession_description) {
		this.profession_description = profession_description;
	}
	public String getProfession_avatar() {
		return profession_avatar;
	}
	public void setProfession_avatar(String profession_avatar) {
		this.profession_avatar = profession_avatar;
	}
}
