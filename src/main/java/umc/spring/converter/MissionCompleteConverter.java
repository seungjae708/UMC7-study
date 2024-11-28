package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MissionComplete;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.dto.MissionResponseDTO;

public class MissionCompleteConverter {
    public static MissionResponseDTO.CreateMemberMissionResultDTO toCreateMemberMissionResultDTO(MissionComplete missionComplete) {
        return MissionResponseDTO.CreateMemberMissionResultDTO.builder()
                .id(missionComplete.getId())
                .status(missionComplete.getStatus().toString())
                .missionContent(missionComplete.getMission().getContent())
                .missionReward(missionComplete.getMission().getReward())
                .build();
    }

    public static MissionComplete toMissionComplete(Member member, Mission mission){
        return MissionComplete.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGEING)
                .build();
    }
}
