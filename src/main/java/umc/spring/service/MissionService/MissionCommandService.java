package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MissionComplete;
import umc.spring.dto.MissionRequestDTO;
import umc.spring.validation.annotation.CheckMissionStatus;

public interface MissionCommandService {
    Mission createMission(MissionRequestDTO.CreateDTO request, Long storeId, Long memberId);
    MissionComplete addMissionToMember(@CheckMissionStatus Long missionId, Long memberId);
}
