//Colin Hosking
//APCS1 pd08
//HW20 -- For the (Lulz) Love of Strings
//2017-10-20

public class Foresrever{

    public static String fenceF(int posts){ //beginning fenceF 
	String fence = "|";
	for(int count = 1; count<posts; count += 1){  //Keeps adding posts until EXIT CONDITION:  count == posts
	    fence += "--|"; 
	}
	return fence;
    }

    public static String reverseF(String s){ //beginning reverseF
	String finale = "";

	for(int place = s.length() - 1; place >= 0; place-=1){ //EXIT CONDITION: place = -1 once all characters of s have been cycled through
	    finale += s.substring(place, place + 1); //concatenates the next character of s (read back to front) to final 
	}
	return finale;
    }

    public static String reverseR(String s){ //beginning reverseR
	if(s.length() < 2){ //Base Case: if s is 1 or 0 characters long...return s
	    return s;}
	return s.substring(s.length()-1)+reverseR(s.substring(0,s.length()-1)); //Recursive Case: last character + reverseR(rest of string) -- simplifies the problem by one character
    }

    public static void main(String [] args){

	System.out.println("fenceF testing (for loop) -- expected: 1 post, 3 posts, 5 posts");

	System.out.println(fenceF(1));
	System.out.println(fenceF(3));
	System.out.println(fenceF(5));
	
	System.out.println("reverseF testing (for loop) -- expected: 'gfedcba', '', '7654321'");

	System.out.println(reverseF("abcdefg"));
       	System.out.println(reverseF(""));
	System.out.println(reverseF("1234567"));
	
	System.out.println("reverseR testing (recursive) -- expected: 'gfedcba', '', '7654321'");

	System.out.println(reverseR("abcdefg"));
	System.out.println(reverseR(""));
	System.out.println(reverseR("1234567"));
    }
}