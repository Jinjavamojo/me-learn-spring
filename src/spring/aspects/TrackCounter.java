package spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Денис on 01.05.2016.
 */
@Aspect
@Component
public class TrackCounter {

    private Map<Integer, Integer> trackCounts =
            new HashMap<>();

    @Pointcut(
            "execution(* spring.aspects.TrackPlayer.playTrack(int)) " +
                    "&& args(number)")
    public void trackPlayed(int number) {}

    @Before("trackPlayed(number)")
    public void countTrack(int number) {
        int v = trackCounts.containsKey(number) ? trackCounts.get(number) : 0;
        trackCounts.put(number, v + 1);
    }

    public void listAllCounts() {
        for (Map.Entry<Integer, Integer> integerIntegerEntry : trackCounts.entrySet()) {
            System.out.println(String.format("Track #%s = %s", integerIntegerEntry.getKey(), integerIntegerEntry.getValue()));
        }
    }
}
