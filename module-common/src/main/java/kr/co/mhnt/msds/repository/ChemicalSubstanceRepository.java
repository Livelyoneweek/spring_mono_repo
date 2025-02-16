package kr.co.mhnt.msds.repository;


import kr.co.mhnt.msds.entity.ChemicalSubstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChemicalSubstanceRepository extends JpaRepository<ChemicalSubstance, Integer> {

    @Query(value = """
            SELECT * FROM msds.c00_chemical_substances
                WHERE chem_id = :chemId""", nativeQuery = true)
    Optional<ChemicalSubstance> findByChemicalId(@Param("chemId") Integer chemId);


}
