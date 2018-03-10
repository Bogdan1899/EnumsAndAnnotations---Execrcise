package enumsAndAnnotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        Set<String> absentCards = new HashSet<>();

        String firstPlayerName = bfr.readLine();
        String secondPlayerName = bfr.readLine();

        Player firstPlayer = new Player(firstPlayerName);
        Player secondPlayer = new Player(secondPlayerName);

        playCards(firstPlayer, absentCards, bfr);
        playCards(secondPlayer, absentCards, bfr);

        if (firstPlayer.getStrongestCard().getCardPower() > secondPlayer.getStrongestCard().getCardPower()){
            System.out.println(firstPlayer.getName() + " wins with " + firstPlayer.getStrongestCard().toString());
        } else {
            System.out.println(secondPlayer.getName() + " wins with " + secondPlayer.getStrongestCard().toString());
        }
    }

    private static void playCards(Player player, Set<String> cards, BufferedReader bfr) throws IOException {
        while (player.getCards().size() < 5){
            String card = bfr.readLine();
            CardSuit cardSuit;
            CardRanks cardRank;

            try {
                cardSuit = CardSuit.valueOf(card.split(" ")[2]);
                cardRank = CardRanks.valueOf(card.split(" ")[0]);

                if (cards.contains(card)){
                    System.out.println("Card is not in the deck.");
                } else {
                    Card playerCard = new Card(cardSuit, cardRank);
                    player.addCard(playerCard);
                    cards.add(card);
                }
            } catch (IllegalArgumentException ex){
                System.out.println("No such card exists.");
            }
        }
    }
}
