package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationListDto;



public interface EducationDao extends JpaRepository<Education, Integer> {
	  List<Education> findByName(String educationName);
	  
	
	  @Query("SELECT new kodlamaio.hrms.entities.dtos.EducationListDto"
	  		+ "(e.id,e.name,e.info,e.logo,e.website,et.id,et.educationTypeName,c.id,c.city_name) "
		  		+ "from Education e Inner join e.educationType et Inner Join e.city c")
		  List<EducationListDto> getAllEducationListDto();
}
