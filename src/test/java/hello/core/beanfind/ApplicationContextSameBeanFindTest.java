package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolish;
import hello.core.member.MemberRespository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면 중복 오류가 발생한다")
    void findBeanByTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> applicationContext.getBean(MemberRespository.class));
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType() {
        Map<String, MemberRespository> beansOfType = applicationContext.getBeansOfType(MemberRespository.class);
        for (String beanName : beansOfType.keySet()) {
            System.out.println(beanName);
        }
    }

    @Configuration
    static class SameBeanConfig {

        @Bean
        public MemberRespository memberRespository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRespository memberRespository2() {
            return new MemoryMemberRepository();
        }

    }
}
