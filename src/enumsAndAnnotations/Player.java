package enumsAndAnnotations;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private List<Card> cards;

    public Player(String name) {
        this.setName(name);
        this.setCards(new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    private void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card){
        this.getCards().add(card);
    }

    public Card getStrongestCard(){
        Card strongestCard = this.getCards().get(0);

        for (int i = 1; i < this.getCards().size(); i++) {
            if (this.getCards().get(i).getCardPower() > strongestCard.getCardPower()){
                strongestCard = this.getCards().get(i);
            }
        }

        return strongestCard;
    }
}
