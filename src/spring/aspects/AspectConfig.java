package spring.aspects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Денис on 01.05.2016.
 */
@Configuration
@ComponentScan("spring.aspects")
@EnableAspectJAutoProxy
public class AspectConfig {

}
