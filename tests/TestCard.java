package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cardGameBasic.Card;

class TestCard {

	void setUp(){
		Card card;
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	//test constructor
	void testConstructorInvalidArguments() {
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
		}catch (Exception e) {
			if(! (e instanceof IllegalArgumentException) )
				correct = false;
		}
		
		assertTrue(correct);
	}
	
	void testConstructorValidArgument() {
		boolean correct = true;
		
		try {
			Card card = new Card("King", "Heart");
			card = new Card("Queen", "Spade");
			card = new Card("Ace", "Club");
			card = new Card("Jack","Diamond");
		}catch(Exception e) {
			correct = false;
		}
		assertTrue(correct);
		Card card = new Card("Queen", "Diamond");
		assertEquals("Diamond", card.getSuit());
		assertEquals("Queen", card.getRank());
	}
	
	void testConstructorNumericRanks() {
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
}
