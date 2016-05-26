package spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;

/**
 * Copyright 2016 LANIT group.
 * http://www.lanit.ru/
 * <p/>
 * Repository path:    $HeadURL$
 * Last committed:     $Revision$
 * Last changed by:    $Author$
 * Last changed date:  $Date$
 * ID:                 $Id$
 */
public class XmlAudience implements Ordered {

    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Silencing cell phones from xml");
            System.out.println("Taking seats from xml");
           Object proceed = jp.proceed();
            //System.out.println(proceed);
//            System.out.println(jp.getSignature().toString());
//            System.out.println(jp.getSourceLocation().toString());
//            System.out.println(jp.getTarget().toString());
            System.out.println("CLAP CLAP CLAp from xml!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
    }

    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }
    public void takeSeats() {
        System.out.println("Taking seats");
    }
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

    @Override
    public int getOrder() {
        return 100;
    }
}
