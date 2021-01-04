/**
 * 
 * @author	Thaddeus Osalvo
 * Date		December 13, 2020
 * Purpose	To demonstrate the blackjack program
 * 			Handles play again loop, quit game loop, and output file
 * 
 */
import java.io.*;
import java.util.Scanner;
public class OsalvoBlackjackDemo extends OsalvoGame {

	public static void main(String[] args) throws IOException, OsalvoInvalidBet {
		
		// Creating the necessary objects
		OsalvoGame game = new OsalvoGame();
		PrintWriter outputFile = new PrintWriter("BlackjackCredits.txt");
		
		// Running methods under game class
		game.displayIntro();

		while (quitGame == false) {
			playAgain = true;
			while(playAgain == true) {
				game.displayAmount();
				if (playAgain == false) {
					break;
				}
				game.getBets();
				// starting hands
				game.startCardHand();
				game.startDealerHand();
				game.checkBlackjack();
				if (playAgain == false) {
					break;
				}
				// asks user to hit or stand
				game.hitStand();
				if (playAgain == false) {
					break;
				}
				game.checkBlackjack();
				if (playAgain == false) {
					break;
				}
				// dealer draw
				game.dealerDraw();
				if (playAgain == false) {
					break;
				}
				// determining winner
				game.winOrLose();
				if (playAgain == false) {
					break;
				}				
				}
			if (quitGame == true) {
				break;
			}
			game.playAgain();
			game.resetGame();
			}
		game.closeGame();
		game.printCredits();
		
		// Controls what is printed in the BlackjackCredits txt file
		outputFile.println("Blackjack 1.0");
		outputFile.println();
		outputFile.println(game.playerGetName() + "'s "+ "Total Winnings:");
		outputFile.println(game.playerGetBank() + " credits");
		outputFile.close();
		} 
}