package umc.spring.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank(message = "이름은 필수 입력 항목입니다. 최대 10자 까지 입력 가능")
        @Size(max = 10)
        @Schema(description = "이름", example = "최승재", type="string")
        String name;
        @NotNull(message = "성별은 필수 입력 항목입니다. 남성일 경우 1, 여성일 경우 2 값을 넘겨주세요.")
        @Schema(description = "성별", example = "1", type = "int")
        Integer gender;
        @NotNull(message = "널이어서는 안됩니다.")
        Integer birthYear;
        @NotNull(message = "널이어서는 안됩니다.")
        Integer birthMonth;
        @NotNull(message = "널이어서는 안됩니다.")
        Integer birthDay;
        @Size(min = 5, max = 12)
        @NotBlank(message = "주소는 필수 입력 항목입니다. 최대 30자 까지 입력 가능")
        @Schema(description = "주소", example = "서울 성북구 삼선교로", type="string")
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }
}