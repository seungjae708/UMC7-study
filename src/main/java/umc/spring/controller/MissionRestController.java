package umc.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionCompleteConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MissionComplete;
import umc.spring.dto.MissionRequestDTO;
import umc.spring.dto.MissionResponseDTO;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;

@RequiredArgsConstructor
@RestController
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/{storeId}/mission")
    public ApiResponse<MissionResponseDTO.CreateResultDTO> createMission(
            @RequestParam("memberId") @ExistMember Long memberId,
            @RequestBody @Valid MissionRequestDTO.CreateDTO request,
            @PathVariable("storeId") @ExistStore Long storeId){
        Mission mission = missionCommandService.createMission(request, storeId, memberId);
        return ApiResponse.onSuccess(MissionConverter.toCreateResultDTO(mission));
    }

    @PostMapping("/{missionId}/addMission")
    public ApiResponse<Object> addChallengeMission(
            @PathVariable("missionId") Long missionId,
            @RequestParam("memberId") @ExistMember Long memberId){

        MissionComplete missionComplete = missionCommandService.addMissionToMember(missionId, memberId);
        return ApiResponse.onSuccess(MissionCompleteConverter.toCreateMemberMissionResultDTO(missionComplete));
    }


    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회", description = "특정 가게의 미션을 페이징 처리하여 반환합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "조회할 페이지 번호입니다. 기본값은 1입니다.")
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getMissions(
            @PathVariable("storeId") Long storeId,
            @CheckPage @RequestParam(name = "page", defaultValue = "1") Integer page) {
        Page<Mission> missionList = missionQueryService.getMissionsByStore(storeId, page);
        return ApiResponse.onSuccess(MissionConverter.missionPreViewListDTO(missionList));
    }

    @GetMapping("/member")
    @Operation(summary = "멤버의 진행 중 or 진행 완료 미션 목록 조회 API", description = "status에 따른 멤버의 모든 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다."),
            @Parameter(name = "status", description = "미션 상태, 진행 중이라면 challenging, 진행 완료라면 complete 입니다."),
            @Parameter(name = "page", description = "조회할 페이지 번호입니다. 기본값은 1입니다.")
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getMemberChallengeMissionPage (
            @RequestParam(name = "memberId") @ExistMember Long memberId,
            @RequestParam(name = "status") String status,
            @CheckPage @RequestParam(name = "page", defaultValue = "1") Integer page){
        Page<Mission> missionList = missionQueryService.getMemberMissionPage(memberId, status, page);

        return ApiResponse.onSuccess(MissionConverter.missionPreViewListDTO(missionList));
    }

}
