package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import kodlamaio.hrms.entities.concretes.SectorProfession;

public interface SectorProfessionDao   extends JpaRepository<SectorProfession, Integer>{
    @Query(value = "SELECT dataTable.* FROM sector_position_professions dataTable WHERE dataTable.profession_name=:professionName and sector_position_id=:sectorPositionId", nativeQuery = true)
    public List<SectorProfession> getSectorProfession(@Param("professionName") String professionName,@Param("sectorPositionId") int sectorPositionId);

}
