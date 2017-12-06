//Colin Hosking, Shafali Gupta, Xinye Huang
//APCS1 pd08
//HW17 -- Do I repeat myself?
//2017-10-17

public class Repeater{

    public static String fenceW(int numPosts){
	String fen = "|";  //will skip while loop and return "|" if numPosts == num == 1
	int num = 1;

	while (num < numPosts){  //exit condition: num = numPosts 
	    fen += "--|";
	    num += 1;}
	
        return fen; 
    }

    public static String fenceR(int numPosts){
	if (numPosts == 1){
	    return "|";}        //Base case: numPosts = 1

	return fenceR(numPosts - 1) + "--|";  //Recursive case: fenceR(numPosts - 1) simplifies the problem by 1 post
    }


    public static void main(String [] args){


	System.out.println("============fenceW============  expected: 1,4,6 posts");

	System.out.println(fenceW(1));
	System.out.println(fenceW(4));
	System.out.println(fenceW(6));

	System.out.println("============fenceR============  expected: 1,4,6 posts");

	System.out.println(fenceR(1));
	System.out.println(fenceR(4));
	System.out.println(fenceR(6));
    
    }//ends main
}//ends Repeater