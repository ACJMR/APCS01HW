//Colin Hosking CodingBat

public class Bat{

    public static String helloName(String name){ //Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
	return "Hello " + name + "!";   
  }

    public static String makeAbba(String a, String b){ //Given two strings, a and b, return the result of putting them together in the order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi".
	return a+b+b+a;
    }
 
    public static String doubleChar(String str){ //Given a string, return a string where for every char in the original, there are two chars.
	String fin = "";
	for (int x = 0; x<str.length(); x+=1){
	    fin += str.substring(x,x+1) + str.substring(x,x+1);}
	return fin;
    }

    public static int countHi(String str){ //Return the number of times that the string "hi" appears anywhere in the given string.
	int count = 0;
	for (int x = 0; x<str.length()-1; x+=1){
	    if (str.substring(x,x+2).equals("hi")){
		count += 1;
	    }
	}
	return count;
    }

    public static boolean catDog(String str){ //Return true if the string "cat" and "dog" appear the same number of times in the given string.
	int countCat = 0;
	int countDog = 0;
	for (int x = 0; x<str.length()-2; x+=1){ 
	    if (str.substring(x,x+3).equals("cat")){ //checks if substring is "cat"
		countCat += 1;}
	    else if (str.substring(x,x+3).equals("dog")){ //checks if substring is "dog"
		countDog += 1;}
	}
	if (countCat == countDog){ //if both counts equal...true
	    return true;}
	return false;
    }

    public static int countCode(String str){
	int count = 0;
	for (int x = 0; x<str.length()-3; x+=1){ //loops through str 4 characters at a time
	    if (str.substring(x,x+2).equals("co") && str.substring(x+3,x+4).equals("e")){
		//checks substring with indexes x,x+1,x+2,x+3 -- x,x+1 == "co" -- x+3 == "e"
		count += 1;} 
	}
	return count;
    }

    public static boolean endOther(String a, String b){ //Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences (in other words, the computation should not be "case sensitive"). Note: str.toLowerCase() returns the lowercase version of a string.
	String longer = "";
	String shorter = "";
	
	if (a.length()>b.length()){ //determine longer and shorter parameters
	    longer = a;
	    shorter = b;}
	else { shorter = a;
	    longer = b;}

	String endOfLong = longer.substring(longer.length()-shorter.length(),longer.length()); //substring at end of longer whose lengthe is shorter.length()
	
	if (shorter.equalsIgnoreCase(endOfLong)){ //equalsIgnoreCase is method of class String that functions the same as .equals() but ignores lettering case (Java API)
	    return true;}
	return false;


    }

    public static boolean xyzThere(String str){ //Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.
	if (str.length()<3){ //checks if the string is too short to be put throught the for loop
	    return false;}
	
	if (str.substring(0,3).equals("xyz")){ //checks if the first 3 chars are "xyz"
	    return true;}
	
	for (int x = 0; x<str.length()-3; x+=1){ //loops through str by substrings of 4 chars
	    
	    if (! str.substring(x,x+1).equals(".") && str.substring(x+1,x+4).equals("xyz")){ //checks substring len 4, first char cannot be ".", rest has to equal "xyz"
	    return true;
	    }
	}
	return false;
    }

    public static  boolean firstLast6(int[] nums) { //Given an array of ints, return true if 6 appears as either the first or last element in the array. The array will be length 1 or more.
	return nums[0] == 6 || nums[nums.length-1] == 6; 
}

    

    public static void main(String [] args){
	System.out.println("========== helloName test ==========");
	System.out.println(helloName("Bob") + " " + helloName("Alice") + " " + helloName("X"));
	
	System.out.println("========== makeAbba test ==========");
	System.out.println(makeAbba("Hi", "Bye") + " " + makeAbba("Yo", "Alice") + " " + makeAbba("What", "Up"));
	
	System.out.println("========== doubleChar test ==========");
	System.out.println(doubleChar("The") + " " + doubleChar("AAbb") + " " + doubleChar("Hi-There"));

	System.out.println("========== countHi test ==========");
	System.out.println(countHi("abc hi ho") + " " + countHi("ABChi hi") + " " + countHi("hihi"));

	System.out.println("========== catDog test ==========");
	System.out.println(catDog("catdog"));
	System.out.println(catDog("catcat"));
	System.out.println(catDog("1cat1cadodog"));

	System.out.println("========== countCode test ==========");
	System.out.println(countCode("aaacodebbb"));
	System.out.println(countCode("codexxcode"));
	System.out.println(countCode("cozexxcope"));

	System.out.println("========== endOther test ==========");
	System.out.println(endOther("Hiabc", "abc"));
	System.out.println(endOther("AbC", "HiaBc"));
	System.out.println(endOther("abc", "abXabc"));

	System.out.println("========== xyzThere test ==========");
	System.out.println(xyzThere("abcxyz"));
	System.out.println(xyzThere("abc.xyz"));
	System.out.println(xyzThere("xyz.abc"));

	int[] testArray = {1, 2, 6};
	System.out.println(firstLast6(testArray));
        testArray = {6, 1, 2, 3};
	System.out.println(firstLast6(testArray));
	System.out.println(firstLast6(testArray));
    }
}
