//Colin Hosking
//APCS1 pd08
//HW 16 -- Get It While You Can
//2017-10-16

public class Coin{
    private double value;
    private String upFace;
    private String name;
    private int flipCtr;
    private int headsCtr;
    private int tailsCtr;
    private double bias;
    
    public Coin(){ //sets default values for all vars
	value = 0.0;
	upFace = "heads";
	//Driver returns null for default constructor name, so that is why there is no definition
	flipCtr = 0;
	headsCtr = 0;
	tailsCtr = 0;
	bias = Math.random(); //double between 0.0 and 1.0
    }
    
    public Coin(String denomination){ //sets default values for vars using this(), and modifies name
	this();
	name = denomination;
    }

    public Coin(String denomination, String currentFace){ //sets default values/modifies name using this(denomination), and modifies upFace
	this(denomination);
	upFace = currentFace;
    }


    public String flip(){
        String result;
	if (Math.random()>bias){ //if random number is greater than bias...(towards 1.0)
	    result = "heads";
	    headsCtr = headsCtr + 1;
	    }
	else{
	    result = "tails"; //if random number is less than bias...(towards 0.0)
	    tailsCtr = tailsCtr + 1;
	}
	
	flipCtr = flipCtr + 1; 
	upFace = result;
	
	return result;
    }
    
    
    public String toString(){
	return name +  " -- " + upFace;

    }

    public boolean equals(Coin otherCoin){ //takes param other class and compares its upFace to this one
	if (upFace == otherCoin.upFace){
	    return true;
	}
	return false;
    }

    public double assignValue(){ //sets value according to name (denomination)
	if (name == "penny"){
	    value = .01;
	}
	else if(name == "nickel"){
	    value = .05;
	}
	else if(name == "dime"){
	    value = .1;
	}
	else if(name == "quarter"){
	    value = .25;
	}
	else if(name == "half dollar"){
	    value = .5;
	}
	else if(name == "dollar"){
	    value = 1.0;
	}
	return value;
    }

    public int getHeads(){ //headsCtr accessor
	return headsCtr;}

    public int getTails(){ //tailsCtr accessor
	return tailsCtr;}

    public void coinReset(){ //resets coin flip vars
	flipCtr = 0;
	headsCtr = 0;
	tailsCtr = 0;}

    public static void main(String [] args){

	Coin colin  = new Coin(); //tests default constructor
	System.out.println(colin); //tests toString() [expected to print null -- heads

	System.out.println("============");
	
	Coin jack = new Coin("nickel"); //tests overloaded constructor #1
	System.out.println(jack); //[expected to print nickel -- heads]
	System.out.println(jack.assignValue()); //tests assignValue() method [expected to print .05]
	
      	System.out.println("============");

	Coin batman = new Coin("quarter", "tails"); //tests overloaded constructor #2
	System.out.println(batman); //[expected to print quarter -- tails

      	System.out.println("============");	

	System.out.println("\nAfter flippling..."); //tests flip()
	colin.flip();
	jack.flip();
	batman.flip();
	
	System.out.println("colin: " + colin); 
	System.out.println("jack: " + jack);
	System.out.println("batman: " + batman);

      	System.out.println("============");	

	if (colin.equals(jack)){ //tests equals() [see flip() results for face values]
	    System.out.println("Match");}
	else{
	    System.out.println("No match");}

    }//end main
}//end class