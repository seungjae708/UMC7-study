package umc.spring.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.dto.ReviewRequestDTO;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;


    @Override
    @Transactional
    public Review addReview(ReviewRequestDTO.InsertReviewDTO request, Long storeId, Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        Store store = storeRepository.findById(storeId).get();

        Review newReview =  ReviewConverter.toReview(request, member, store);
        store.getReview().add(newReview);
        member.getReview().add(newReview);
        return reviewRepository.save(newReview);
    }
}
