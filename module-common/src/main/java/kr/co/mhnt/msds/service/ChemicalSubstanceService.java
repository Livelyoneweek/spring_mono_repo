package kr.co.mhnt.msds.service;

import kr.co.mhnt.msds.entity.ChemicalSubstance;
import kr.co.mhnt.msds.repository.ChemicalSubstanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChemicalSubstanceService {

    private final ChemicalSubstanceRepository chemicalSubstanceRepository;

    public String findChemical(Integer chemId) {
        log.info("### ChemicalSubstanceService.findChemical");
        Optional<ChemicalSubstance> byChemicalId = chemicalSubstanceRepository.findByChemicalId(chemId);
        if (byChemicalId.isPresent()) {
            ChemicalSubstance chemicalSubstance = byChemicalId.get();
            log.info("### chemicalSubstance kor = {}", chemicalSubstance.getChemNameKor());
            return chemicalSubstance.getChemNameKor();
        }
        return "empty";
    }
}
