/***
Colin Hosking
APCS1 pd08
HW 22 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
2017-10-25

 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig
{
  //Q: How does this initialization make your life easier?
  //A: No need to make a million if statements to check if a character is a vowel, just check if it is in this string
  private static final String VOWELS = "aeiou";


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter ) 
  {
      if (w.indexOf(letter) >= 0){ //indexOf returns -1 if not in string
	  return true;}
      return false;
      
  }//end hasA()



  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter ) 
  {
      if (hasA(VOWELS,letter)){ //checks if letter is in vowel string
	  return true;
      }
      return false;
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w ) 
    {
      int count = 0;
      for (int x = 0; x < w.length(); x++){ //cycle through w and check if each character is vowel, tally
	  if (isAVowel(w.substring(x,x+1))){
	      count +=1;}
      }
      return count; 
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
    
  public static boolean hasAVowel( String w ) 
    { 
	if(countVowels(w) > 0){ //if count of vowels is >0, there is a vowel in the string
	    return true;}
	return false;
  }


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w ) 
    {
      String vowels  = "";
      for (int x = 0; x < w.length(); x++){ //cycle through w and check if each character is vowel, concatinate in vowels string
	  if (isAVowel(w.substring(x,x+1))){
	      vowels += w.substring(x,x+1);}
      }
      return vowels; 
  }


  public static void main( String[] args ) 
  {
      System.out.println("========== hasA testing ==========");

      System.out.println(hasA("abcde", "a"));
      System.out.println(hasA("abcde", "z"));
      System.out.println(hasA("abcde", ""));
      System.out.println(hasA("abcde", "e"));
      
      System.out.println("========== isAVowel testing ==========");

      System.out.println(isAVowel("e"));
      System.out.println(isAVowel("f"));
     
      System.out.println("========== countVowels testing ==========");

      System.out.println(countVowels("dad"));
      System.out.println(countVowels("aeiou"));
      System.out.println(countVowels("xxxxx"));
      System.out.println(countVowels(""));
      
      System.out.println("========== hasAVowel testing ==========");

      System.out.println(hasAVowel("dog"));
      System.out.println(hasAVowel("ddggwdy"));
      System.out.println(hasAVowel(""));
      
      System.out.println("========== allVowels testing ==========");

      System.out.println(allVowels("abcdefghi"));
      System.out.println(allVowels("mmmmmm"));
      System.out.println(allVowels(""));
      
  }//end main()

}//end class Pig
