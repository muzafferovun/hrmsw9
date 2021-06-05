package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.PersonCv;
import kodlamaio.hrms.entities.dtos.PersonCvGetDto;




public interface PersonCvDao extends JpaRepository<PersonCv, Integer> {
	@Query("SELECT new kodlamaio.hrms.entities.dtos.PersonCvGetDto"
			+ "(pcv.id,p.id,p.name,p.surname,p.photo,pcv.cvCaption,pcv.cvContent)"
			+ " from PersonCv pcv Inner join pcv.person p ")
	List<PersonCvGetDto> getAllCv();
	
	List<PersonCv> findByCvCaption(String caption);
	  
}
