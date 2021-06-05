package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.PersonProfession;
import kodlamaio.hrms.entities.dtos.PersonExperiencesGetDto;
import kodlamaio.hrms.entities.dtos.PersonProfessionGetDto;


public interface PersonProfessionDao extends JpaRepository<PersonProfession, Integer> {
	  @Query("SELECT new kodlamaio.hrms.entities.dtos.PersonProfessionGetDto"
		  		+ "("
		  		+ "pp.id,p.id,p.name,p.surname"
		  		+ ",sp.id,sp.profession_name,spos.id,spos.sector_name"
		  		+ ",sp.profession_description,sp.profession_avatar,pp.content) "
			  		+ "from PersonProfession pp"
			  		+ " Inner join pp.person p"
			  		+ " Inner Join pp.sectorProfession sp"
			  		+ " Inner Join sp.sector spos")
			  List<PersonProfessionGetDto> getPersonProfession();
/*
 * int id, int personId, String personName, String personSurname, int professionId,
			String professionName, int sectorId, String sectorName, String professionDescription,
			String professionAvatar, String content*/
}
