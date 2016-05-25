package spring.ormdata;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.ormdata.entitites.Spitter;

import javax.inject.Inject;
import java.util.List;

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


/*
 which starts a transaction on each method start, and commits it on each method exit ( or rollback if method was failed due to an error).
 Note that since the transaction are on method scope, and inside method we are using DAO,
 DAO method will be executed within same transaction.
 */
@Service
@Transactional
public class ServiceLayerImpl implements ServiceLayer {

    @Inject
    protected HibernateSpitterRepository repository;

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public Spitter save(Spitter spitter) {
        return null;
    }

    @Override
    public Spitter findOne(long id) {
        return repository.findOne(id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }

    @Override
    public List<Spitter> findAll() {
        return null;
    }
}
