package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cardGameBasic.Card;

class TestCard {
	private Card cardTest;
	
	@Test
	//test constructor
	void testConstructorInvalidArguments() {

		boolean correct = true;
		try {
			//null arguments 

			//invalid order
			Card card = new Card("King", "Heart");
			//invalid rank for joker
			card = new Card("Joker", "Heart");
			
			card = new Card(null, null);
			card = new Card(null, "Spade");
			card = new Card("Spade", null);

//			//invalid ranks and suits
			card = new Card("tomatoe", "soap");
			card = new Card("Tomatoe", "Spade");
			card = new Card("King", "lol");

		}catch (Exception e) {
			if(! (e instanceof IllegalArgumentException) )
				correct = false;
		}

		assertTrue(correct);
	}

	@Test
	void testConstructorValidArgument() {
		boolean correct = true;

		try {
			Card card = new Card("Heart", "King");
			card = new Card("Spade", "Queen");
			card = new Card("Club", "Ace");
			card = new Card("Diamond","Jack");
			card = new Card("Joker", "Joker");
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			correct = false;
		}
		assertTrue(correct);
		Card card = new Card("Diamond", "Queen");
		assertEquals("Diamond", card.getSuit());
		assertEquals("Queen", card.getRank());
	}

	@Test
	void testConstructorNumericRanks() {
		//the ranks and suits will be defined as String constants 
		Card card = new Card("Heart", "2");
		assertEquals("2", card.getRank());
		boolean correct = true;
		try {
			card = new Card("Heart", "One");
			card = new Card("Heart", "11");
		}catch(Exception e) {
			if(! (e instanceof IllegalArgumentException) ) {
				correct = false;
				assertEquals("invalid suit in the card constructor", e.getMessage());
			}
		}
		assertTrue(correct);
	}
	
	@Test
	//test getters
	public void testGetters() {
		//Normal type
		cardTest = new Card("Diamond", "5");
		assertEquals("5", cardTest.getRank());
		assertEquals("Diamond", cardTest.getSuit());
		assertEquals("Normal", cardTest.getType());
		assertFalse(cardTest.getType() == null);
		
		cardTest = new Card("Heart", "10");
		assertEquals("10", cardTest.getRank());
		assertEquals("Heart", cardTest.getSuit());
		assertEquals("Penalty", cardTest.getType());
		assertFalse(cardTest.getType() == null);
		
		cardTest = new Card("Club", "7");
		assertEquals("7", cardTest.getRank());
		assertEquals("Club", cardTest.getSuit());
		assertEquals("Special", cardTest.getType());
		assertFalse(cardTest.getType() == null);
	}
	
	@Test
	void testIsPenaltyCard() {
		cardTest = new Card("Diamond", "5");
		assertFalse(cardTest.isPenaltyCard() );
		cardTest = new Card("Joker", "Joker");
		assertTrue(cardTest.isPenaltyCard() );
	}

	@Test
	void testIsNormalCard() {
		cardTest = new Card("Diamond", "5");
		assertTrue(cardTest.isNormalCard() );
	}

	@Test
	void testIsSpecialCard() {
		cardTest = new Card("Diamond", "5");
		assertFalse(cardTest.isSpecialCard() );
		cardTest = new Card("Heart", "8");
		assertTrue(cardTest.isSpecialCard() );
	}
	
	@Test
	//test display
	void testPrinting() {
		Card cardTest = new Card("Spade", "Ace");
		assertEquals("Ace of Spade", cardTest.toString());
	}
	
}
