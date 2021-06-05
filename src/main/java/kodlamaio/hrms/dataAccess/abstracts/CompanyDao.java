package kodlamaio.hrms.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.Company;




public interface CompanyDao  extends JpaRepository<Company, Integer>{

	 
    @Modifying
    @Transactional
    @Query(value = "update company set is_verify = true where id = (:id)", nativeQuery = true)
   public void activateCompany(@Param("id") int id);
	
    @Query("From Company where company_name=:companyName")
	public  Company getByCompanyName(String companyName);
  
}
