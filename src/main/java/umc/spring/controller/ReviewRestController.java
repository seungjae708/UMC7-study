package umc.spring.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.dto.ReviewRequestDTO;
import umc.spring.dto.ReviewResponseDTO;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{storeId}/review")
    public ApiResponse<ReviewResponseDTO.InsertResultDTO> add(
            @RequestParam("memberId") @ExistMember Long memberId,
            @PathVariable("storeId") @ExistStore Long storeId,
            @RequestBody @Valid ReviewRequestDTO.InsertReviewDTO request){
        Review review = reviewCommandService.addReview(request, storeId, memberId);
        return ApiResponse.onSuccess(ReviewConverter.toResultDTO(review));
    }
}
