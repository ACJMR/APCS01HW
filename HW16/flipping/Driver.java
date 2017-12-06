//Colin Hosking
//APCS1 pd08
//HW 16 -- Get It While You Can
//2017-10-16

public class Driver
{
    public static void main(String [] args){
      //Testing Coin methods
      /** 
    //build Objects from blueprint specified by class Coin

    //test default constructor

    Coin mine = new Coin();

    //test 1st overloaded constructor
    Coin yours = new Coin( "quarter" );

    //test 2nd overloaded constructor
    Coin wayne = new Coin( "dollar", "heads" );

    //test toString() methods of each Coin
    System.out.println("mine: " + mine);
    System.out.println("yours: " + yours);
    System.out.println("wayne: " + wayne);

    //test flip() method
    System.out.println("\nAfter flipping...");
    yours.flip();
    wayne.flip();
    System.out.println("yours: " + yours);
    System.out.println("wayne: " + wayne);

    //test equals() method
    if ( yours.equals(wayne) ){ 
	System.out.println( "Matchee matchee!" );}
    else{
	System.out.println( "No match. Firestarter you can not be." );}
      **/
      
      Coin colin = new Coin(); //Case A
      Coin dog = new Coin();
      
      int numHeadsA = 0;
      int numMatchesA = 0;

      while (numHeadsA < 500){ //While loop will run until numHeadsA < 500 (numHeads increases by 1 OR 2)
	  colin.flip();
	  dog.flip();
	  if (colin.equals(dog)){
	      numMatchesA = numMatchesA + 1;}
	  numHeadsA = colin.getHeads() + dog.getHeads(); //uses accessor to compute numHeads
	  }
      
      int numTailsA = colin.getTails() + dog.getTails(); //uses accessor to compute numTails
      int numFlipsA = (numHeadsA + numTailsA) / 2; //uses numHeads + numTails instead of writing another accessor for flipsCtr

      System.out.println("");
      System.out.println("============Case A: 500 Headss============");
      System.out.println("Total Heads: " + numHeadsA);
      System.out.println("Total Tails: " + numTailsA);
      System.out.println("Total Flips: " + numFlipsA);
      System.out.println("Number of Matches: " + numMatchesA);
     



      colin.coinReset(); //Case B
      dog.coinReset();

      int numMatchesB = 0; 
      
      while (numMatchesB < 1000){ //While loop will run until numMatchesB = 1000 (numMatches increases by 1)
	  colin.flip();
	  dog.flip();
	  if (colin.equals(dog)){
	      numMatchesB = numMatchesB + 1;
	  }
      }

      int numHeadsB = colin.getHeads() + dog.getHeads();
      int numTailsB = colin.getTails() + dog.getTails();
      int numFlipsB = (numHeadsB + numTailsB) / 2;
      
      System.out.println("");
      System.out.println("============Case B: 1000 Matches============");
      System.out.println("Total Heads: " + numHeadsB);
      System.out.println("Total Tails: " + numTailsB);
      System.out.println("Total Flips: " + numFlipsB);
      System.out.println("Number of Matches: " + numMatchesB);


      colin.coinReset(); //Case C
      dog.coinReset();

      int numMatchesC = 0; 
      
      while (numMatchesC < 13000 || numMatchesC % 2000 != 0){ //While loop will run until numMatches = 1400 (numMatches increases by 1)
	  colin.flip();
	  dog.flip();
	  if (colin.equals(dog)){
	      numMatchesC = numMatchesC + 1;
	  }
      }

      int numHeadsC = colin.getHeads() + dog.getHeads();
      int numTailsC = colin.getTails() + dog.getTails();
      int numFlipsC = (numHeadsC + numTailsC) / 2;
      
      System.out.println("");
      System.out.println("============Case C: 13000 Matches and Divisible By 2000============");
      System.out.println("Total Heads: " + numHeadsC);
      System.out.println("Total Tails: " + numTailsC);
      System.out.println("Total Flips: " + numFlipsC);
      System.out.println("Number of Matches: " + numMatchesC);
      
  }//end main()

}//end class
