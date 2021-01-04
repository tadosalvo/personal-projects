/**
 * 
 * @author 	Thaddeus Osalvo
 * Date		December 13, 2020
 * Purpose	To create a hand class to hold card values
 *
 */
import java.util.ArrayList;
public class OsalvoHand {

	// Fields
	private OsalvoCard[] hand = new OsalvoCard[12];
	private int numCards = 0;
	private int handValue = 0;

	// Method that calculates total hand value
	public static int calcHandValue(ArrayList<OsalvoCard> hand) {
		int numAce = 0;
	    OsalvoCard[] cardHand = new OsalvoCard[]{};
	    cardHand = hand.toArray(cardHand);
	    int handvalue = 0;
	    for(int i = 0; i < cardHand.length; i++) {
	        handvalue += cardHand[i].getValue();
	        if(cardHand[i].getValue() == 11) {
	            numAce++;
	        }
	        while(numAce > 0 && handvalue > 21) {
	            handvalue -= 10;
	            numAce--;
	        }
	    }
	    return handvalue;
	}
	
	// Method that draws a card
	public void drawCard(OsalvoCard card) {
		hand[numCards += 1] = card; 
	}
	
	// Method that gets hand value
	public int getHandValue() {
		return this.handValue;
	}
	
	// Method that sets hand value
	public int setHandValue(int value) {
		return this.handValue = value;
	}
	
	
	// Method that checks if hand is a blackjack
	public boolean isBlackjack() {
		if (this.handValue == 21) {
			return true;
		} 
		else {
			return false;
		}
	}
	
}
