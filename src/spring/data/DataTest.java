package spring.data;


import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "config.xml")
@ContextConfiguration(classes = DataSourceConfig.class)
public class DataTest extends Assert {

    @Autowired
    private BasicDataSource basicDataSource;

    @Autowired
    private DataSource ds;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test() throws Exception{
        Connection connection = basicDataSource.getConnection();
        assertNotNull(connection);
        Integer integer = jdbcTemplate.queryForObject("select count(*) from service_2", Integer.class);
        jdbcTemplate.query("select * from service_2 limit 19", new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                long id = resultSet.getLong("id");
                return null;
            }
        });
        int  g= 0;
        Connection connection2 = ds.getConnection();
        assertNotNull(connection2);
    }
}
