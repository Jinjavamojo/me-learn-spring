package spring.aspects;

import org.springframework.stereotype.Component;

/**
 * Created by Денис on 01.05.2016.
 */
@Component
public class Perfomance implements PerfomanceI {

    @Override
    public void perform() {
        System.out.println("TAAA-DA");

    }
}
