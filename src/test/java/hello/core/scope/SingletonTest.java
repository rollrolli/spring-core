package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean singeltonBean = context.getBean(SingletonBean.class);
        System.out.println("singeltonBean = " + singeltonBean);
        SingletonBean singeltonBean1 = context.getBean(SingletonBean.class);
        System.out.println("singeltonBean1 = " + singeltonBean1);
        SingletonBean singeltonBean2 = context.getBean(SingletonBean.class);
        System.out.println("singeltonBean2 = " + singeltonBean2);
        SingletonBean singeltonBean3 = context.getBean(SingletonBean.class);
        System.out.println("singeltonBean3 = " + singeltonBean3);

        context.close();
    }

    @Scope("prototype")
    static class SingletonBean {
        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }
}
