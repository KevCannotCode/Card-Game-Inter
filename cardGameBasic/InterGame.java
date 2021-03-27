package GameDriver;

import cardGameBasic.Deck;

public class InterGame {
	
	Card pileCard;//this variable will hold the card on the top of the pile
	Deck gameDeck;//a deck of 52 cards 
	
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
	 * 
	 */
	public void distributeCards() {
		
	}
}
