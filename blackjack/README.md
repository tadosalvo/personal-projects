Blackjack 1.0 User Manual
by Thaddeus Osalvo

How to setup:
1.	Download the following java files
  a.	OsalvoBlackjackDemo.java
  b.	OsalvoCard.java
  c.	OsalvoDealer.java
  d.	OsalvoDeck.java
  e.	OsalvoGame.java
  f.	OsalvoHand.java
  g.	OsalvoInvalidBet.java
  h.	OsalvoPlayer.java
2.	Download and run your chosen Java IDE
  a.	Free Option – Eclipse
3.	Save files in the same package
4.	Run the OsalvoBlackJackDemo file

Features:
Ability to set your own username
Betting feature
Ability to print your credit winnings

How to play:
1.	Set up username when prompted
  a.	If no username is prompted the default “player1” is used
  b.	Characters, Numbers, and Symbols are all valid inputs
2.	You start out with 1000 Credits
3.	Place your desired bet
  a.	Bets are restricted to number characters only
  i.	Invalid character inputs are handled by the InputMismatchException
  b.	Bets are restricted to how much you currently have in players bank
  i.	Exceptions are thrown to OsalvoInvalidBet class and requires player to input a valid bet
4.	Two cards and drawn and shown
5.	Dealer card is drawn and shown
6.	Choose whether to hit or stand
  a.	You may either type h, H, hit, or Hit.
  i.	Program will only read the first character you input
  b.	Other inputs will count as standing
7.	Goal is to get closest to 21 vs the dealer
8.	Once you stand the dealer will draw until they either bust or obtain a closer value
9.	The cycle ends and the credits are either pushed, won, lost, on your bank
10.	Program will ask if you would like to play again
  a.	You may either type y, Y, Yes, or yes.
  i.	Program will only read the first character you input
  b.	Other inputs will count as no
11.	Play as your heart desires
12.	Once you’re ready to collect your winnings type “no” when prompted if you would like to play again
13.	Winnings are then printed into “BlackjackCredits.txt” file

