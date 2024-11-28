package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.MissionComplete;

public interface MissionCompleteRepository extends JpaRepository<MissionComplete,Long> {
}
