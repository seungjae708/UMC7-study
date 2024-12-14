package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MissionComplete;

import java.util.Optional;

public interface MissionCompleteRepository extends JpaRepository<MissionComplete,Long> {
    Optional<MissionComplete> findByMemberIdAndMissionId(Long memberId, Long missionId);
    Page<MissionComplete> findByMemberIdAndStatus(Long memberId, MissionStatus status, PageRequest pageRequest);
}
