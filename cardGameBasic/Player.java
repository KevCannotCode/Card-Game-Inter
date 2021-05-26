package cardGameBasic;

import java.util.ArrayList;
import java.util.NoSuchElementException;
//read and copied method heades from math.hws.edu/javanotes/c5/s4.html
public class Player {
	ArrayList<Card> hand;
	//THis boolean will let us know when a player is paused
	//maybe i should write this in the game itself
	boolean pause;
	int INITIALCARDS = 5;
	/**
	 * takes in a deck and picks 5 cards from that deck
	 * @param
	 *		d - deck that will deal 5 cards to this players hand
	 *@precondition
	 *		d must have more than 5 cards
	 *		d must not be null
	 *@throws
	 *		IllegalArgumentException: this error will occur if d is null
	 */
	public Player(Deck d) {
		if(d == null) throw new IllegalArgumentException("The deck that was passed in the player "
				+ "constructor was empty");
		if(d.cardNumber() < 5) throw new IllegalArgumentException("The deck that was passed in the player"
				+ "constructor had less than 5 cards");
		hand = new ArrayList<Card>();
		int count = INITIALCARDS;
		while(count > 0) {
			hand.add(d.dealCard());
			count--;
		}
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
	the player's hand. If the player has other matching cards this method will ask 
	the player if he wishes to play another card
	@param
		c - the card the player wishes to play
	@precondition
		hand cannot be empty
		c must be a card in hand
	@postcondition
	 	the card c should be removed from the hand. This mehod either returns c or if the
	 	player played multiple cards it will return the last card he played. If the player
	 	didn't have a card to play this method returns null.
	@throws
		NoSuchElementException: this error will occur when the hand was empty
		{@link IllegalArgumentException}: this error will occur if c is not in hand
	**/
	public Card playACard(Card c) {
		if(hand.isEmpty()) throw new IllegalArgumentException("The hand was empty in PLayACard");
		if(c == null) throw new NoSuchElementException("In playACard the card argument was null");
		
		return null;
	}
	
//	/**
//	the player will call this method to play multiple cards. It will remove some cards from 
//	the player's hand.
//?????Implementation question: In the real game the order matters, but I am not sure if its necessary. 
//	@param
//		cardSequence - the array that contains a sequence of cards to play card the player wishes to play. 
//	@precondition
//		hand cannot be empty
//		c must be a card in hand
//	@postcondition
//	 	the card c should be removed from the hand 
//	@throws
//		NoSuchElementException: this error will occur when the hand was empty
//		{@link IllegalArgumentException}: this error will occur if at least one card in cardSequence is not in hand
//	**/
//	
//	public Card playACard(Card cardSequence []) {
//		return null;
//	}
	
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
	/**
	 * checks if the player has any card left in his hand array
	 * @return false if there is at least one card in the hand array. Otherwise, return true
	 */
	public boolean isHandEmpty() {
		
	}
	//may come handy
	public Card getCard(int position);
	// may come handy
	//sort by suit/ alphabetically
	public void sortBySuit();
	public void sortByValue();
	//this will give a card to this player
	public void drawACard(Deck d) {
		
	}
}
