package spring.caching;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring.ormdata.entitites.Spitter;

import javax.inject.Inject;

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
@Service
public class BookServiceLayerImpl implements BookServiceLayer {

    @Inject
    BookDao bookDao;

    @Override
    public void save(Book spitter) {

    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public Book get(long id) {
        return bookDao.get(id);
    }
}
