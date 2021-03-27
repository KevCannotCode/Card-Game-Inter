package cardGameBasic;

public class InterGame {
	//?? implementation question: what would happen if players must pick a card but the deck runs out of card?
	
	Card pileCard;//this variable will hold the card on the top of the pile
	Deck gameDeck;//a deck of 52 cards. 
	
	/**
	 * The constructor initializes the default variables, no need to write it
	 */
	
	/**
	 * This method starts the game. The deck is initialized and pileCard will hold the 
	 * initial card of the game
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
	 * displays "player {given player} played a {c} " 
	 * @throws
	 * {@link IllegalStateException}: this error occurs if pileCard was null 
	 * {@link IllegalArgumentException}: this error will occur if c is either null
	 * or an invalid card 
	 */
	public void playCard(Card c) {
		
	}
	
	/**
	 * This method will be called when a player needs to pick a new card from the unused card pile. 
	 * The deck will deal one card to a player. 
	 * @return
	 */
	public Card pickCard() {
		
	}
}
