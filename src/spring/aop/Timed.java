package spring.aop;

import java.lang.annotation.*;

@Inherited
@Documented
@Target( { ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Timed {
}
