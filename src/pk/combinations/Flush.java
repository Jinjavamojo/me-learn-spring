package pk.combinations;

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
        for (Card ownCard : this.cards) {


        }
    }
}
