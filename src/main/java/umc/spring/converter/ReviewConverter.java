package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.dto.ReviewRequestDTO;
import umc.spring.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.InsertResultDTO toResultDTO(Review review){
        return ReviewResponseDTO.InsertResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .content(review.getContent())
                .score(review.getScore())
                .build();
    }
    public static Review toReview(ReviewRequestDTO.InsertReviewDTO request, Member member, Store store){
        return Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();
    }
}
