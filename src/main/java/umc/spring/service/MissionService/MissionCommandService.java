package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MissionComplete;
import umc.spring.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission createMission(MissionRequestDTO.CreateDTO request, Long storeId, Long memberId);
    MissionComplete addMissionToMember(Long missionId, Long memberId);
}
