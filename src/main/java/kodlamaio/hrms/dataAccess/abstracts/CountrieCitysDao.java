package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CountrieCitys;

public interface CountrieCitysDao extends JpaRepository<CountrieCitys, Integer> {

}
