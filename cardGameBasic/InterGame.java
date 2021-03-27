package cardGameBasic;

public class InterGame {
	//?? implementation question: what would happen if players must pick a card but the deck runs out of card?
	//We could keep track of the number of cards each player should have picked if the deck has enough cards.
	//The driver could have a variable that keeps track of how many cards each player should pick once the deck has enough cards.
	//we could say that the deck is big enough when it has the double of all the cards each player must pick.
	private int credit;
	private int penalty;//this keeps track of the number of penalty cards played by the last player
	private Card pileCard;//this variable will hold the card on the top of the pile
	private Deck gameDeck;//a deck of 52 cards. 
	
	/**
	 * The constructor initializes the default variables, no need to write it
	 */
	
	/**
	 * This method starts the game. The deck is initialized and pileCard will hold the 
	 * initial card of the game. if the initial card is a penalty card, then the penalty counter should
	 * increment.
	 * @param
	 * 		none
	 * @precondition
	 * 		none	
	 * @postcondition
	 * The game object has a deck with 52 unique cards and a card
	 * in pileCard
	 * 
	 * notes: if we write an invariant then it will check that the deck has 50 cards
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
	 * @param
	 * 		c- the card the player wants to play. 
	 * 		The card we must put inpileCard.
	 * @precondition
	 * 		c cannot be null
	 * 		pileCard cannot be null
	 * @postcontion
	 * The previous card has been successfully transfered to the deck. pileCard 
	 * is holding c. To confirm that the card was successfully played, the method 
	 * displays "player {given player} played a {c} ".
	 * if the player plays a penalty card penalty should increment.
	 * @throws
	 * {@link IllegalStateException}: this error occurs if pileCard was null 
	 * {@link IllegalArgumentException}: this error will occur if c is either null
	 * or an invalid card 
	 */
	public void playCard(Card c) {
		
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
	 * 	have a new card in the his hand. If the deck did not have enough cards, the player 
	 * 	will not get a new card in his hand and credit will increment. 
	 * @throws
	 * * {@link IllegalArgumentException}: this error will occur if p is null
	 */
	public void pickCard(Player p) {
		
	}
	
	/**
	 * this method will tells if the next player should be penalized or not.
	 * if the initial card is a penalty card it should affect the player who wants 
	 * to play.
	 * @return
	 */
	public boolean isPenalty() {
		
	}
	
	/**
	 * this method will tells if the current card is a special card or not.
	 * @return
	 */
	public boolean isSpecial() {
		
	}
	/**
	 * this method will give the appropriate amount of cards to the player. It will
	 * pileCard to check how many cards to give. 
	 * @return
	 */
	public Card penalize() {
		
	}
	/**
	 * this is a helper method for penalize. it will check the type of penalty card 
	 * and return the appropriate number of cards to give.
	 * @return
	 */
	private int checkCard() {
		
	}
}
