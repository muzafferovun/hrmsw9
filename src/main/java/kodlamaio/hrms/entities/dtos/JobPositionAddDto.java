package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.util.Date;

public class JobPositionAddDto {
	private int jobPositionId;
	private int companyId;
	private int city;
	private String positionName;
	private int personCount;
	private LocalDate jobApplicationEndTime;
	private LocalDate jobApplicationStartTime;
	private String referanceTitle;
	private String referanceContent;
	private boolean status;
	private double saleryMax;
	private double saleryMin;
	public JobPositionAddDto() {
		super();
	}
	public JobPositionAddDto(int jobPositionId, int companyId, int city, String positionName, int personCount,
			LocalDate jobApplicationEndTime, LocalDate jobApplicationStartTime, String referanceTitle,
			String referanceContent, boolean status, double saleryMax, double saleryMin) {
		super();
		this.jobPositionId = jobPositionId;
		this.companyId = companyId;
		this.city = city;
		this.positionName = positionName;
		this.personCount = personCount;
		this.jobApplicationEndTime = jobApplicationEndTime;
		this.jobApplicationStartTime = jobApplicationStartTime;
		this.referanceTitle = referanceTitle;
		this.referanceContent = referanceContent;
		this.status = status;
		this.saleryMax = saleryMax;
		this.saleryMin = saleryMin;
	}
	public int getJobPositionId() {
		return jobPositionId;
	}
	public void setJobPositionId(int jobPositionId) {
		this.jobPositionId = jobPositionId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public int getPersonCount() {
		return personCount;
	}
	public void setPersonCount(int personCount) {
		this.personCount = personCount;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getSaleryMax() {
		return saleryMax;
	}
	public void setSaleryMax(double saleryMax) {
		this.saleryMax = saleryMax;
	}
	public double getSaleryMin() {
		return saleryMin;
	}
	public void setSaleryMin(double saleryMin) {
		this.saleryMin = saleryMin;
	}


}
