package kr.co.mhnt.msds.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.co.mhnt.msds.manager.MsdsManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/chemical/v1")
public class MsdsController {

    private final MsdsManager msdsManager;


    @Operation(summary = "chemId 로 화학물질 조회", description = """
            ```
            chemId 로 화학물질 조회
            ```
            """)
    @GetMapping
    public ResponseEntity<String> findChemical(@RequestParam Integer chemicalId) {
        log.info("### MsdsController.findChemical");
        String chemical = msdsManager.findChemical(chemicalId);
        return ResponseEntity.ok(chemical);
    }
}
