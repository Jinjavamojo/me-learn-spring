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
public class DefaultEncoreable implements Encoreable {

    @Override
    public void encorage() {
        System.out.println("eyy");
    }
}
