package spring.profilebeans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.profilebeans.DataSource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "config.xml")
@ActiveProfiles("prod")
public class SpringTestProfiles {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() {
        System.out.println(dataSource.getConnString());
    }
}
