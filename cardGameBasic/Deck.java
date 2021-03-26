package cardGameBasic;

import java.util.NoSuchElementException;

public class Deck {
	Card [] deck;
	
	public Deck() {
		this.deck = new Card[52];
	}
	/**
	After creating the Deck, this method will initialize
	the deck array with 52 unique cards
	@param
		none
	@precondition
		none
	@postcondition
	 	the deck array should have 52 unique cards 
	@throws
		none
	**/
	public void initDeck() {
	}
	
	/**
	Given an empty or filled deck, this method will clear the content 
	of the deck array 
	@param
		none
	@precondition
		none
	@postcondition
	 	the deck array should have 0 card 
	@throws
		none
	**/
	public void clearDeck() {
		
	}
	
	/**
	This method will shuffle the deck 
	@param
		none
	@precondition
		none
	@postcondition
	 	the cards in the deck should be shuffled
	@throws
		none
	**/
	public void shuffleDeck() {
		
	}
	
	/**
	Given a deck with at least one card, this method will remove
	a random card from the deck
	@param
		none
	@precondition
		the deck cannot be empty
	@postcondition
	 	the deck should have 52 unique cards in the deck array
	@throws
		IllegalStateException: this exception should be thrown if the deck is empty 
	**/
	public Card dealCard() {
		return null;
	}
	
	public boolean isEmpty();
}
