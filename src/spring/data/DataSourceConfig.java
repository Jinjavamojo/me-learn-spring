package spring.data;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

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
@Configuration
@ImportResource("classpath:spring/data/config.xml")
@PropertySource("classpath:/spring/data/application.properties")
public class DataSourceConfig {

//    @Bean
//    public JndiObjectFactoryBean dataSource() {
//        JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
//        jndiObjectFB.setJndiName("jdbc/SpittrDS");
//        jndiObjectFB.setResourceRef(true);
//        jndiObjectFB.setProxyInterface(javax.sql.DataSource.class);
//        return jndiObjectFB;
//    }

    //Using a pooled data source
    @Bean
    @Profile("test")
    public BasicDataSource dataSource2() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://rgu.samara.lanit.ru/rgu_mrg");
        ds.setUsername("postgres");
        ds.setPassword("root");
        ds.setInitialSize(5);
        ds.setMaxActive(10);
        return ds;
    }

    /*
    Returns  a  new  connection  every  time  a  connection  is  requested.  Unlike  DBCP’s
    BasicDataSource,  the  connections  provided by DriverManagerDataSource aren’t pooled.
     */

    /*
    At the same time, even though DriverManager-DataSource and   SimpleDriverDataSource
    are  both  capable  of  supporting  multiple threads, they incur a performance cost for
    creating a new connection each time a connection is requested. Because of these limitations,
    I strongly recommend using pooled data sources.
     */
    @Bean
    @Profile("test2")
    public DataSource dataSource3() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://rgu.samara.lanit.ru/rgu_mrg");
        ds.setUsername("postgres");
        ds.setPassword("root");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
