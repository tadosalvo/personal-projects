/**
 * 
 * @author 	Thaddeus Osalvo
 * Date		December 13, 2020
 * Purpose	To create a deck class that will implement a deck object
 *
 */
import java.util.Random;
import java.util.ArrayList;
public class OsalvoDeck {
	
	// Creating a deck array with card values
	private ArrayList<OsalvoCard> deck;
	
	// Constructor that prepares deck
	public OsalvoDeck() {
		deck = new ArrayList<OsalvoCard>();
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				deck.add(new OsalvoCard(i,j));
			}
		}
	}
	
	// Shuffle method that shuffles the deck of cards
	public void shuffle() {
		Random ran = new Random();
		OsalvoCard temp;
		for(int i = 0; i < 500; i++) { // iterates and switches two cards 500 times
			int i1 = ran.nextInt(deck.size()-1);
			int i2 = ran.nextInt(deck.size()-1);
			temp = deck.get(i2);
			deck.set(i2, deck.get(i1));
			deck.set(i1,  temp);
		}
	}
	
	// Method that draws card
	public OsalvoCard drawCard() {
		return deck.remove(0);
	}
	
	
}