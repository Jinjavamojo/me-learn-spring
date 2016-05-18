package spring.data;


import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "config.xml")
@ContextConfiguration(classes = DataSourceConfig.class)
public class DataTest extends Assert {

    @Autowired
    private BasicDataSource basicDataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test() throws Exception{
        Connection connection = basicDataSource.getConnection();
        assertNotNull(connection);
    }
}
