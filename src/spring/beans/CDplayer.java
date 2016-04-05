package spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDplayer implements MediaPlayer {

    private CompactDisc disc;

    @Autowired
    public CDplayer(CompactDisc compactDisc) {
        disc = compactDisc;
    }


    @Override
    public void play() {
        disc.play();
    }
}
