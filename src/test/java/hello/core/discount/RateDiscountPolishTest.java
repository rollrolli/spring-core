package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

// Test 클래스 만드는 단축키 : cmd + shift + T
class RateDiscountPolishTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
//    DiscountPolish discountPolish = new RateDiscountPolish();
//    MemberService memberService = new MemberServiceImpl();

//    @Test
//    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
//    void vip_o() {
//        // given
//        Member member = new Member(1L, "vipMember", Grade.VIP);
//        memberService.join(member);
//
//        // when
//        int discountPrice = discountPolish.discount(member, 10000);
//
//        // then
//        assertThat(discountPrice).isEqualTo(1000);
//    }
//
//    @Test
//    @DisplayName("VIP가 아니면 10% 할인 적용되지 않아야 한다.")
//    void vip_x() {
//        // given
//        Member member = new Member(1L, "notVipMember", Grade.BASIC);
//
//        // when
//        int discountPrice = discountPolish.discount(member, 10000);
//
//        // then
//        assertThat(discountPrice).isEqualTo(0);
//    }
}
