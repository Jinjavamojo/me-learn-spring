package spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by Денис on 01.05.2016.
 */
@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value="concert.Performance+",
            defaultImpl=DefaultEncoreable.class)
    public static Encoreable encoreable;
}
