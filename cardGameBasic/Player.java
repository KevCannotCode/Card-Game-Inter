package cardGameBasic;

import java.util.NoSuchElementException;
//read and copied method heades from math.hws.edu/javanotes/c5/s4.html
public class Player {
	Card [] hand;
	//??IMplementation problem:
	//should we put it in a game manager class ?
	boolean win;
	//THis boolean will let us know when a player is paused
	//maybe i should write this in the game itself
	boolean pause;
	int INITIALCARDS = 5;
	public Player() {
		hand = new Card[INITIALCARDS];
	}
	/**
	This method will display all the cards in the hand of this player
	@param
		none
	@precondition
		none
	@return
	 	this will return a string that displays all the cards in 
	 	the hand of this player. If the hand was empty, it will return 
	 	"empty hand".
	**/
	public String viewHand() {
		return "empty hand";
	}
	
	/**
	the player will call this method to play a card. It will remove a given card from 
	the player's hand
	@param
		c - the card the player wishes to play
	@precondition
		hand cannot be empty
		c must be a card in hand
	@postcondition
	 	the card c should be removed from the hand 
	@throws
		NoSuchElementException: this error will occur when the hand was empty
		{@link IllegalArgumentException}: this error will occur if c is not in hand
	**/
	public Card playACard(Card c) {
		return null;
	}
	/**
	the player will call this method to play multiple cards. It will remove some cards from 
	the player's hand.
	
	??Implementation question: In the real game the order matters, but I am not sure if its necessary. 
	@param
		cardSequence - the array that contains a sequence of cards to play card the player wishes to play. 
	@precondition
		hand cannot be empty
		c must be a card in hand
	@postcondition
	 	the card c should be removed from the hand 
	@throws
		NoSuchElementException: this error will occur when the hand was empty
		{@link IllegalArgumentException}: this error will occur if at least one card in cardSequence is not in hand
	**/
	public Card playACard(Card cardSequence []) {
		return null;
	}
	
	/**
	returns the number of cards a player has
	
	@param
		none
	@precondition
		
	@return
		 the number of cards a player has in hand
	**/
	public int numberOfCards() {
		return 0;
	}
	
	public void clearHand();
	
	//may come handy
	public int getCard(int position);
	// may come handy
	public void sortBySuit();
	public void sortByValue();
}
