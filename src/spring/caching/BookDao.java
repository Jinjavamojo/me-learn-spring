package spring.caching;


public interface BookDao {

    void save(Book book);

    Book get(long id);
}
