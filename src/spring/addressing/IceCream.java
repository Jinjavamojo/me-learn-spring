package spring.addressing;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
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
//@Primary
@Creamy
@Component
@Qualifier("cold")
public class IceCream implements Dessert {
    @Override
    public String getMe() {
        return "cold...";
    }
}
