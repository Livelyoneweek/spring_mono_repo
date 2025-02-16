package kr.co.mhnt.enumFile;

import kr.co.mhnt.enumFile.enumInterface.CodeEnum;
import lombok.Getter;

@Getter
public enum AccidentType implements CodeEnum {
    FALL("ACCIDENT_TYPE","FALL", "FALL", "추락", true, "설명 1"),
    STUCK("ACCIDENT_TYPE", "STUCK", "STUCK", "끼임", true, "설명 2"),
    HIT("ACCIDENT_TYPE", "HIT", "HIT", "부딪힘", true, "설명 3");

    private final String groupCode;
    private final String code;
    private final String englishLabel;
    private final String koreanLabel;
    private final boolean active;
    private final String description;

    AccidentType(String groupCode, String code, String englishLabel, String koreanLabel, boolean active, String description) {
        this.groupCode = groupCode;
        this.code = code;
        this.englishLabel = englishLabel;
        this.koreanLabel = koreanLabel;
        this.active = active;
        this.description = description;
    }

    public static AccidentType findBy(String type) {
        if (type != null) {
            for (AccidentType accidentType : AccidentType.values()) {
                if (accidentType.code.equalsIgnoreCase(type)) {
                    return accidentType;
                }
            }
            throw new RuntimeException("### AccidentType code 불일치");
        }
        return null;
    }
}

