package spring.ormdata;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import spring.ormdata.entitites.Spitter;

import java.io.Serializable;
import java.util.List;

/*
@Repository serves another purpose. Recall that one of the jobs
of a template class is to catch platform-specific exceptions and rethrow them as
one of Spring’s unified unchecked exception
But if you’re using Hibernate contextual sessions and not a Hibernate template, how can the exception translation take place?

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
