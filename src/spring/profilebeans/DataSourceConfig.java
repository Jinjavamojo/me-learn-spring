package spring.profilebeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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
public class DataSourceConfig {

    @Bean
    @Profile("dev")
    public DataSource getLocalDataSource() {
        return new DevelopDataSource();
    }

    @Bean
    @Profile("prod")
    public DataSource getProdDataSource() {
        return new ProdDataSource();
    }


}
