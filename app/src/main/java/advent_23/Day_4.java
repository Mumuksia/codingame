package advent_23;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Day_4 {

    Map<Integer, Integer> numberOfCards = new HashMap<>();

    int currentCard = 0;

    public int winningCard(String path) throws URISyntaxException, IOException {
        Files.lines(Paths.get(getClass().getResource(path).toURI())).forEach(this::calculateWinningCard);

        return numberOfCards.values().stream().mapToInt(Integer::intValue).sum();
    }

    private void calculateWinningCard(String s) {
        currentCard++;
        if (numberOfCards.containsKey(currentCard)){
            numberOfCards.put(currentCard, numberOfCards.get(currentCard) + 1);
        } else {
            numberOfCards.put(currentCard, 1);
        }
        String[] cards = s.split("\\|");
        String hand = cards[0].split(":")[1].trim();
        String[] handCards = hand.split(" ");
        String[] winningCard = cards[1].split(" ");
        Map<String, Boolean> wCards = new HashMap<>();
        for (String wc : winningCard){
            if (!wc.isEmpty()){
                wCards.put(wc, true);
            }

        }
        int amount = 0;
        for (String hc : handCards){
            if (wCards.containsKey(hc)){
                amount++;
            }
        }

        for (int i=1; i<amount+1; i++){
            if (numberOfCards.containsKey(currentCard+i)){
                numberOfCards.put(currentCard+i, numberOfCards.get(currentCard+i) + numberOfCards.get(currentCard));
            } else {
                numberOfCards.put(currentCard+i, numberOfCards.get(currentCard));
            }
        }
    }

}
