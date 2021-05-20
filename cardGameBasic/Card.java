package cardGameBasic;

import com.sun.xml.internal.bind.v2.TODO;

public class Card {

	String suit;
	String rank;
	String type;//this will tell if a card is a normal, penalizing or special card

	//constants for ranks, suits and types
	public final String RANKS  [] = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King","Joker"};
	public final String SUITS [] = {"Heart", "Spade", "Club", "Diamond", "Joker"};
	public final String PENLTYCARDS [] = {"2","10", "Ace", "Joker"};
	public final String SPECIALCARDS [] = {"8", "7"};
	public final String NORMALCARD = "Normal";


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
		boolean found = false;
		for(String s : SUITS)
			if(s.equals(suit))
				found = true;			
		if(found == false) throw new IllegalArgumentException("invalid suit in the card constructor");
		
		found = false;
		for(String s : RANKS)
			if(s.equals(rank))
				found = true;
			
		if(found == false) throw new IllegalArgumentException("invalid rank in the card constructor");
		//TODO: assign a suit, a rank and a type to this card
		this.suit = suit;
		this.rank = rank;
		this.type = assignType(rank);

	}

	private String assignType(String rank) {
		for(String s : PENLTYCARDS)
			if(s.equals(rank))
				return "Penalty";
		for(String s : SPECIALCARDS)
			if(s.equals(rank))
				return "Special";
		return NORMALCARD;
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
		return this.type.equals("Penalty");
	}
	/**
	 * @return whether or not this card is a special card. 
	 * If this card corresponds to {@link SPECIAL_CARD} then this will return true. 
	 * Otherwise return false.
	 */
	public boolean isSpecialCard() {
		return this.type.equals("Special");
	}
	/**
	 * @return whether or not this card is a normal card. 
	 * If this card corresponds to neither {@link PENALTY_CARD} or 
	 * {@link SPECIAL_CARD} then this will return true. Otherwise return false.
	 */
	public boolean isNormalCard() {
		return this.type.equals("Normal");
	}
	
	@Override
	public String toString() {
		return this.rank+ " of "+this.suit;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this == obj)
			return true;
		if(!(obj instanceof Card) )
			return false;
		Card c = (Card) obj;
		if(this.rank.equals(c.rank) && this.suit.equals(c.suit) 
				&& this.type.equals(c.type))
			return true;
		return false;
	}
}
