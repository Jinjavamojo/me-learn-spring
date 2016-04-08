package spring.simpleinjecting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.simpleinjecting.MediaPlayer;

/**
 * Created by Денис on 01.04.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "config.xml")
public class SpringTest1 {

    @Autowired
    MediaPlayer player;

    @Test
    public void test(){
        player.play();
    }
}
