/*
Collin Hosking, Samuel Ramos, Bo Lu
APCS1 pd8
HW9: CMYM
2017-10-02
 */

//Most methods are private, since it's a bank account, and privacy should be prioritized.
public class bankAccount {

    //setting up our instance variables
    public String name;
    private String password;
    private int pin;
    public int accNumber;
    private double balance;
    public char mander;


    // Default settings for a new bank account. 
    public bankAccount(){
	name = "John Doe";
	password = "password";
	pin= 0000;
	accNumber = 000000000;
	balance=0.00;
    }
    
    public static void main(String[] args){
	// Testing the set up of a account using each of the set methods.
        bankAccount accountA = new bankAccount();
        accountA.setName("Killer Keemstar");
        accountA.setPass("WHATS UP GUYS ITS SCARCE HERE");
	accountA.setPin(6969);
	accountA.setAccNumber(696969696);
	accountA.setBalance(420000000);
	accountA.printInfo();

	//Testing set up of a account using the generalized setAll method.
	//Also trying out deposit/withdraw method to see does the change go through.
	bankAccount accountB = new bankAccount();
	accountB.setAll("Communism does not work", "Memes should be banned", 1969, 12345678, 1);
        accountB.printInfo();
	accountB.withdraw(1000);
	accountB.printInfo();
	accountB.deposit(2000);
	accountB.printInfo();
	
    }
    private void setName(String newName){
	name = newName;
    }
    private void setPass(String newPass){
	password = newPass;
    }
    private void setPin(int newPin){
	pin = newPin;
    }
    private void setAccNumber(int newAccNum){
	accNumber = newAccNum;
    }
    private void setBalance(double newBal){
	balance = newBal;
    }
    // set(thing) is for when you just want to change one thing. setAll is for when multiple changes are needed, and it would be more efficient to type them all at once
    private void setAll(String newName, String newPass, int newPin, int newAccNum, double newBal)
    {
	name = newName;
	password = newPass;
	pin = newPin;
	accNumber = newAccNum;
	balance = newBal;
    }

    // printInfo method, which is used to show all the info regarding the bank account.
    private  void printInfo(){
	System.out.println(name);
	System.out.println(password);
	System.out.println(pin);
	System.out.println(accNumber);
	System.out.println("$" + balance);
	System.out.println(" ");
    }

    // Uses double as the data type, since decimals will be required to show cents.
    private void withdraw(double amount){
	balance = balance - amount;
    }
    // Uses double as the data type, since decimals will be required to show cents.
    private void deposit(double amount){
	balance = balance + amount;
    }
}
