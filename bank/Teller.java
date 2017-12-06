public class Teller{
    public static void main( String[] args){
	BankAccount max =  new BankAccount();
	max.setName("Bob");
	max.setPasswd("password");
	max.setPin(1234);
	max.setAcctNum(123456789);
	max.setBalance(123.45);
	max.deposit(1.23);
	System.out.println(max.toString()); //Tests the mutator methods
	
	System.out.println("----------------------------");
	
	max.setPin(1);
	System.out.println(max.toString()); //Tests what happens when PIN is too small
	max.setPin(10000000);
	System.out.println(max.toString()); //Tests what happens when PIN is too large

	System.out.println("----------------------------");

	max.setAcctNum(413);
	System.out.println(max.toString()); //Tests what happens when AccNum is too small
	max.setAcctNum(1000000021);
	System.out.println(max.toString()); //Tests what happens when AccNum is too large
      
	System.out.println("----------------------------");

	max.setBalance(100);
	max.withdraw(50); //Tests if withdraw works for valid amounts
	System.out.println(max.toString());
	max.withdraw(500); //Tests what happens when you withdraw an invalid ammount
	System.out.println(max.toString());

	System.out.println("----------------------------");

	max.setAcctNum(123456789);
	max.setPin(1234);
	System.out.println(max.verify(100000000,1000)); //Incorrect info inputed
	System.out.println(max.verify(123456789,1234)); //Correct info inputed


	System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||");
    	
	
	BankAccount colin = new BankAccount();
	System.out.println(colin.toString()); //Tests to see if default values are set correctly


	System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||");


	BankAccount george = new BankAccount(888832345, "mypazzword");
	System.out.println(colin.toString()); //Tests to see if AcctNum and password are set correctly


	System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||");


	BankAccount money = new BankAccount(123456789,"dontgetin",1000.01,"John Adams",1024);
	System.out.println(money.toString()); //Tests to see if all attributes are set correctly
    }
}
