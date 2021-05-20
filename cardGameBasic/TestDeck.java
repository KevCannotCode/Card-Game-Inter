package cardGameBasic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestDeck{
	Card [] cardArray;
	Deck deckObj;
	@BeforeEach
	void setUp() {
		deckObj = new Deck();
		String [] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"Jack", "Queen", "King"};
		String []suits = {"Heart", "Diamond", "Spade","Club"};
		cardArray = new Card[54];
		for(int i = 0; i < 52; i++) {
			Card card = new Card(suits[i % 4] , ranks[i % 13]);
			cardArray[i] = card; 
		}
		cardArray[52] = new Card("Joker", "Joker");
		cardArray[53] = new Card("Joker", "Joker");
	}
	@Test
	public void testInitDeck() {
		deckObj.initDeck();
		//check that the deck array is of length 54
		assertEquals(deckObj.deck.length, cardArray.length);
		//check that all the 54 elements are actually cards
		for(int i = 0; i < deckObj.deck.length; i++) {
			assertTrue(deckObj.deck[i] instanceof Card);
		}
		//when the deck is initialized it should be ordered like arrayCard
		for(int i = 0; i < 54; i++) 
			assertTrue(deckObj.deck[i].equals(cardArray[i]) );
	}
	@Test
	public void testClearDeck() {
		deckObj.initDeck();
		deckObj.shuffleDeck();
		//all the spots must be null
		deckObj.clearDeck();
		for(int i = 0; i < deckObj.deck.length; i++) {
			assertNull(deckObj.deck[i]);
		}
	}
	@Test
	public void testIsEmpty() {
		deckObj.initDeck();
		assertFalse( deckObj.isEmptyDeck() );
		deckObj.clearDeck();
		assertTrue(deckObj.isEmptyDeck());
		for(int i = 0; i < deckObj.deck.length; i++) {
			assertNull(deckObj.deck[i]);
		}	
	}

	@Test
	public void testDealCard() {
		deckObj.initDeck();
		int count = 54;
		while( --count >= 0 ) 
			deckObj.dealCard();
		System.out.println();
		assertTrue(deckObj.isEmptyDeck() );
	}
}
