package kr.co.mhnt.util;

import kr.co.mhnt.enumFile.AccidentType;
import kr.co.mhnt.enumFile.EDMSApprovalStatus;
import kr.co.mhnt.enumFile.enumInterface.CodeEnum;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Slf4j
public enum EnumSearch {

    ACCIDENT_TYPE("ACCIDENT_TYPE", "사고유형", AccidentType.class),
    EDMS("EDMS", "사고유형", EDMSApprovalStatus.class);

    private final String groupCode;
    private final String groupName;
    private final Class<? extends CodeEnum> enumClass;

    EnumSearch(String groupName, String groupCode, Class<? extends CodeEnum> enumClass) {
        this.groupName = groupName;
        this.groupCode = groupCode;
        this.enumClass = enumClass;
    }

    // 특정 그룹 코드에 해당하는 Enum 항목을 리스트로 반환하는 메서드
    public static List<CodeEnum> findByGroupCode(String groupCode) {
        return Arrays.stream(values())
                .filter(group -> group.getGroupCode().equals(groupCode))
                .flatMap(group -> Arrays.stream(group.getEnumClass().getEnumConstants()))
                .collect(Collectors.toList());
    }
}