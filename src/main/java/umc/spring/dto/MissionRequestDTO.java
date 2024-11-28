package umc.spring.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class CreateDTO{
        @NotNull
        @Size(max = 300)
        private String content;

        @NotNull
        private LocalDate deadline;

        @NotNull
        private Integer reward;
    }
}
