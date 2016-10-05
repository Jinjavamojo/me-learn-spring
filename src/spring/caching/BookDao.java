package spring.caching;


import org.springframework.cache.annotation.Cacheable;

public interface BookDao {

    void save(Book book);

    Book get(long id);
}
