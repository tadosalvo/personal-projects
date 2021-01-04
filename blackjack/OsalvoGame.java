/**
 * 
 * @author 	Thaddeus Osalvo
 * Date		December 13, 2020
 * Purpose	To create a game class that handles the games functions
 * 
 */
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
public class OsalvoGame {
	
	// Local Fields
	private OsalvoPlayer player = new OsalvoPlayer();
	private OsalvoDealer dealer = new OsalvoDealer();
	
	private int playerValue;
	private int dealerValue;
	
	private int bet = 0;
	
	private ArrayList<OsalvoCard> playerHand = new ArrayList<>();
	private ArrayList<OsalvoCard> dealerHand = new ArrayList<>();
	
	private OsalvoDeck deck = new OsalvoDeck();
	private OsalvoHand hand = new OsalvoHand();
	private String name;
	private int credits = 1000;
	
	
	// Public Fields
	public static boolean playAgain = true; // public to access it under the demo class
	public static boolean quitGame = false;
	

	Scanner keyboard = new Scanner(System.in);
	
	// Method that outputs introduction and asks for a username
	public void displayIntro() {
		System.out.println("Welcome to Blackjack 1.0! \n");
		System.out.println("Please enter a username:");
		name = keyboard.nextLine();
		if (name.length() == 0) {
			name = player.setName();
		} else {
			name = player.setName(name);
		}
		player.setBank(credits);
		System.out.println("\n");
		System.out.println("Welcome " + name + ".");
		System.out.println("\n");
	}
	
	
	// Method that displays starting amount
	public void displayAmount() {
		if (player.getBank() <= 0) {
			System.out.println("Sorry insufficient funds!");
			playAgain = false;
			quitGame = true;
		}
		else {
		credits = player.getBank();
		System.out.println("You have " + credits + " credits.");
		player.setBank(credits);
		System.out.println();
		}
	}
	
	// Method that asks for bet amount
	public void getBets() throws OsalvoInvalidBet {
		while(true) {
		try {
			int maxBet = player.getBank();
			
			System.out.println("Please enter your desired bet amount:");
			bet = keyboard.nextInt();
			if (bet > 0 && bet <= maxBet) {
				break;
			}
			else if (bet <= 0 || bet > maxBet) {
				throw new OsalvoInvalidBet();
			}
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid input please try again");
			System.out.println();
			if (keyboard.next().length() == 0) { // checks keyboard object for characters and continues loop
				break;
			}
		}
		catch (OsalvoInvalidBet e) {
			System.out.println(e.getMessage());
		}
		}
		player.setBet(bet);
		System.out.println("You bet " + bet + " credits.");
		System.out.println();

	}

	// Method that shows player's starting hand
	public void startCardHand() {

		deck.shuffle();
		playerHand.add(deck.drawCard());
		playerHand.add(deck.drawCard());
		System.out.println("Your current hand is:");
		System.out.println(playerHand);
		playerValue = player.calcHandValue(playerHand);
		System.out.println("Total hand value:");
		System.out.println(playerValue);
		player.setHandValue(playerValue);
		System.out.println();
	}
	
	// Method that shows dealer's starting hand
	public void startDealerHand() {
		
		System.out.println("The dealer has:");
		dealerHand.add(deck.drawCard());
		System.out.println(dealerHand);
		dealerValue = dealer.calcHandValue(dealerHand);
		System.out.println("Total dealer value:");
		System.out.println(dealerValue);
		
		dealer.setHandValue(dealerValue);
		System.out.println();
	}
	
	// Method that checks if players have a blackjack
	public void checkBlackjack() {
		if (dealer.isBlackjack()) {
			System.out.println("Dealer has a Blackjack!");
			playAgain = false;
			if(player.isBlackjack()) {
				player.resetBet();
				System.out.println( "pushes");
				playAgain = false;
			}
			else {
				player.bust();
				System.out.println(player.getName() + " lost.");
				System.out.println(player.getBank());
				playAgain = false;
			}
		} else {
			if(player.isBlackjack()) {
				player.win();
				System.out.println(player.getName() + " has a blackjack!");
				playAgain = false;

			}
			else if (playerValue > 21) {
				player.bust();
				System.out.println(player.getName() + " lost.");
				playAgain = false;
			}

			
		}
		
	}
 
	
	// Method for hitting or staying
	public void hitStand() {
		char c;
		do {
			System.out.println(player.getName());
			System.out.println("Hit or Stand?");
			String hS = keyboard.next();
			System.out.println();
			c = hS.toUpperCase().charAt(0);
			if (c == 'H') {
			playerHand.add(deck.drawCard());
			System.out.println(player.getName() + " has " + playerHand);
			playerValue = player.calcHandValue(playerHand);
			player.setHandValue(playerValue);
			System.out.println("Total hand value:");
			System.out.println(playerValue);
			System.out.println();
			if (playerValue > 21) {
				player.bust();
				System.out.println(player.getName() + " lost.");
				playAgain = false;
				break;
			}
			else if (playerValue == 21 ){
				player.blackjack();
				System.out.println(player.getName() + " has a blackjack!");
				playAgain = false;
				break;
			}
			}
		}
		while (c == 'H'); 	
	}
	
	
	// Method for displaying dealer hand
	public void displayDealerHand() {
		System.out.println("The dealer has:");
		System.out.println(dealerHand);
		System.out.println("Total dealer value:");
		System.out.println(dealerValue);
	}
	
	// Method for displaying player hand
	public void displayPlayerHand() {
		System.out.println("The player has:");
		System.out.println(playerHand);
		System.out.println("Total player value:");
		System.out.println(playerValue);
	}
	
	
	// Method for dealer drawing
	public void dealerDraw() {
		System.out.println("Dealer draws");
		
		while (dealerValue < playerValue) {
		dealerHand.add(deck.drawCard());
		dealerValue = dealer.calcHandValue(dealerHand);
		dealer.setHandValue(dealerValue);
		displayDealerHand();
		System.out.println();
		}
		if (dealerValue == playerValue) {
			System.out.println("Dealer and "+ player.getName() + " have the same card value you push.");
			System.out.println();
			player.push();
			playAgain = false;
		}
		
	}
	
	// Method for determining winner or bust
	public void winOrLose() {
		if (dealerValue == 21) {
			System.out.println("Dealer has a Blackjack!");
			System.out.println();
			player.bust();
			playAgain = false;
		}
		else if(dealerValue > 21) {
			System.out.println("Dealer bust!");
			System.out.println("Congratulations you won!");
			System.out.println();
			player.win();
			playAgain = false;
		}
		else {
			System.out.println("Dealer wins!");
			System.out.println();
			player.bust();
			playAgain = false;
		}
		if (playerValue > dealerValue) {
			System.out.println("Congratulations you won!");
			System.out.println();
			player.win();
			playAgain = false;
		}
	}
	
	// Method that handles playagain loop
	public void playAgain() {
		char p;
		System.out.println("You have " + player.getBank() + " credits");
		System.out.println();
		System.out.println("Would you like to play agian?");
		System.out.println("Yes or No?");
		String hP = keyboard.next();
		System.out.println();
		p = hP.toUpperCase().charAt(0);
		if (p == 'Y') {
			playAgain = true;
		}
		else {
			quitGame = true;
		}
	}
	
	// Method that prints closing statements
	public void closeGame() {
		System.out.println("Thank you " + player.getName() + " for playing!");
		System.out.println();
		System.out.println("Your total credits:");
		System.out.println(player.getBank());
		System.out.println();
		// Fileoutput to a txt file to display winnings
		
	}
	
	// Method that resets the player and dealesr hand
	public void resetGame() {
		playerHand.clear(); // clears hand array list
		dealerHand.clear();
	}
	
	// Method that outputs printing credits
	public void printCredits() {
		System.out.println("Printing credits...");
		System.out.println();
		System.out.println("Goodbye!");
	}
	
	// Method that gets players bank total from player class
	public int playerGetBank() {
		return player.getBank();
	}
	
	// Method that gets players name from player class
	public String playerGetName() {
		return player.getName();
	}
		
}