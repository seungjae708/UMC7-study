package umc.spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.MissionCompleteConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MissionComplete;
import umc.spring.dto.MissionRequestDTO;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionCompleteRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;
    private final MissionCompleteRepository missionCompleteRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Mission createMission(MissionRequestDTO.CreateDTO request, Long storeId, Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        Store store = storeRepository.findById(storeId).get();
        Mission newMission = MissionConverter.toMission(request, store, member);
        store.getMission().add(newMission);
        return missionRepository.save(newMission);
    }

    @Override
    public MissionComplete addMissionToMember(Long missionId, Long memberId) {
        Mission mission = missionRepository.findById(missionId).get();
        Member member = memberRepository.findById(memberId).get();
        MissionComplete missionComplete = MissionCompleteConverter.toMissionComplete(member, mission);
        return missionCompleteRepository.save(missionComplete);
    }
}
