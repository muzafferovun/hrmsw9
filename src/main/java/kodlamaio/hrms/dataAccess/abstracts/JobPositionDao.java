package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobPosition;

import kodlamaio.hrms.entities.dataTransferObjects.JobPositionList;


public interface JobPositionDao<T>  extends JpaRepository<JobPosition, Integer> {
	   @Query(value ="SELECT company.company_name"
	   		+ ",job_positions.job_application_end_time"
	   		+ ",job_positions.job_application_start_time"
	   		+ ",job_positions.id"
	   		+ ",job_positions.person_count"
	   		+ ",sector_positions.position_name"
	   		+ " FROM job_positions,sector_positions,company WHERE job_positions.sector_position_id=sector_positions.id and job_positions.company_id=company.id group by job_positions.id,company.company_name,job_positions.person_count,job_positions.job_application_end_time,job_positions.job_application_start_time,sector_positions.position_name ", nativeQuery = true)
	    public List<T> findAplicationsList();

	   
	   @Query(value ="SELECT new kodlamaio.hrms.entities.dataTransferObjects.JobPositionList("
		   		+ "j.id"
	   			+ ",c.company_name"
		   		+ ",s.position_name"
		   		+ ",j.person_count"
		   		+ ",j.job_application_end_time"
		   		+ ",j.job_application_start_time"
		   		+ ")"
		   		+ " FROM JobPosition j,SectorPosition s,Company c"
		   		+ " WHERE j.sectorPositionId=s.id"
		   		+ " and j.companyId=c.id"
		   		+ " and c.id=:companyId"
		   		+ "   ", nativeQuery = true)
		    public List<T> findCompanyAplicationsList(@Param("companyId") int companyId);
	   
	   
	   @Modifying
	    @Transactional
	    @Query(value = "update job_positions set job_position_status = false where id = (:id)", nativeQuery = true)
	   public void unActivateJobPosition(@Param("id") int id);
	   @Modifying
	    @Transactional
	    @Query(value = "update job_positions set job_position_status = true where id = (:id)", nativeQuery = true)
	   public void activateJobPosition(@Param("id") int id);

	   @Query(value ="select * from job_positions where id=:id", nativeQuery = true)
	   public List<JobPosition> findjobPositionId(@Param("id") int id);

}
