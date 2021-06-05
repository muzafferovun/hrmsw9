package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import kodlamaio.hrms.entities.concretes.SectorPosition;

public interface SectorPositionDao  extends JpaRepository<SectorPosition, Integer> {
    @Query(value = "SELECT dataTable.* FROM sector_positions dataTable WHERE dataTable.position_name=:positionName and sector_id=:sectorId", nativeQuery = true)
    public List<SectorPosition> getSectorPosition(@Param("positionName") String positionName,@Param("sectorId") int sectorId);

}
