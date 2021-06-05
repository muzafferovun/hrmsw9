package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Sector;

public interface SectorDao extends JpaRepository<Sector, Integer> {

}
