package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;

public interface MissionQueryService {
    Page<Mission> getMissionsByStore(Long storeId, Integer page);
    Page<Mission> getMemberMissionPage(Long memberId, String status, Integer page);
}
