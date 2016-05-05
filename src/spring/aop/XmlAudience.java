package spring.aop;

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
public class XmlAudience {

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
}
