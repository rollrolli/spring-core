package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolish;
import hello.core.discount.FixDiscountPolish;
import hello.core.discount.RateDiscountPolish;
import hello.core.member.Member;
import hello.core.member.MemberRespository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRespository memberRespository;
//    private final DiscountPolish discountPolish = new FixDiscountPolish();
    private final DiscountPolish discountPolish;

    @Autowired
    public OrderServiceImpl(MemberRespository memberRespository, @MainDiscountPolicy DiscountPolish discountPolish) {
        this.memberRespository = memberRespository;
        this.discountPolish = discountPolish;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRespository.findById(memberId);
        int discountPrice = discountPolish.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
