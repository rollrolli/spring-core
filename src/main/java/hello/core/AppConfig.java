package hello.core;

import hello.core.discount.DiscountPolish;
import hello.core.discount.FixDiscountPolish;
import hello.core.discount.RateDiscountPolish;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // cmd + option + M : 리팩토링 단축키
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolish());
    }

    @Bean
    public DiscountPolish discountPolish() {
        return new FixDiscountPolish();
    }


}
