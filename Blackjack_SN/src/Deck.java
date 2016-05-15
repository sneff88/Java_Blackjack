import java.util.Random;

/*
 * @ author Stephanie Neff
 *  08/03/2015
 */
/*Implementation of a deck of cards.*/

public class Deck {
	
	 /*
	    * The array of cards in the deck , where the top card is in the first index.
	    * */

	    private Card[] myCards;


	    /*
	    * The number of card currently in the deck.
	    * */
	    private int numCards;

//	    overloading; call the other constructor, defining one deck without shuffling.

	    public Deck() {
	        this(1, false);
	    }

	    /*
	    * Constructor that defines the number of decks(how many sets of 52
	    * cards are in the deck, and whether it should be shuffled.)
	    *
	    * @param numDeck - number of indivudual decks in this deck.
	    * @param shuffle - whether to shuffle the cards.
	    * */

	    public Deck(int numDecks, boolean shuffle){

	        this.numCards = numDecks * 52;
	        this.myCards = new Card[this.numCards];

//	        int card index
	        int c = 0;

//	      For each  Loop

//	        for each deck
	        for(int d = 0; d < numDecks; d++){

//	            for each suit
	            for(int s = 0; s < 4; s++){

//	                for each number
	                for(int n = 1; n <= 13; n++){

//	              add a new card to the deck
	                    this.myCards[c] = new Card(Suit.values()[s], n);
	                     c++;
	                }

	            }

	        }

	        
	        //		    shuffle is required
	        if(shuffle) {
		        this.shuffle();

		    }

	    
	    
	    }

	    /*
	    * Shuffle deck by randomly swapping pairs of cards.
	    * */
	    public void shuffle(){

//	         random number generator (rng)
	        Random rng = new Random();

//	       Temporary card
	        Card temp;

	        int j;
	        for (int i = 0; i < this.numCards; i++){

//	             get a random card j to swap i's value with
	            j = rng.nextInt(this.numCards);

//	      do swap
	            temp = this.myCards[i];
	            this.myCards[i] = this.myCards[j];
	            this.myCards[j] = temp;
	        }
	    }


	    /*
	    * Deal the next card from the top of the deck.
	    * @return the dealt card
	    * */

	    public Card dealNextCard(){

//	        get the top card
	        Card top = this.myCards[0];


	//   shift all the subsequent cards to the left by one.
	        for (int c = 1; c < this.numCards; c++){
	            this.myCards[c-1] = this.myCards[c];
	        }
//	       Cleaning/zero out
	        this.myCards[this.numCards-1] = null;

//	    decrement the number of cards in our deck.
	        this.numCards--;

	        return top;

	    }

	   /*
	   *Print the top cards in the deck.
	    * @param numToPrint; the number of cards from the top of the deck to print.
	   * */


	    public void printDeck(int numToPrint) {

	       /*
	       * reference: System.out.printf(format, args)
	       * (format) the System.out.Printf ()
	       * % - print integer width of 3
	       *
	        %d - print an integer
	       * %s - print a string
	       * \n new line
	       * */
	        for (int c = 0; c < numToPrint; c++) {
	            System.out.printf("% 3d/%d %s\n", c + 1, this.numCards,
	                    this.myCards[c].toString());
	        }

	        System.out.printf("\t\t[%d other]\n", this.numCards - numToPrint);

	}
}


	

	


	
	


