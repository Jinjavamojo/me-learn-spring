package spring.caching;

import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(key = "#result.isbn", value = "bookCache")
    Book get(long id);
}
