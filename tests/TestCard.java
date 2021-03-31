package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cardGameBasic.Card;

class TestCard {
	//deck containing 52 valid cards in order and 2 Jokers starting from
	Card[] orderedDeck;
	Card cardTest;
	protected void setUp(){
		cardTest = new Card("Ace", "Spade");
		
		String []ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"Jack", "Queen", "King"};
		String []suits = {"Heart", "Diamond", "Spade","Club"};
		orderedDeck = new Card[54];
		for(int i = 0; i < 52; i++) {
			Card card = new Card(ranks[i % 13], suits[i % 4]);
			orderedDeck[i] = card; 
		}
		orderedDeck[52] = new Card("Joker", "Joker");
		orderedDeck[52] = new Card("Joker", "Joker");
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	//test constructor
	public void testConstructorInvalidArguments() {

		boolean correct = true;
		try {
			//null arguments 
			Card card = new Card(null, null);
			card = new Card(null, "Spade");
			card = new Card("Spade", null);

			//invalid ranks and suits
			card = new Card("tomatoe", "soap");
			card = new Card("Tomatoe", "Spade");
			card = new Card("King", "lol");

			//invalid order
			card = new Card("Heart", "King");
			//invalid rank for joker
			card = new Card("Joker", "Heart");
		}catch (Exception e) {
			if(! (e instanceof IllegalArgumentException) )
				correct = false;
		}

		assertTrue(correct);
	}

	public void testConstructorValidArgument() {
		boolean correct = true;

		try {
			Card card = new Card("King", "Heart");
			card = new Card("Queen", "Spade");
			card = new Card("Ace", "Club");
			card = new Card("Jack","Diamond");
			card = new Card("Joker", "Joker");
		}catch(Exception e) {
			correct = false;
		}
		assertTrue(correct);
		Card card = new Card("Queen", "Diamond");
		assertEquals("Diamond", card.getSuit());
		assertEquals("Queen", card.getRank());
	}

	public void testConstructorNumericRanks() {
		//the ranks and suits will be defined as String constants 
		Card card = new Card("1", "Heart");
		assertEquals("1", card.getRank());
		boolean correct = true;
		try {
			card = new Card("One", "Heart");
			card = new Card("11", "Heart");
		}catch(Exception e) {
			if(! (e instanceof IllegalArgumentException) )
				correct = false;
		}
		assertTrue(correct);
	}
	
	//test getters
	public void testGetters() {
		//Normal type
		cardTest = new Card("5", "Diamond");
		assertEquals("5", cardTest.getRank());
		assertEquals("Diamond", cardTest.getSuit());
		assertEquals("Normal", cardTest.getType());
		
		cardTest = new Card("10", "Heart");
		assertEquals("10", cardTest.getRank());
		assertEquals("Heart", cardTest.getSuit());
		assertEquals("Penalty", cardTest.getType());
		
		cardTest = new Card("7", "Club");
		assertEquals("7", cardTest.getRank());
		assertEquals("Club", cardTest.getSuit());
		assertEquals("Special", cardTest.getType());
	}
	
	public void testIsPenaltyCard() {
		cardTest = new Card("5", "Diamond");
		assertFalse(cardTest.isPenaltyCard() );
		cardTest = new Card("Joker", "Joker");
		assertTrue(cardTest.isPenaltyCard() );
	}

	public void testIsNormalCard() {
		cardTest = new Card("5", "Diamond");
		assertTrue(cardTest.isNormalCard() );
		cardTest = new Card("Joker", "Joker");
		assertTrue(cardTest.isNormalCard() );
	}

	public void testIsSpecialCard() {
		cardTest = new Card("5", "Diamond");
		assertFalse(cardTest.isSpecialCard() );
		cardTest = new Card("8", "Heart");
		assertTrue(cardTest.isSpecialCard() );
	}
	
	//test display
	public void testDisplay() {
		//this should be an ace of Heart
		assertEquals("This is a Ace of Heart", orderedDeck[0].toString());
	}
	
}
