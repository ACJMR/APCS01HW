//Colin Hosking
//APCS1 pd08
//HW48 -- Keep Guessing
//2017-12-07
/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
        _lo = a; //low bound
	_hi = b; //high bound
	_target = (int)(a + Math.random()*b); //target winning value
	_guessCtr = 0; //guess counter
    }

    public boolean goodReadInt(int guess){ //determines if a guess is valid (must be an int between _hi and _lo)
	if (guess < _lo || guess > _hi){
	    return false;
	}
	return true;
    }

    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  
      post: 
      ==================================================*/
    public void playRec() 
    {
	System.out.println("Guess a number from " + _lo + "-" + _hi); //gets the user's first guess
	int guess = Keyboard.readInt();
	
	if (!goodReadInt(guess)){ //tests if the user's input is an int within proper range
	    System.out.println("Invalid guess: your guess must be an integer within range " + _lo + "-" + _hi);
	    playRec();
	}	
 	if (guess == _target){ //BASE CASE: if guess == target, print winning msg
	    System.out.println("Correct! It took " + _guessCtr + " guesses.");
	    return;
	}
	if (guess > _target){ //RECURSIVE CASE: guess too high, incriment guessCtr, print out msg, and call playRec()
	    _hi = guess;
	    _guessCtr ++;
	    System.out.println("Too high, try again...");
	    playRec();
	}
     	if (guess < _target){  //RECURSIVE CASE: guess too low, incriment guessCtr, print out msg, and call playRec()
	    _lo = guess;
	    _guessCtr ++;
	    System.out.println("Too low, try again...");
	    playRec();
	}
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() 
    {
	int guess = _hi+1; //guess is set to an integer known NOT to be target
	while ( guess != _target){
	    System.out.println("Guess a number from " + _lo + "-" + _hi);
	    guess = Keyboard.readInt(); 

	    if (!goodReadInt(guess)){ //tests if the user's input is an int within proper range, if it is not, skip over the rest of the while loop and prompt another guess
		System.out.println("Invalid guess: your guess must be an integer within range " + _lo + "-" + _hi);
	}
	    else{
		if (guess > _target){
		    _hi = guess;
		    _guessCtr ++;
		    if (guess != _target){
			System.out.println("Too high, try again...");
		    }
		}
		else{
		    _lo = guess;
		    _guessCtr ++;
		    if (guess != _target){
			System.out.println("Too low, try again...");
		    }
		}
	    }
	}
	System.out.println("Correct! It took " + _guessCtr + " guesses."); //winning msg
      
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() 
    {
	//use one or the other below:
	//playRec();
	playIter();
    }


    //main method to run it all
    public static void main( String[] args ) 
    {

	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class
