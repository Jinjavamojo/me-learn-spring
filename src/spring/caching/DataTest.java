package spring.caching;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.ormdata.ORMDataSourceConfig;
import spring.ormdata.ServiceLayer;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CacheExampleConfig.class)
public class DataTest extends Assert {

    @Autowired
    private DataSource ds;

    @Inject
    protected BookServiceLayer layer;

    @Test
    public void test() throws Exception{
        Connection connection2 = ds.getConnection();
        assertNotNull(connection2);
//        spitterRepository.count();
        layer.get(121321l);
        int g = 0;
    }
}
