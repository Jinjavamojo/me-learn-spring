package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.beans.MediaPlayer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "config/config.xml")
public class SpringTest2 {

    @Autowired
    public MediaPlayer player;

    @Test
    public void test() {
        player.play();
    }
}
