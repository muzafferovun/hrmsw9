package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.PersonEducation;

public interface PersonEducationDao extends JpaRepository<PersonEducation, Integer> {

}
