package spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Aspect
@Component
public class TimingAspect implements Ordered {
    @Around(value = "@annotation(spring.aop.Timed)")
    static Object timeMethod(final ProceedingJoinPoint pjp) throws Throwable {
        return time(pjp,null);
    }

    @Around(value = "within(@spring.aop.Timed *) && @target(timed)")
    static Object timeClass(final ProceedingJoinPoint pjp, final Timed timed) throws Throwable {
        return time(pjp, timed);
    }

    private static Object time(final ProceedingJoinPoint pjp, final Timed timed) throws Throwable {

        Assert.notNull(pjp);

        final Signature signature = pjp.getSignature();
        final String shortString = "[" + signature.toShortString() + "]";

        System.out.println();
        System.out.println(">>>> started " + shortString);

        final long startTimeMs = System.currentTimeMillis();

        try {
            return pjp.proceed();
        } finally {

            final long timeTakenMs = System.currentTimeMillis() - startTimeMs;
            System.out.println("<<<< completed " + shortString + " (took " + timeTakenMs + "ms)");
            System.out.println();

        }
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
