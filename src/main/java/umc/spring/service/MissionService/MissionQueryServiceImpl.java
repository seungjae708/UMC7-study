package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.repository.MissionRepository;

@Service
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    public MissionQueryServiceImpl(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    @Override
    public Page<Mission> getMissionsByStore(Long storeId, Integer page) {
        return missionRepository.findAllByStoreId(storeId, PageRequest.of(page - 1, 10));
    }
}
