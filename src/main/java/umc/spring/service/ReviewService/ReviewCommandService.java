package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review addReview(ReviewRequestDTO.InsertReviewDTO request, Long storeId, Long memberId);
}
