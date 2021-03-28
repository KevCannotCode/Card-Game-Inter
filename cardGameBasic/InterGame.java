package cardGameBasic;

public class InterGame {
	//?? implementation question: what would happen if players must pick a card but the deck runs out of card?
	//We could keep track of the number of cards each player should have picked if the deck has enough cards.
	//The driver could have a variable that keeps track of how many cards each player should pick once the deck has enough cards.
	//we could say that the deck is big enough when it has the double of all the cards each player must pick.
	
	private int credit;//when the deck doesn't have enough cards, credit will keep track of how many cards players need to pick. 
	private int penalty;//this keeps track of the number of penalty cards played by the last player
	private Card pileCard;//this variable will hold the card on the top of the pile
	private String cardAsked;//When a player plays an 8, he can ask other players to play a card with a specific rank. 
	//cardAsked will hold the rank of the card the player asked for.
	private Deck gameDeck;//a deck of 52 cards. 
	
	/**
	 * The constructor initializes the default variables, no need to write it
	 */
	
	/**
	 * This method starts the game. The deck is initialized and pileCard will hold the 
	 * initial card of the game. if the initial card is a penalty card, then the penalty counter should
	 * increments.
	 * @param: none
	 * @precondition : none	
	 * @postcondition: The game object has a deck with 41 (since one is in the pile and 10 are distributed to players) 
	 * unique cards and a card in pileCard
	 * 
	 * notes: if we write an invariant then it will check that the deck has 41 cards
	 * 
	 */ 
	public void start() {
		//tentative code
		gameDeck.initDeck();
		pileCard = gameDeck.dealCard();
	
	}
	
	/**
	 * this method will distribute 5 cards to each players
	 * @param
	 * 		p1- Player object number 1
	 * 		p2- Player object number 2 
	 * @precondition
	 * 		p1 and p2 cannot be null
	 * 		the deck cannot be null nor empty
	 * @postcondition
	 * Each player should have 5 cards in their hand
	 * @throws:
	 * {@link IllegalStateArgumentException}: this error will occur if at least one of the 
	 * players is null 
	 * {@link IllegalStateException}: this error will occur if the deck was empty
	 */
	public void distributeCards(Player p1, Player p2) {
	}
	
	/**
	 * This method will be called when a player wants to play a card. 
	 * This method also maintains the deck filled throughout the game.
	 * When a player plays a card, this method takes the previous card and 
	 * transfers it to the deck. 
	 * 
	 * If c is a 7, the player should be prompted to play a card with a matching suit accompany the 7
	 * If c is an 8, the player should select a card that other players must play.
	 * @param
	 * 	c- the card the player wants to play. 
	 * 	The card we must put inpileCard.
	 * 	p- the player who wants to play
	 * @precondition
	 * 	c cannot be null
	 * 	pileCard cannot be null
	 * @postcontion
	 * The previous card has been successfully transfered to the deck. pileCard 
	 * is holding c. To confirm that the card was successfully played, the method 
	 * displays "player {given player} played a {c} ".
	 * if the player plays a penalty card penalty should increment.
	 * @throws
	 * {@link IllegalStateException}: this error occurs if pileCard was null 
	 * {@link IllegalArgumentException}: this error will occur if c is either null
	 * or p doesn't have c in his hand. 
	 */
	public void playCard(Card c, Player p) {
		//we could prompt the player to play a card in this method that way we don't need c.
		
		//isAnEight()
		//isASeven()
		//isAJoker()
		//isPenalty()
	}
	
	/**
	 * This method will be called when a player needs to pick a card from the deck. 
	 * The deck will deal one card and add it to the given player's hand array. 
	 * @param
	 * 	p - the player that wants to pick a card
	 * @precondition
	 * 	p cannot be null
	 * @postcondition
	 * 	if the deck had enough cards (the double of the credit variable ), the player should 
	 * 	have a new card in the his hand.
	 * 	If the deck did not have enough cards, the player will not get a new card in his hand. 
	 * 	Instead the method will print "Not enough cards in the deck" and credit will increment. 
	 * @throws
	 * * {@link IllegalArgumentException}: this error will occur if p is null
	 */
	public void pickCard(Player p) {
		
	}
	
	/**
	 * this method will tells if the next player should be penalized or not.
	 * if the initial card on the pile is a penalty card and penalty is > 0 it should affect the player who wants 
	 * to play. In other words, the player will be penalized if pileCard is a penalty card
	 * @return true if pileCard's type is a penalty card and penalty > 0
	 */
	public boolean isPenalty() {
		return false;
	}
	/**
	 * this method draws the appropriate amount of cards from the deck and pass them in the player's hand. 
	 * It will check pileCard to decide how many cards to give and decrement the variable penalty.
	 * @param
	 * 	p - Player to penalize
	 * @precondition
	 * 	pileCard must be a penalty card 
	 * 	penalty must be greater than zero
	 * @postcondition
	 * 	THe player received the right amount of cards in his hand. Penalty was successfully decremented
	 * @throws
	 * 	IllegalStateException: pileCard's type is not a penalty card or penalty <= 0
	 * 	{@link IllegalArgumentException}: p is null
	 */
	public void penalize(Player p) {
	}
	/**
	 * this method tells if the current card is an eight.
	 * @return true if pileCard's type is an eight
	 */
	public boolean isAnEight() {
		return false;
	}
	/**
	 * this method is called when pileCard has an eight. THe player must play either a joker or a card with
	 * the same rank as askedCard.
	 */
	private Card playTheCardAsked() {
	}
}
