//Colin Hosking
//APCS1 pd08
//HW 21 -- Karacomma
//2017-10-24

public class Commafier{

    public static String commafyR(int i){
	if (i<1000){
	    return Integer.toString(i);} //BASE CASE: i needs no , and returns itself

	String x = "";
	
	if (i%1000 == 0){ 
	    x = "000";}  //***if i is divisible by 1000, we need to put in three 000s not one. Thus x becomes "000" to be inserted in commadNum
	else if (i%1000 < 10){
	    x = "00" + i%1000;} //***if i%1000 is one digit, we need to change it to 00x
	else if (i%1000 < 100){ //***if i%1000 is two digits, we need to change it to 0xx
	    x = "0" + i%1000;}
	
	else{x = Integer.toString(i%1000);} //else x is the string equivalent of i%1000 or xxx
	
	String commadNum = "," + x;  //commafies last 3 digits
	int restNum =(i - Integer.parseInt(x)) / 1000; //chops off last 3 digits
	
	return commafyR(restNum) + commadNum; //Recursive case: returns the remaining# + commafied rightmost 3 digits of the #
    }

    public static String commafyF(int i){
	String num = Integer.toString(i); //converts i to a string
	int len = num.length();
	String fin = "";

	for (int x = len-1; x>=0; x--){ //loops through the string backwards
	    if ((len-x) % 3 == 0 && x!=0){ //if: x is in a position that is a multiple of 3 from BACK of string and not 0....
		fin = "," + num.substring(x,x+1) + fin; //then add comma + index 
	    }
	    else {
		fin = num.substring(x,x+1) + fin; //else: add index
	    }
	}
	return fin;
    }

    public static void main(String[] args){
	/*
      	System.out.println("========== commafyR testing ==========");
	System.out.println(commafyR(1));
	System.out.println(commafyR(10));
	System.out.println(commafyR(101));
	System.out.println(commafyR(1000));
	System.out.println(commafyR(12345));

	System.out.println("========= commafyF testing ==========");

	System.out.println(commafyF(1));
	System.out.println(commafyF(10));
	System.out.println(commafyF(101));
	System.out.println(commafyF(1000));
	System.out.println(commafyF(12345));
	*/

	for (String s: args){
	    // System.out.println(commafyF(Integer.parseInt(s)));
	    System.out.println(commafyR(Integer.parseInt(s)));
	}
	
    }
}
