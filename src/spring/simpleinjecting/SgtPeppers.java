package spring.simpleinjecting;

import org.springframework.stereotype.Component;

/**
 * Created by Денис on 01.04.2016.
 */
@Component
public class SgtPeppers implements CompactDisc {

    @Override
    public void play() {
        System.out.println("hop hey");
    }
}
