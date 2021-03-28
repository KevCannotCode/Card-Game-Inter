package cardGameBasic;

import com.sun.xml.internal.bind.v2.TODO;

public class Card {
	
	String suit;
	String rank;
	String type;//this will tell if a card is a normal, penalizing or special card
	
	enum PENALTY_CARD{
		TWO,TEN,ACE, JOKER
	}
	enum SPECIAL_CARD{
		EIGHT, SEVEN
	}
	enum NORMAL_CARD{
		NORMAL
	}
	
	/**
	 * The constructor assigns a valid suit and rank.
	 * @param suit - a valid suit
	 * @param rank - a valid rank
	 * @precondition 
	 * suit - cannot be null nor any value other than Ace, 2,3,4,5,6,7,8,9,10,Jack,Queen,King,Joker
	 * rank - cannot be null nor anything else than diamond, heart, spade and club
	 * @postcondition suit holds a valid suit value, rank holds a valid rank value and a valid type of card. 
	 * If the card isn't a penalty nor a special card
	 * @throws 
	 * IllegalArgumentException: suit or rank is either null or not a valid rank or suit
	 */
	public Card(String suit, String rank) {
		if(suit == null || rank == null)
			throw new IllegalArgumentException("suit or rank argument was null");
		//TODO : throw an exception if suit or rank are not valid
		this.suit = suit;
		this.rank = rank;
		//TODO: assign a type to this card
		
	}
	
	public String getRank() {
		return this.rank;
	}
	
	public String getSuit() {
		return this.suit;
	}
	
	public String displayCard() {
		return "This is a "+rank+" of "+suit;
	}
	/**
	 * @return the type of this card
	 */
	public String getType() {
		return this.type;
	}
	/**
	 * @return whether or not this card is a penalty card. 
	 * If this card corresponds to {@link PENALTY_CARD} then this will return true. 
	 * Otherwise return false.
	 */
	public boolean isPenaltyCard() {
		return false;
	}
	/**
	 * @return whether or not this card is a special card. 
	 * If this card corresponds to {@link SPECIAL_CARD} then this will return true. 
	 * Otherwise return false.
	 */
	public boolean isSpecialCard() {
		return false;
	}
	/**
	 * @return whether or not this card is a normal card. 
	 * If this card corresponds to neither {@link PENALTY_CARD} or 
	 * {@link SPECIAL_CARD} then this will return true. Otherwise return false.
	 */
	public boolean isNormalCard() {
		return false;
	}
	
}
