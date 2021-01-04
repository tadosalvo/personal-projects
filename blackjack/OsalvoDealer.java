/**
 * 
 * @author 	Thaddeus Osalvo
 * Date		November 30, 2020
 * Purpose	To create a dealer class that inherits from the player class
 *
 */
import java.util.ArrayList;
public class OsalvoDealer extends OsalvoPlayer{ // Dealer inherits public members in the player class

	// Fields
	private ArrayList<OsalvoCard> hand;
	private int value = 0;
	private OsalvoCard[] aHand;
	
	public OsalvoDealer() {
		super();	
	}
	
	// Constructor that starts the dealer with a 2 card hand aray
	public OsalvoDealer(OsalvoDeck deck) {
		hand = new ArrayList<>();
		aHand = new OsalvoCard[] {};
		int aceCntr = 0;
		for (int i = 0; i < 2; i++) {
			hand.add(deck.drawCard());
		}
		aHand = hand.toArray(aHand);
		for(int i=0; i < aHand.length; i++) {
			value += aHand[i].getValue();
			if(aHand[i].getValue() == 11);{
				aceCntr++;
			}
			while(aceCntr>0 && value > 21) {
				value -= 10;
				aceCntr--;
			}
		}	
	}
	
	// Method that gets dealers hand value
	public int getHandValue() {
		return this.value;
	}
	
	
}
