package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="job_positions")
public class JobPosition {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
    @ManyToOne()
    @JoinColumn(name="company")
	private Company company;	
    @ManyToOne()
    @JoinColumn(name="sector_position")
	private SectorPosition sectorPosition;	
	@Column(name="job_position_status")
	private boolean jobPositionStatus;	
	@Column(name="job_application_end_time")
	private LocalDate jobApplicationEndTime;
	@Column(name="job_application_start_time")
	private LocalDate jobApplicationStartTime;
	@Column(name="referance_title")
	private String referanceTitle;	
	@Column(name="referance_content")
	private String referanceContent;	
	@Column(name="person_count")
	private int personCount;	
	@Column(name="city")
	private int city;	
	@Column(name="salary_min")
	private double salaryMin;	
	@Column(name="salary_max")
	private double salaryMax;
	public JobPosition() {
		super();
	}
	public JobPosition(int id, Company company, SectorPosition sectorPosition, boolean jobPositionStatus,
			LocalDate jobApplicationEndTime, LocalDate jobApplicationStartTime, String referanceTitle,
			String referanceContent, int personCount, int city, double salaryMin, double salaryMax) {
		super();
		this.id = id;
		this.company = company;
		this.sectorPosition = sectorPosition;
		this.jobPositionStatus = jobPositionStatus;
		this.jobApplicationEndTime = jobApplicationEndTime;
		this.jobApplicationStartTime = jobApplicationStartTime;
		this.referanceTitle = referanceTitle;
		this.referanceContent = referanceContent;
		this.personCount = personCount;
		this.city = city;
		this.salaryMin = salaryMin;
		this.salaryMax = salaryMax;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public SectorPosition getSectorPosition() {
		return sectorPosition;
	}
	public void setSectorPosition(SectorPosition sectorPosition) {
		this.sectorPosition = sectorPosition;
	}
	public boolean isJobPositionStatus() {
		return jobPositionStatus;
	}
	public void setJobPositionStatus(boolean jobPositionStatus) {
		this.jobPositionStatus = jobPositionStatus;
	}
	public LocalDate getJobApplicationEndTime() {
		return jobApplicationEndTime;
	}
	public void setJobApplicationEndTime(LocalDate jobApplicationEndTime) {
		this.jobApplicationEndTime = jobApplicationEndTime;
	}
	public LocalDate getJobApplicationStartTime() {
		return jobApplicationStartTime;
	}
	public void setJobApplicationStartTime(LocalDate jobApplicationStartTime) {
		this.jobApplicationStartTime = jobApplicationStartTime;
	}
	public String getReferanceTitle() {
		return referanceTitle;
	}
	public void setReferanceTitle(String referanceTitle) {
		this.referanceTitle = referanceTitle;
	}
	public String getReferanceContent() {
		return referanceContent;
	}
	public void setReferanceContent(String referanceContent) {
		this.referanceContent = referanceContent;
	}
	public int getPersonCount() {
		return personCount;
	}
	public void setPersonCount(int personCount) {
		this.personCount = personCount;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public double getSalaryMin() {
		return salaryMin;
	}
	public void setSalaryMin(double salaryMin) {
		this.salaryMin = salaryMin;
	}
	public double getSalaryMax() {
		return salaryMax;
	}
	public void setSalaryMax(double salaryMax) {
		this.salaryMax = salaryMax;
	}
	
}
