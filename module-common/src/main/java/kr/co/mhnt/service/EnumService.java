package kr.co.mhnt.service;

import kr.co.mhnt.enumFile.enumInterface.CodeEnum;
import kr.co.mhnt.util.EnumSearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EnumService {

    public List<CodeEnum> getEnumListByGroupCode(String groupCode) {
        log.info("### EnumService.getEnumListByGroupCode");
        if (groupCode == null || groupCode.isEmpty()) {
           return List.of();
        }
        return EnumSearch.findByGroupCode(groupCode);
    }
}
