package cardGameBasic;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
//read and copied method heades from math.hws.edu/javanotes/c5/s4.html
public class Player {
	ArrayList<Card> hand;
	//THis boolean will let us know when a player is paused
	//maybe i should write this in the game itself
	boolean pause;
	int credit = 0;
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
		String result = "";
		if(numberOfCards() == 0)
			return "empty hand\n";
		for(Card c : this.hand) 
			result+= c.rank.toString()+" "+c.suit.toString()+"\n";
		return result;
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

		Scanner scan = new Scanner(System.in);
		Card cardPlayed = null;
		int play = 8;

		while( findCard(c) && play != -1) {
			play = 8;
			while(play != 0 && play != -1) {
				System.out.println("DO you want to play (Entre 0) or pass your turn (Enter -1) ? ");
				play = scan.nextInt();
			}
			while(play != -1 && play != -2) {
				int index = -1000000;
				while(index !=-1 && (index >= numberOfCards() || index < 0) ) {
					System.out.println(viewHand()+"\nThe card to play is "+c.toString()+"\n"+"Press the index of the card you wish to play");
					index = scan.nextInt();
				}
				if(cardMatch(index, c)) {
					cardPlayed = getCard(index);
					c = cardPlayed;
					play = -2;
				}
				else {
					System.out.println("Please play a matching card");
				}
			}
		}
		System.out.println("No more card to play");
		return cardPlayed;
	}
	
	private boolean findCard(Card c) {
		
		if(this.hand.contains(c))
			return true;
		for(Card card : hand) {
			if(card.rank.equals(c.rank) || card.suit.equals(c.suit))
				return true;
		}
		return false;
	}

	private boolean cardMatch(int index, Card c) {
		return c.suit.equals(hand.get(index).suit) || c.rank.equals(hand.get(index).rank);
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
		return hand.size();
	}

	public void clearHand() {
		hand = new ArrayList<>();
	}
	/**
	 * checks if the player has any card left in his hand array
	 * @return false if there is at least one card in the hand array. Otherwise, return true
	 */
	public boolean isHandEmpty() {
		return hand.size() < 1? true : false;
	}
	//may come handy
	public Card getCard(int position) {
		Card c = null;
		if( position >= 0 && position < numberOfCards()) 
			c = this.hand.remove(position);
		return c;
	}
	// may come handy
	//sort by suit/ alphabetically
	public void sortBySuit();
	public void sortByValue();
	//this will give a card to this player
	public void drawACard(Deck d) {
		if(d == null) throw new IllegalArgumentException("The deck that was passed in the player "
				+ "drawACard method was null ");
		
		if(d.isEmptyDeck()) {
			System.out.println("The deck was empty so you owe one more card");
			this.credit++;
		}
		else {
			this.hand.add(d.dealCard());
			this.credit = credit > 0 ? credit--: credit;
		}
	}
}
