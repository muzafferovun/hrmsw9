package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EducationType;


public interface EducationTypeDao extends JpaRepository<EducationType, Integer> {
	  List<EducationType> findByEducationTypeName(String educationTypeName);

}
