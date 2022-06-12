import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class GameWar {
    private MyQueue<Card> handOfFirstPlayer;
    private Queue<Card> handOfSecondPlayer;

    private MyQueue<Card> buffer;

    public GameWar(){
        handOfFirstPlayer = new MyQueue<>();
        handOfSecondPlayer = new LinkedList<>();
        buffer = new MyQueue<>();
    }

    public void createNewGame(){
        List<Card> deck = new ArrayList<>();
        for(int i = 0; i < 36; i++){
            deck.add(new Card(i / 4 + 6, Card.Suit.values()[i % 4]));
        }
        Collections.shuffle(deck);
        int i = 0;
        for(Card c : deck){
            if(i % 2 == 0){
                handOfFirstPlayer.add(c);
            } else{
                handOfSecondPlayer.add(c);
            }
            i++;
        }
    }

    public boolean nextStep(){
        Card first = handOfFirstPlayer.poll();
        Card second = handOfSecondPlayer.poll();
        if(first == null){
            return true;
        }
        if(second == null){
            return true;
        }
        if(first.compareTo(second) > 0){
            handOfFirstPlayer.add(first);
            handOfFirstPlayer.add(second);
            while(!buffer.isEmpty()){
                handOfFirstPlayer.add(buffer.poll());
            }
        } else if(first.compareTo(second) < 0){
            handOfSecondPlayer.add(first);
            handOfSecondPlayer.add(second);
            while(!buffer.isEmpty()){
                handOfSecondPlayer.add(buffer.poll());
            }
        } else{
            buffer.add(first);
            buffer.add(second);
            nextStep();
        }
        return false;
    }

    public String firstToString(){
        return handOfFirstPlayer.toString();
    }

    public String secondToString(){
        return handOfSecondPlayer.toString();
    }
}
