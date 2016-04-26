package spring.profilebeans;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;


public class MagicExistsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        //conditionContext.getRegistry();
        //conditionContext.getClassLoader();
        //conditionContext.getBeanFactory();
        return environment.containsProperty("magic");
    }
}
