package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import kodlamaio.hrms.entities.concretes.PersonExperiences;

import kodlamaio.hrms.entities.dtos.PersonExperiencesGetDto;


public interface PersonExperiencesDao extends JpaRepository<PersonExperiences, Integer> {
 	
	  @Query("SELECT new kodlamaio.hrms.entities.dtos.PersonExperiencesGetDto"
	  		+ "("
	  		+ "pp.id,pp.info,pp.startDate,pp.endDate,pp.isWorking,pp.otherCompany"
	  		+ ",p.id,p.name,p.surname"
	  		+ ",sp.id,sp.positionName,sp.positionAvatar,sp.positionPopularity"
	  		+ ",c.id,c.company_name,c.company_email,c.company_logo,c.phone"
	  		+ ") "
		  		+ "from PersonExperiences pp"
		  		+ " Inner join pp.person p"
		  		+ " Inner Join pp.sectorPosition sp"
		  		+ " Inner Join pp.company c"
		  		+ " ")
		  List<PersonExperiencesGetDto> getPersonExperiences();
	 /* 
	//int id, String info, LocalDate startDate, LocalDate endDate, boolean isWorking,
			String otherCompany, int personId, String personName, String personSurname, int positionId,
			String positionName, String positionAvatar, int positionPopularity, int companyId, String companyName,
			String companyEmail, String companyLogo, String companyPhone
		
	  SELECT * from person_sector_professions psp
		Inner join person on psp.person_id=person.id
		Inner Join sector_professions on psp.sector_profession_id=sector_professions.id
		inner join company on psp.company_id=company.id
		inner join countrie_citys on company.company_city=countrie_citys.id
	*/

}
