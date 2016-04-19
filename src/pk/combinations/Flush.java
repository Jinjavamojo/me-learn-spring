package pk.combinations;

import com.sun.istack.internal.NotNull;
import org.springframework.util.CollectionUtils;
import pk.CombinationHelper;
import pk.comparators.RankComparator;
import pk.model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Flush extends CardSet<Flush> {
    public Flush(List<Card> cards) {
        this.cards = new ArrayList<>();
        this.cards.addAll(cards);
    }

    @Override
    public int compareTo(Flush o) {
        Comparator<Card> rankComp = CombinationHelper.descRankComparator;
        Collections.sort(this.cards, rankComp);
        Collections.sort(o.cards, rankComp);
        for (int i = 0; i < 5; i++) {
            if (this.cards.get(i).getRank().getValue() > o.getCards().get(i).getRank().getValue()) {
                return 1;
            }
            if (this.cards.get(i).getRank().getValue() < o.getCards().get(i).getRank().getValue()) {
                return -1;
            }
        }
        throw new RuntimeException("someting is gonna wrong: two equals flush combinations");
    }
}
