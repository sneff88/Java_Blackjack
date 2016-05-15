/*
 * @author Stephanie Neff
 * 08/06/2015
 */

import java.util.Scanner;
public class GameRunner {

	public static void main(String[] args) {
		       
		Scanner sc = new Scanner(System.in);
		Deck theDeck = new Deck(1,true);
		
		// stating the player objects
		Player me = new Player("Stephanie");
		Player dealer = new Player("Dealer");
		
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		
		// print initial hands
		System.out.println("Lets' Play BlackJack:\n");
		 me.printHand(true);
		 dealer.printHand(false);
		 System.out.println("\n");
		 
		 //flags for when each player is finished hitting
		 boolean meDone = false;
		 boolean dealerDone = false;
		 String ans;
		
		 // Main loop for gameplay.
		 while (!meDone || !dealerDone){
			 //player's turn
			 if(!meDone){
				 
				 System.out.print("Hit or Stay? (Enter H or S): ");
				 ans = sc.next();
				 System.out.println();
				 
				 // if the player hits
				 if(ans.compareToIgnoreCase("H") == 0){
					 // add next card in deck and store whether player has busted. busted.
					 meDone = !me.addCard(theDeck.dealNextCard());
					 me.printHand(true);
				 }else{
					 meDone = true;
				 }
				 
			 }
		 
			 //dealer's turn
			 if(!dealerDone){
				 if(dealer.getHandSum() < 17){
					 System.out.println("The Dealer hits\n");
					 dealerDone = !dealer.addCard(theDeck.dealNextCard());
					 dealer.printHand(false);
					 }else{
						 System.out.println("The Dealer stays\n");
					      dealerDone = true;
					 }
				  }
			 
		   System.out.println();
			 
			 
		 }
		 
//		 close scanner
		 sc.close();
		 
		 //print final hands.
		 me.printHand(true);
		 dealer.printHand(true);
		 
		 int mySum = me.getHandSum();
		 int dealerSum = dealer.getHandSum();
		 
		 if (mySum > dealerSum && mySum <= 21 || dealerSum >21){
			 System.out.println("You win!");
			 
		 }else{
			 System.out.println("Dealer Wins!");
		 }
		 
		 

	}

}
