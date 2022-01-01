package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    // junit 5부터는 test method public으로 선언 안해도 됨
    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        // iter 치고 엔터 치면 자동으로 for 문 생성해줌
        for (String beanDefinitionName: beanDefinitionNames) {
            Object bean = applicationContext.getBean(beanDefinitionName);
            // soutv 치고 엔터 치면 변수명 찍어줌
            // soutm 치고 엔터 치면 메소드명 찍어줌
            System.out.println("bean = " + beanDefinitionName + " / object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        // iter 치고 엔터 치면 자동으로 for 문 생성해줌

        // BeanDefinition.ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
        // BeanDefinition.ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
        // BeanDefinition.ROLE_SUPPORT :

        for (String beanDefinitionName: beanDefinitionNames) {
            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = applicationContext.getBean(beanDefinitionName);
                // soutv 치고 엔터 치면 변수명 찍어줌
                // soutm 치고 엔터 치면 메소드명 찍어줌
                System.out.println("bean = " + beanDefinitionName + " / object = " + bean);
            }
//            Object bean = applicationContext.getBean(beanDefinitionName);
//            // soutv 치고 엔터 치면 변수명 찍어줌
//            // soutm 치고 엔터 치면 메소드명 찍어줌
//            System.out.println("bean = " + beanDefinitionName + " / object = " + bean);
        }
    }
}
