package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.PersonCvEducation;

public interface PersonCvEducationDao extends JpaRepository<PersonCvEducation, Integer> {

}
