package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolish implements DiscountPolish {

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) { // enum 타입은 비교 시 == 사용
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
