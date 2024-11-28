package umc.spring.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.dto.MissionRequestDTO;
import umc.spring.dto.MissionResponseDTO;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;

@RequiredArgsConstructor
@RestController
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/{storeId}/mission")
    public ApiResponse<MissionResponseDTO.CreateResultDTO> createMission(
            @RequestParam("memberId") @ExistMember Long memberId,
            @RequestBody @Valid MissionRequestDTO.CreateDTO request,
            @PathVariable("storeId") @ExistStore Long storeId){
        Mission mission = missionCommandService.createMission(request, storeId, memberId);
        return ApiResponse.onSuccess(MissionConverter.toCreateResultDTO(mission));
    }
}
