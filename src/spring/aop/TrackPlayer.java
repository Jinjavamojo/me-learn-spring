package spring.aop;

import org.springframework.stereotype.Component;

/**
 * Created by Денис on 01.05.2016.
 */
@Component
public class TrackPlayer {

    //method is needed to be public(not protected or package) to aspect worked fine.
    public void playTrack(int number) {
        System.out.println(String.format("track #%s is playing now", number));
    }
}
