package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.MissionComplete;

import java.util.Optional;

public interface MissionCompleteRepository extends JpaRepository<MissionComplete,Long> {
    Optional<MissionComplete> findByMemberIdAndMissionId(Long memberId, Long missionId);
}
