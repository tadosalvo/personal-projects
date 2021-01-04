/**
 * 
 * @author 	Thaddeus Osalvo
 * Date		December 13. 2020
 * Purpose	To create a player class that is able to store array or the players hand
 * 			and stores the players bank value
 *
 */
public class OsalvoPlayer extends OsalvoHand{ // player subclass that is able to use hand public members
	
	// Fields
	private int bank = 1000;
	private int bet;
	private String name;
	
	// Constructors
	private OsalvoHand hand;

	// Constructor
	public OsalvoPlayer() {
		bank = 0;
	}
	
	
	public OsalvoPlayer(int bank) {
		this.bank = bank;
	}
	
	// Method that sets the players bank
	
	// Method that sets players bank
	public void setBank(int bank) {
		this.bank = bank;
	}
	
	// Method that gets players bank
	
	// Method that gets bank value
	public int getBank() {
		return bank;
	}
	
	// Method that subtracts bet from bank and resets players bank
	
	// Method that busts a players hand and resets bet
	public void bust() {
		bank -= bet;
		bet = 0;
		
	}
	
	
	// Method that pushes a players hand and resets bet
	public void push() {
		bet = 0;
	}
	// Method that adds bet from bank and resets players bank
	// Method that wins a players hand and resets bet
	public void win() {
		bank += bet;
		bet = 0;
	}
	
	// Method that adds 1.5x bet from bank and resets players bank
	
	// Method that blackjacks a players hand and resets bet
	public void blackjack() {
		bank += bet * 1.5;
		bet = 0;
	}
	// Method that resets bet
	
	// Method that resets a players bet
	public void resetBet() {
		bet = 0;
	}
	
	// Method that sets bet
	
	// Method that sets a players bet
	public int setBet(int bet) {
		return this.bet = bet;
	}
	
	// Method that gets bet
	
	// Method that gets bet value
	public int getBet() {
		return this.bet;
	}
	
	// Method that sets a players username
	
	// Method that sets a players username
	public String setName(String name) {
		return this.name = name;
	}
	
	// Method that sets a default player username
	
	// Method that sets a players default username
	public String setName() {
		return this.name = "player1";
	}
	
	// Method that gets a players username
	
	// Method that gets a players username
	public String getName() {
		return this.name;
	}
		
	

	
}
