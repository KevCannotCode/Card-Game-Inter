package cardGameBasic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cardGameBasic.Card;
import cardGameBasic.Deck;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

public class Deck {
	protected Card [] deck;
	public String [] RANKS = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"Jack", "Queen", "King"};
	public String []SUITS = {"Heart", "Diamond", "Spade","Club"};
	private final int NUMBER_OF_CARDS = 54;

	public Deck() {
		this.deck = new Card[NUMBER_OF_CARDS];
	}
	/**
	After creating the Deck, this method will initialize
	the deck array with 52 unique cards
	@param
		none
	@precondition
		none
	@postcondition
	 	the deck array should have 52 unique cards 
	@throws
		none
	 **/
	public void initDeck() {
		for(int i = 0; i < 52; i++) {
			Card card = new Card(RANKS[i % 13], SUITS[i % 4]);
			deck[i] = card; 
		}
		deck[52] = new Card("Joker", "Joker");
		deck[52] = new Card("Joker", "Joker");
	}

	/**
	Given an empty or filled deck, this method will clear the content 
	of the deck array 
	@param
		none
	@precondition
		none
	@postcondition
	 	the deck array should have 0 card 
	@throws
		none
	 **/
	public void clearDeck() {
		deck = new Card[NUMBER_OF_CARDS];
	}

	/**
	This method will shuffle the deck 
	@param
		none
	@precondition
		none
	@postcondition
	 	the cards in the deck should be shuffled
	@throws
		none
	 **/
	public void shuffleDeck() {
		// apply 100 random card swaps within deck
		//100 random transpositions of cards
		for(int i = 0; i < 100; i++) {
			int x = (int) (Math.random()*(51 - 0 + 1)+0 );
			int y = (int) (Math.random()*(51 - 0 + 1)+0 );
			//swap
			Card temp = deck[y];
			deck[y] = deck[x];
			deck[x] = temp;
		}
	}
		/**
	Given a deck with at least one card, this method will remove
	a random card from the deck
	@param
		none
	@precondition
		the deck cannot be empty
	@postcondition
	 	the deck should have 52 unique cards in the deck array
	@throws
		IllegalStateException: this exception should be thrown if the deck is empty 
		 **/
		public Card dealCard() {
			Card card = null;			
			int index = 0;
			do
			{
			index= (int)(Math.random()*52);
			card = deck[index];
			}while (deck[index] == null);
				
			deck[index] = null;
			
			return card;
		}

		public boolean isEmptyDeck() {
			for (int i = 0; i < this.deck.length; ++i)
			 {
				 if (this.deck[i] != null)
					 return false;
			 }
			 
			 return true;
		}
	}

class TestDeckInteral{
		Card [] cardArray;
		Deck deckObj;
		@BeforeEach
		protected void setUp() {
			deckObj = new Deck();
			String [] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
					"Jack", "Queen", "King"};
			String []suits = {"Heart", "Diamond", "Spade","Club"};
			cardArray = new Card[54];
			for(int i = 0; i < 52; i++) {
				Card card = new Card(ranks[i % 13], suits[i % 4]);
				cardArray[i] = card; 
			}
			cardArray[52] = new Card("Joker", "Joker");
			cardArray[52] = new Card("Joker", "Joker");
		}

		@Test
		void test() {
			fail("Not yet implemented");
		}

		public void testInitDeck() {
			//check that the deck array is of length 54
			assertEquals(deckObj.deck.length, cardArray.length);
			//check that all the 54 elements are actually cards
			boolean correct = true;
			for(int i = 0; i < deckObj.deck.length; i++) {
				if(!(deckObj.deck[i] instanceof Card) )
					correct = false;
			}
			//when the deck is initialized it should be ordered like arrayCard
			for(int i = 0; i < 54; i++) {
				assertTrue(deckObj.deck[i].equals(cardArray[i]) );
			}
		}

		public void shuffleDeck() {
			//the deck is randomized so deck should not be ordered like arrayCard
			for(int i = 0; i < 54; i++) {
				assertFalse(deckObj.deck[i].equals(cardArray[i]) );
			}
		}

		public void testClearDeck() {
			//all the spots must be null
			deckObj.clearDeck();
			for(int i = 0; i < deckObj.deck.length; i++) {
				assertNull(deckObj.deck[i]);
			}
		}

		public void testIsEmpty() {
			deckObj.initDeck();
			assertFalse(deckObj.isEmptyDeck());
			for(int i = 0; i < deckObj.deck.length; i++) {
				assertNull(deckObj.deck[i]);
			}
			assertTrue(deckObj.isEmptyDeck());
		}
	}
