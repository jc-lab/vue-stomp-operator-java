package kr.jclab.spring.vuestompoperator;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(VueStompOperatorBackendConfiguration.class)
@SuppressWarnings("unused")
public @interface EnableVueStompOperatorBackend {
}
