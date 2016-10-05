package spring.caching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import spring.ormdata.AbstractDao;

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
@Repository
public class BookDaoImpl extends AbstractDao implements BookDao {
    @Override
    public void save(Book book) {

    }

    @Override
    public Book get(long id) {
        return (Book) getSession().get(Book.class,id);
    }
}
