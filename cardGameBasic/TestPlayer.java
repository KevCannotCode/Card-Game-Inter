package cardGameBasic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPlayer {
	Player p;
	final int NUMBER_OF_CARD = 5;
	@Test
	void test_construtor() {
		p = new Player(new Deck() );
		for(int i = 0; i < NUMBER_OF_CARD; i++) { 
			assertTrue(p.hand.get(i) != null);
			assertTrue(p.hand.get(i) instanceof Card);
		}
	}
	
	@Test
	void test_getCard() {
		Deck d = new Deck();
		p = new Player(d);
		//manually set the hand
		p.hand = new ArrayList<Card>();
		p.hand.add(new Card("Heart", "3") );
		p.hand.add(new Card("Heart", "4") );
		p.hand.add(new Card("Heart", "5") );
		p.hand.add(new Card("Heart", "6") );
		p.hand.add(new Card("Heart", "7") );
		
		Card c = p.hand.get(0);
		assertEquals(c, p.getCard(0));
	}
	@Test
	void test_play_the_same_card() {
		Deck d = new Deck();
		p = new Player(d);
		//manually set the hand
		p.hand = new ArrayList<Card>();
		p.hand.add(new Card("Heart", "3") );
		p.hand.add(new Card("Club", "4") );
		p.hand.add(new Card("Club", "5") );
		p.hand.add(new Card("Club", "6") );
		p.hand.add(new Card("Club", "7") );
		//set the card on top of the pile
		Card c = new Card("Heart", "3");
		assertEquals(p.hand.get(0), p.playACard(c));
		//checking the cards that were removed
		assertFalse(p.hand.contains(new Card("Heart", "3")) );
		assertEquals(4 , p.hand.size());
		assertEquals(new Card("Club", "4") , p.hand.get(0) );
		assertEquals(new Card("Club", "5") , p.hand.get(1) );
		assertEquals(new Card("Club", "6") , p.hand.get(2) );
		assertEquals(new Card("Club", "7") , p.hand.get(3) );
	}
	@Test
	void test_play_1card_of_same_suit() {
		Deck d = new Deck();
		p = new Player(d);
		//manually set the hand
		p.hand = new ArrayList<Card>();
		p.hand.add(new Card("Heart", "8") );
		p.hand.add(new Card("Heart", "4") );
		p.hand.add(new Card("Heart", "5") );
		p.hand.add(new Card("Heart", "6") );
		p.hand.add(new Card("Spade", "7") );
		//set the card on top of the pile
		Card c = new Card("Spade", "3");
		assertEquals(p.hand.get(4), p.playACard(c));
		//checking the cards that were removed
		assertEquals(4, p.hand.size());
		assertFalse(p.hand.contains(new Card("Spade", "7")) );
		assertEquals(new Card("Heart", "8") , p.hand.get(0) );
		assertEquals(new Card("Heart", "4") , p.hand.get(1) );
		assertEquals(new Card("Heart", "5") , p.hand.get(2) );
		assertEquals(new Card("Heart", "6") , p.hand.get(3) );
	}
	@Test
	void test_play_1card_of_same_rank() {
		Deck d = new Deck();
		p = new Player(d);
		//manually set the hand
		p.hand = new ArrayList<Card>();
		p.hand.add(new Card("Heart", "3") );
		p.hand.add(new Card("Club", "4") );
		p.hand.add(new Card("Club", "5") );
		p.hand.add(new Card("Club", "6") );
		p.hand.add(new Card("Club", "7") );
		//set the card on top of the pile
		Card c = new Card("Spade", "3");
		assertEquals(p.hand.get(0), p.playACard(c));
		//checking the cards that were removed
		assertEquals(4, p.hand.size());
		assertFalse(p.hand.contains(new Card("Heart", "3")) );
	}
	@Test
	void test_play_multiple_cards() {
		//play a card that matches the suit of the card on the top of the pile
		//and other cards that match the first card the player played
		Deck d = new Deck();
		p = new Player(d);
		//manually set the hand
		p.hand = new ArrayList<Card>();
		p.hand.add(new Card("Heart", "9") );
		p.hand.add(new Card("Diamond", "9") );
		p.hand.add(new Card("Spade", "9") );
		p.hand.add(new Card("Club", "8") );
		p.hand.add(new Card("Heart", "4") );
		//set the card on top of the pile
		Card c = new Card("Diamond", "3");
		System.out.println("Play the 4 of hearts last");
		assertEquals(p.hand.get(4), p.playACard(c));
		//checking the cards that were removed
		assertEquals(1, p.hand.size());
		assertFalse(p.hand.contains(new Card("Diamond", "9")) );
		assertFalse(p.hand.contains(new Card("Spade", "9")) );
		assertFalse(p.hand.contains(new Card("Club", "9")) );
		assertFalse(p.hand.contains(new Card("Heart", "9")) );
		//play a card that matches the rank of the card on the top of the pile
		//and other cards that match the first card the player played
		d = new Deck();
		p = new Player(d);
		//manually set the hand
		p.hand = new ArrayList<Card>();
		p.hand.add(new Card("Heart", "9") );
		p.hand.add(new Card("Diamond", "9") );
		p.hand.add(new Card("Spade", "9") );
		p.hand.add(new Card("Club", "8") );
		p.hand.add(new Card("Heart", "4") );
		//set the card on top of the pile
		c = new Card("Club", "9");
		System.out.println("Play the 9 of Diamond first and then of Spade,"
				+ "then a Heart");
		Card c2 = p.hand.get(2) ;
		assertEquals( c2 , p.playACard(c));
		//checking the cards that were removed
		assertEquals(2, p.hand.size());
		assertFalse(p.hand.contains(new Card("Diamond", "9")) );
		assertFalse(p.hand.contains(new Card("Spade", "9")) );
		assertFalse(p.hand.contains(new Card("Heart", "9")) );
	}
	@Test
	void test_no_card_to_play() {
		//play a card that matches the rank of the card on the top of the pile
		//and other cards that match the first card the player played
		Deck d = new Deck();
		p = new Player(d);
		//manually set the hand
		p.hand = new ArrayList<Card>();
		p.hand.add(new Card("Heart", "9") );
		p.hand.add(new Card("Diamond", "9") );
		p.hand.add(new Card("Club", "9") );
		p.hand.add(new Card("Club", "8") );
		p.hand.add(new Card("Diamond", "4") );
		//set the card on top of the pile
		Card c = new Card("Spade", "3");
		System.out.println("Play the 9 of Diamond first and then of Spade,"
				+ "then a Heart");
		//playACard returns null since the player doesn't have a card to play
		assertNull(p.playACard(c));
		//draw a card since he doesn't have anything to play
		p.drawACard(d);
		//the hand should have an extra card
		assertEquals(6, p.hand.size());
		assertTrue(p.hand.contains(new Card("Heart", "9")) );
		assertTrue(p.hand.contains(new Card("Diamond", "9")) );
		assertTrue(p.hand.contains(new Card("Club", "9")) );
		assertTrue(p.hand.contains(new Card("Club", "8")) );
		assertTrue(p.hand.contains(new Card("Diamond", "4")) );
	}
	@Test
	void test_number_of_cards() {
		Deck d = new Deck();
		p = new Player(d);
		assertEquals(p.hand.size() , p.numberOfCards());
		p.drawACard(d);
		assertEquals(p.hand.size() , p.numberOfCards());
		//play all cards
		while(p.numberOfCards() > 0) {
			p.getCard(p.numberOfCards()-1);
			assertEquals(p.hand.size() , p.numberOfCards());
		}
	}
	@Test
	void test_clearHand() {
		Deck d = new Deck();
		p = new Player(d);
		p.clearHand();
		assertEquals(0, p.numberOfCards());
	}
	@Test
	void test_isEmpty() {
		Deck d = new Deck();
		p = new Player(d);
		p.clearHand();
		assertTrue(p.isHandEmpty());
	}
//	@Test
//	void test_sortByValue() {
//		Deck d = new Deck();
//		p = new Player(d);
//		//manually set the hand
//		p.hand = new ArrayList<Card>();
//		p.hand.add(new Card("Club", "10") );
//		p.hand.add(new Card("Club", "Jack") );
//		p.hand.add(new Card("Club", "King") );
//		p.hand.add(new Card("Club", "Queen") );
//		p.hand.add(new Card("Club", "Ace") );
//		
//		p.sortByValue();
//		
//		assertEquals( p.getCard(0), new Card("Club", "Ace") );
//		assertEquals( p.getCard(1), new Card("Club", "10") );
//		assertEquals( p.getCard(2), new Card("Club", "Jack") );
//		assertEquals( p.getCard(3), new Card("Club", "Queen") );
//		assertEquals( p.getCard(4), new Card("Club", "King") );
//	}
//	@Test
//	void test_sortBySuit() {
//		Deck d = new Deck();
//		p = new Player(d);
//		//manually set the hand
//		p.hand = new ArrayList<Card>();
//		p.hand.add(new Card("Club", "10") );
//		p.hand.add(new Card("Spade", "Jack") );
//		p.hand.add(new Card("Diamond", "King") );
//		p.hand.add(new Card("Heart", "Queen") );
//		p.hand.add(new Card("Club", "Ace") );
//		
//		p.sortBySuit();
//		
//		assertEquals( p.getCard(0), new Card("Club", "10") );
//		assertEquals( p.getCard(1), new Card("Club", "Ace") );
//		assertEquals( p.getCard(2), new Card("Diamond", "King") );
//		assertEquals( p.getCard(3), new Card("Heart", "Queen") );
//		assertEquals( p.getCard(4), new Card("Spade", "Jack") );
//	}
}
