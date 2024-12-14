package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MissionComplete;
import umc.spring.repository.MissionCompleteRepository;
import umc.spring.validation.annotation.CheckMissionStatus;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CheckMissionStatusValidator implements ConstraintValidator<CheckMissionStatus, Long> {

    private final MissionCompleteRepository missionCompleteRepository;

    @Override
    public void initialize(CheckMissionStatus constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        Long memberId = 1L; // 실제 회원 ID는 인증 정보를 통해 가져오도록 수정 필요

        // 이미 도전 중인지 확인
        Optional<MissionComplete> existingMissionComplete = missionCompleteRepository.findByMemberIdAndMissionId(memberId, missionId);
        if (existingMissionComplete.isPresent() && existingMissionComplete.get().getStatus() == MissionStatus.CHALLENGEING) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("해당 미션은 이미 도전 중입니다.").addConstraintViolation();
            return false;
        }

        return true;
    }
}
