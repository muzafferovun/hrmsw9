package kodlamaio.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.PersonCvProfession;
import kodlamaio.hrms.entities.dtos.PersonCvProfessionGetDto;


public interface PersonCvProfessionDao extends JpaRepository<PersonCvProfession, Integer> {
/*
	@Query("SELECT new kodlamaio.hrms.entities.dtos.PersonCvProfessionGetDto"
		  		+ "(pcp.id,pc.id,pc.cvCaption,pc.pp.id,) "
			  		+ "from PersonCvProfession pcp"
			  		+ " Inner join pcp.personCv pc"
			  		+ " Inner Join pcp.personProfession pp"
			  		+ " Inner Join pc.person p"
			  		+ " Inner Join pp.sectorProfession sp"
			  		+ " Inner Join sp.company c"
			  		+ " where pcp.id:personCvId")
	  List<PersonCvProfessionGetDto> getAllPersonCvProfessionGetDto(int personCvId);
	*/   
		  
}
