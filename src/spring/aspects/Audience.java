package spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Денис on 01.05.2016.
 */
@Aspect
@Component
public class Audience {

    @Pointcut("execution(** spring.aspects.Perfomance.perform(..))")
    //should be empty body
    public void performance() {}


    //@Before("performance())")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    //@Before("performance()")
    public void silencePhones() {
        System.out.println("Silencing cell phones");
    }

    //@AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    //@AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            Object proceed = jp.proceed();
            System.out.println(proceed);
            System.out.println(jp.getSignature().toString());
            System.out.println(jp.getSourceLocation().toString());
            System.out.println(jp.getTarget().toString());
            System.out.println("CLAP CLAP CLAP2!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
    }

}
