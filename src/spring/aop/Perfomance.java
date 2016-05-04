package spring.aop;

import org.springframework.stereotype.Component;

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
@Component
public class Perfomance {

    void perform() {
        System.out.println("TADAAA");
    }
}
