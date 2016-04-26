package spring.addressing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import spring.profilebeans.DataSource;
import spring.profilebeans.DevelopDataSource;
import spring.profilebeans.MagicBean;
import spring.profilebeans.ProdDataSource;


@Configuration
@ComponentScan("spring.addressing")
public class DesertConfig {

}
