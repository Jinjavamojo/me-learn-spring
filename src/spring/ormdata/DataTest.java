package spring.ormdata;


import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.data.DataSourceConfig;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ORMDataSourceConfig.class)
public class DataTest extends Assert {

    @Autowired
    private DataSource ds;

//    @Inject
//    protected SpitterRepository spitterRepository;

    @Inject
    protected ServiceLayer layer;

    @Test
    public void test() throws Exception{
        Connection connection2 = ds.getConnection();
        assertNotNull(connection2);
//        spitterRepository.count();
        layer.findOne(121321l);
        int g = 0;
    }
}
