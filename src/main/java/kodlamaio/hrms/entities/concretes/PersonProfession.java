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
@Table(name="person_sector_professions")
public class PersonProfession {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
    @ManyToOne()
    @JoinColumn(name="person_id")
	private Person person;
    @ManyToOne()
    @JoinColumn(name="sector_profession_id")
	private SectorProfession sectorProfession;
	@Column(name="content")
	private String content;
	public PersonProfession() {
		super();
	}
	public PersonProfession(int id, Person person, SectorProfession sectorProfession, String content) {
		super();
		this.id = id;
		this.person = person;
		this.sectorProfession = sectorProfession;
		this.content = content;
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
	public SectorProfession getSectorProfession() {
		return sectorProfession;
	}
	public void setSectorProfession(SectorProfession sectorProfession) {
		this.sectorProfession = sectorProfession;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


}
