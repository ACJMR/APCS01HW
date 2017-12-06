// Team Cookie: George Liang, Max Millar, Colin Hosking
// APCS1 pd08
// HW10 -- Mo Money Mo Problems
// 2017-10-03 

public class BankAccount
{
  //instance variables
  private String name;
  private String passwd;
  private int pin;
  private int acctNum;
  private double balance;


  //mutators
  public String setName( String newName )
  {
    String oldName = name;
    name = newName;
    return oldName;
  }

  public String setPasswd( String newPasswd )
  {
    String oldPasswd = passwd;
    passwd = newPasswd;
    return oldPasswd;
  }

  public int setPin( int newPin )
  {
    int oldPin = pin;
    
    if (newPin < 1000 || newPin > 9998){ //If newPin is not in the accepted interval...
	System.out.println("Your PIN must be a number within the interval [1000, 9998]"); 
	    pin = 9999;
	    return oldPin;
    }

    pin = newPin;
    return oldPin;
  }

  public int setAcctNum( int newAcctNum )
  {
    int oldAcctNum = acctNum;

    if (newAcctNum < 100000000 || newAcctNum > 999999998){ //If newAcctNum is not in the accepted interval...
	System.out.println("Your Account Number must be a number within the interval [100000000, 999999998]");
	acctNum = 999999999;
	return oldAcctNum;
    }
    acctNum = newAcctNum;
    return oldAcctNum;
  }

  public double setBalance( double newBalance )
  {
    double oldBalance = balance;
    balance = newBalance;
    return oldBalance;
  }

  public void deposit( double depositAmount ) {
    balance = balance + depositAmount;
  }

    public boolean withdraw( double withdrawAmount){
	if (withdrawAmount > balance){
	    System.out.println("You do not have enough in your balance to withdraw $" + withdrawAmount + ".");
		return false;
		}
	else {balance = balance - withdrawAmount;
		return true;}
    }

    public boolean authenticate(int maybeAccNum, String maybePass){
	if (maybeAccNum == acctNum && maybePass == passwd){ //if passowrd AND account # match...
	    
	    System.out.println("Account number and password match."); 
		return true;
	}
	else{
	    System.out.println("Account number and password DO NOT match.");
	    return false;
	}
    }

  //overwritten toString() to now print out print out all bank account info
  public String toString() {
    String retStr = "\nAccount info:\n=======================";
    retStr = retStr + "\nName: " + name;
    retStr = retStr + "\nPassword: " + passwd;
    retStr = retStr + "\nPIN: " + pin;
    retStr = retStr + "\nAccount Number: " + acctNum;
    retStr = retStr + "\nBalance: " + balance;
    retStr = retStr + "\n=======================";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {
      BankAccount max = new BankAccount(); //creates bank account Max and sets its info
      max.setName("Bob");
      max.setPasswd("password");
      max.setPin(1234);
      max.setAcctNum(123456789);
      max.setBalance(123.45);
      max.deposit(1.23);
      System.out.println(max.toString()); //Tests the mutator methods

      max.setPin(1);
      System.out.println(max.toString()); //Tests what happens when PIN is too small
      max.setPin(10000000);
      System.out.println(max.toString()); //Tests what happens when PIN is too large

      max.setAcctNum(413);
      System.out.println(max.toString()); //Tests what happens when AccNum is too small
      max.setAcctNum(1000000021);
      System.out.println(max.toString()); //Tests what happens when AccNum is too large
      
      max.setBalance(100);
      max.withdraw(50); //Tests if withdraw works for valid amounts
      System.out.println(max.toString());
      max.withdraw(500); //Tests what happens when you withdraw an invalid ammount
      System.out.println(max.toString());

      max.setAcctNum(123456789);
      max.setPasswd("password");
      max.authenticate(100000000,"let me in"); //Incorrect info inputed
      max.authenticate(123456789,"password"); //Correct info inputed
  }//end main()

}//end class BankAccount
