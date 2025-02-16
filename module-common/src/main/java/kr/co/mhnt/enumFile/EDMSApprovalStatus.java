package kr.co.mhnt.enumFile;

import kr.co.mhnt.enumFile.enumInterface.CodeEnum;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public enum EDMSApprovalStatus implements CodeEnum {
    NOT_PROGRESS("EDMS","NOT_PROGRESS", "NOT_PROGRESS_ENG", "미진행", true, "설명 1"),
    PENDING("EDMS","PENDING", "PENDING_ENG", "결재대기", true, "설명 2"),
    PROGRESS("EDMS", "PROGRESS", "PROGRESS_ENG", "결재중", true, "설명 3");

    private final String groupCode;
    private final String code;
    private final String englishLabel;
    private final String koreanLabel;
    private final boolean active;
    private final String description;

    EDMSApprovalStatus(String groupCode, String code, String englishLabel, String koreanLabel, boolean active, String description) {
        this.groupCode = groupCode;
        this.code = code;
        this.englishLabel = englishLabel;
        this.koreanLabel = koreanLabel;
        this.active = active;
        this.description = description;
    }

    public static EDMSApprovalStatus findBy(String status) {
        log.info("stats= {}",status);
        for (EDMSApprovalStatus edmsApprovalStatus : EDMSApprovalStatus.values()) {
            if (edmsApprovalStatus.code.equalsIgnoreCase(status)) {
                return edmsApprovalStatus;
            }
        }
        throw new RuntimeException("### EDMSApprovalStatus code 불일치");
    }
}
