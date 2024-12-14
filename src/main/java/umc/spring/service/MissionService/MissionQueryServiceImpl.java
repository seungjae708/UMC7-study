package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MissionComplete;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionCompleteRepository;
import umc.spring.repository.MissionRepository;

@Service
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final MissionCompleteRepository missionCompleteRepository;

    public MissionQueryServiceImpl(MissionRepository missionRepository, MemberRepository memberRepository, MissionCompleteRepository missionCompleteRepository) {
        this.missionRepository = missionRepository;
        this.missionCompleteRepository = missionCompleteRepository;
    }

    @Override
    public Page<Mission> getMissionsByStore(Long storeId, Integer page) {
        return missionRepository.findAllByStoreId(storeId, PageRequest.of(page - 1, 10));
    }

    @Override
    public Page<Mission> getMemberMissionPage(Long memberId, String status, Integer page) {
        MissionStatus missionStatus;
        try {
            // 문자열을 MissionStatus enum으로 변환
            missionStatus = MissionStatus.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid mission status: " + status);
        }

        // MissionComplete 데이터를 조회
        Page<MissionComplete> missionCompletes = missionCompleteRepository.findByMemberIdAndStatus(
                memberId,
                missionStatus,
                PageRequest.of(page - 1, 10) // 프론트의 1 기반 페이지를 0 기반으로 변환
        );

        // MissionComplete에서 Mission 데이터로 변환
        return missionCompletes.map(MissionComplete::getMission);
    }


}
