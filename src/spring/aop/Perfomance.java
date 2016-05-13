package spring.aop;

import org.springframework.stereotype.Component;

/**
 * Created by Денис on 01.05.2016.
 */
@Component
public class Perfomance implements PerfomanceI {

    @Override
    @Timed
    public void perform() {
        System.out.println("TAaAA-DA");
    }
}
