package spring.profilebeans;

import org.springframework.context.annotation.*;


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

    @Bean
    //@Conditional(value = MagicExistsCondition.class)
    public MagicBean getMagicBean() {
        return new MagicBean();
    }


}
