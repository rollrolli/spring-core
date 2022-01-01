package hello.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class CoreApplicationTests {

	ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

}
