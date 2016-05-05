package spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AspectConfig.class)
public class TestAnnotateAop {

    @Autowired
    public PerfomanceI perf;

    @Autowired
    public TrackPlayer player;

    @Autowired
    public TrackCounter counter;

    @Test
    public void test() {
        perf.perform();
    }

    @Test
    public void test2() {
        for (int i = 0; i < 10; i++) {
            player.playTrack(i);
        }
        for (int i = 0; i < 5; i++) {
            player.playTrack(i);
        }
        counter.listAllCounts();

    }
}
