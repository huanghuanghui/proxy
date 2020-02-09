package proxy.annotationproxy;

import java.lang.annotation.*;

/**
 * @auther hhh
 * @date 2020/2/9 14:57
 * @description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Transaction {
    String value() default "";
}
