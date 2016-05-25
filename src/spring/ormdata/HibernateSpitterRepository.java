package spring.ormdata;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring.ormdata.entitites.Spitter;

import java.io.Serializable;
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

@Repository
//@Transactional(propagation = Propagation.REQUIRED)
public class HibernateSpitterRepository extends AbstractDao implements SpitterRepository  {

    public long count() {
        return findAll().size();
    }

    public Spitter save(Spitter spitter) {
        Serializable id = getSession().save(spitter);  //<co id="co_UseCurrentSession"/>
        return new Spitter((Long) id,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdateByEmail());
    }

    public Spitter findOne(long id) {
        return (Spitter) getSession().get(Spitter.class, id);
    }

    public Spitter findByUsername(String username) {
        return (Spitter) getSession()
                .createCriteria(Spitter.class)
                .add(Restrictions.eq("username", username))
                .list().get(0);
    }

    public List<Spitter> findAll() {
        return (List<Spitter>) getSession()
                .createCriteria(Spitter.class).list();
    }
}
