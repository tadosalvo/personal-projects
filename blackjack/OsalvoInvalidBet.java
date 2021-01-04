/**
 * 
 * @author 	Thaddeus Osalvo
 * Date		December 13, 2020
 * Purpose	To create a custom exception class that deals with invalid bet amounts
 * 
 */
public class OsalvoInvalidBet extends Exception{
	
	public OsalvoInvalidBet() {
		super("Invalid Bet Please try again \n");
	}
	
}