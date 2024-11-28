package umc.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ReviewResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InsertResultDTO { // 리뷰 등록
        private Long reviewId;
        private String content;
        private Float score;
        private LocalDateTime createdAt;
    }
}
