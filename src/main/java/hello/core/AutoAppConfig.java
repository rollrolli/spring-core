package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        // basePackageClasses = AutoAppConfig.class,
        // basePackageClasses 설정하지 않으면 디폴트로 현재 클래스의 패키지 하위를 다 봄
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 기존의 예제를 유지하기 위한 방책
)
public class AutoAppConfig {
}
