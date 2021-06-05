package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="sector_positions")
public class SectorPosition {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="sector_id")
	private int sectorId;
	@Column(name="position_name")
	private String positionName;
	@Column(name="position_avatar")
	private String positionAvatar;
	@Column(name="position_popularity")
	private int positionPopularity;
	public SectorPosition() {
		super();
	}
	public SectorPosition(int id, int sectorId, String positionName, String positionAvatar, int positionPopularity) {
		super();
		this.id = id;
		this.sectorId = sectorId;
		this.positionName = positionName;
		this.positionAvatar = positionAvatar;
		this.positionPopularity = positionPopularity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSectorId() {
		return sectorId;
	}
	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getPositionAvatar() {
		return positionAvatar;
	}
	public void setPositionAvatar(String positionAvatar) {
		this.positionAvatar = positionAvatar;
	}
	public int getPositionPopularity() {
		return positionPopularity;
	}
	public void setPositionPopularity(int positionPopularity) {
		this.positionPopularity = positionPopularity;
	}

}
