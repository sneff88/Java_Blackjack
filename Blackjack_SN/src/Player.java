
/*
 * implementation of blackjack player.
 * 
 * @author Stephanie Neff
 * 08/06/2015
 */


public class Player {

/*
 * The Player's name
 */
	
	private String name;
	
/*
 *  The cards in the Player's current hand.
 */
	
	
	private Card[] hand = new Card[10];
	
	/*
	 * The number of the cards in the player's hand.
	 * 
	 */
	
	private int numCards;
	
	/*
	 * Player constructor.
	 * 
	 * @param aName the name of the player.
	 * 
	 */
      
	public Player(String aName){
		
		this.name = aName;
		
		// set a player's hand to empty.
		
		this.emptyHand();
	}

	
	/*
	 * Reset the player's hand to have no cards.
	 */
	
  public void emptyHand(){
	  for (int c = 0; c < 10; c++){
		 this.hand[c] = null; 
       }
	  this.numCards = 0;
  }
	  
	  /*
	   * Add a card to the Player's hand.
	   * 
	   * @param aCard the card to add
	   * @return whether the sum of the new hand is below or equal to 21.
	   */
  
	  public boolean addCard(Card aCard) {
		
		  // print error if we already have the max number of cards.
		 
		  if(this.numCards == 10){
			  System.err.printf("%s's hand already has 10 cards; " +
		  "cannot add another\n", this.name);
			  System.exit(1);
		  }
		  
		  // add new card in the next slot increment number cards counter.
		  this.hand[this.numCards] = aCard;
		  this.numCards++;
		  
		  return (this.getHandSum() <= 21);
		  
	  }
  
  
  
  
	   /*
	   * Get the sum of the cards in the player's hand.
	   * @return the sum
	   * 
	   */
	    
	    public int getHandSum(){
	  	  
	     int handSum = 0;
	     int cardNum;
	     int numAces = 0;
	    
	    // calculate each card's action to the hand sum.
	     for (int c = 0; c < this.numCards; c++){
	    	 
	    	 // get the number for the current card.
	    	 cardNum = this.hand[c].getNumber();
	    
	     if(cardNum == 1) {
	    	 numAces++;
	    	 handSum += 11;
	    	 
	     } else if (cardNum > 10){
	    	 handSum += 10;
	     } else {
	    	 handSum += cardNum;
	     }
	    	 
	  }
	     
	     // converts the  change for the Aces chance to be 1 or 11.
	     
	     while (handSum > 21 && numAces > 0){
	    	 handSum -= 10;
	    	 numAces --;
	     }
	    	 
	   return handSum;
	    
	  }
	    
	    /*
	     * Print the cards in the player's hand.
	     * 
	     * @param showFirstCard
	     */
	    
	    public void printHand(boolean showFirstCard){
	    	
	    	System.out.printf("%s 's cards:\n", this.name);
	    	for(int c = 0; c < this.numCards; c++){
	    		if (c == 0 && !showFirstCard){
	    			System.out.println("     [hidden]");
	    			}else{
	    				System.out.printf(" %s\n ", this.hand[c].toString());
	    				
	    			}
	    			
	    		}
	    	}
        }
	    
  
  
  

  



