package kodlamaio.hrms.entities.dataTransferObjects;

import java.util.Date;

import javax.persistence.Column;

public class JobPositionList {
	private int jobPositionId;
	private String companyName;
	private String positionName;
	private int personCount;
	private Date jobApplicationEndTime;
	private Date jobApplicationStartTime;
	public JobPositionList() {
		super();
	}
	public JobPositionList(int jobPositionId, String companyName, String positionName, int personCount,
			Date jobApplicationEndTime, Date jobApplicationStartTime) {
		super();
		this.jobPositionId = jobPositionId;
		this.companyName = companyName;
		this.positionName = positionName;
		this.personCount = personCount;
		this.jobApplicationEndTime = jobApplicationEndTime;
		this.jobApplicationStartTime = jobApplicationStartTime;
	}
	public int getJobPositionId() {
		return jobPositionId;
	}
	public void setJobPositionId(int jobPositionId) {
		this.jobPositionId = jobPositionId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	public Date getJobApplicationEndTime() {
		return jobApplicationEndTime;
	}
	public void setJobApplicationEndTime(Date jobApplicationEndTime) {
		this.jobApplicationEndTime = jobApplicationEndTime;
	}
	public Date getJobApplicationStartTime() {
		return jobApplicationStartTime;
	}
	public void setJobApplicationStartTime(Date jobApplicationStartTime) {
		this.jobApplicationStartTime = jobApplicationStartTime;
	}
	
}
