package spring.ormdata;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import spring.ormdata.entitites.Spitter;

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
public class AbstractDao {
    @Autowired
    private SessionFactory sessionFactory;

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
