package kr.co.mhnt.msds.manager;

import kr.co.mhnt.msds.service.ChemicalSubstanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MsdsManager {

    private final ChemicalSubstanceService chemicalSubstanceService;

    public String findChemical(Integer chemId) {
        log.info("### MsdsManager.findChemical");
        String chemical = chemicalSubstanceService.findChemical(chemId);
        log.info("### MsdsManager.findChemical: {}", chemical);
        return chemical;
    }
}
