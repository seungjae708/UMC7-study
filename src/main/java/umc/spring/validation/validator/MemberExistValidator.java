package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;

@RequiredArgsConstructor
@Component
public class MemberExistValidator implements ConstraintValidator <ExistMember,Long> {

    private final MemberRepository memberRepository;

    @Override
    public void initialize(ExistMember constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        // 파라미터로 넘어온 지역 아이디가 존재하는 아이디인지 검증
        boolean isValid = memberRepository.existsById(value);

        // false이면 MEMBER_NOT_FOUND 에러 던지기
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}