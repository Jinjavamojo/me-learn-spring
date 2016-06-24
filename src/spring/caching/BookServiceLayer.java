package spring.caching;

import spring.ormdata.entitites.Spitter;

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
public interface BookServiceLayer {

    void save(Book book);

    Book get(long id);
}
