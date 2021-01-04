/**
 * 
 * @author 	Thaddeus Osalvo
 * Date		December 13, 2020
 * Purpose 	to create a card class that features a card suit and value
 *
 */
public class OsalvoCard {

	// Fields
	private int rank;
	private int suit;
	private int value;
	private static String[] ranks = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
	private static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};

	// Constructor that stores card suit and value
	OsalvoCard(int suit, int values)
	{
	    this.rank=values;
	    this.suit=suit;
	}
	
	// Method that gets card rank
	public int getRank() {
	    return rank;
	}
	
	// Method that gets card suit
	public int getSuit() {
	    return suit;
	}
	
	// Method that gets card value
	public int getValue() {
		
		switch(rank) {
		case 0:
			value = 11;
			break;
		case 1: case 2: case 3:
		case 4:	case 5:	case 6:
		case 7: case 8:
			value = rank + 1;
			break;
		case 9: case 10: case 11:
		case 12:
			value = 10;
			break;
		default:
			System.out.println("Invalid card value");
			break;
		}
		
		return value;

	}

	// Method that sets card value
	public void setValue(int set)
	{
	    value = set;
	}
	
	// toString that outputs card rank and suit
	public String toString() {
	    return ranks[rank]+" of "+suits[suit];
	}
}
