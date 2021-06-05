package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="person_work_experiences")
public class PersonExperiences {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
    @ManyToOne()
    @JoinColumn(name="person_id")
	private Person person;
    @ManyToOne()
    @JoinColumn(name="sector_position_id")
	private SectorPosition sectorPosition;
	@Column(name="info")
	private String info;
	@Column(name="start_date")
	private LocalDate startDate;
	@Column(name="end_date")
	private LocalDate endDate;
	@Column(name="is_working")
	private boolean isWorking;
    @ManyToOne()
    @JoinColumn(name="company_id")
	private Company company;
	@Column(name="other_company")
	private String otherCompany;
	public PersonExperiences() {
		super();
	}
	public PersonExperiences(int id, Person person, SectorPosition sectorPosition, String info, LocalDate startDate,
			LocalDate endDate, boolean isWorking, Company company, String otherCompany) {
		super();
		this.id = id;
		this.person = person;
		this.sectorPosition = sectorPosition;
		this.info = info;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isWorking = isWorking;
		this.company = company;
		this.otherCompany = otherCompany;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public SectorPosition getSectorPosition() {
		return sectorPosition;
	}
	public void setSectorPosition(SectorPosition sectorPosition) {
		this.sectorPosition = sectorPosition;
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
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getOtherCompany() {
		return otherCompany;
	}
	public void setOtherCompany(String otherCompany) {
		this.otherCompany = otherCompany;
	}


}
