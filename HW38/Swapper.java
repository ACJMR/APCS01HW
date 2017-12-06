//Colin Hosking
//APCS1 pd08
//HW38 -- Put It Together
//2017-22-21
/**
The contents of the 2D array will first be printed out in the terminal. Each item is separated by a "|" character.
The user will then be prompted to select an integer representing the "index" (or rather the item number starting from 0 and continuing through a.length) of an item they would like to swap. 
The user will then be prompted to select a second integer of an item they would like to swap.
The contents of the 2D array is printed again, with the two specified items swapped.
 **/

import cs1.Keyboard;

public class Swapper{

    private String[][]a = new String[3][4];  //creates 2D array: 3 rows, 4 cols

    public void printOut(){  //loops through each item in each row and prints out, sepparated by a "|"
	for(String[] p: a){
	    for (String q: p){
		System.out.print(q + "  |  ");
	    }
	    System.out.println();
	}
    }
    
    public void populate(){  //loops through each item in each row and assigns it a String containing a random 4 digit #
	for (int row = 0; row < a.length; row++){
	    for (int x = 0; x < a[row].length; x++){
		a[row][x] =( (int)(1000+Math.random()*9000) + "");
	    }
	}
    }

    public void swap(int n1, int n2){ //swaps two items specified by the number of items away from the start of the array
	int row1 = n1/a[0].length;
	int col1 = n1%a[0].length;
	int row2 = n2/a[0].length;
	int col2 = n2%a[0].length;

	String place = a[row1][col1];
	a[row1][col1] = a[row2][col2];
	a[row2][col2] = place;
    }

    public static void main(String[] args){

	Swapper test = new Swapper();
	//test.printOut(); //should print out 3x4 grid of nulls

	//System.out.println(Keyboard.readInt()); //tests readInt(), should return whatever int user inputs

	test.populate();
	test.printOut(); //should print out a grid of strings containing random numbers

	System.out.println("Please input the item number (0-11) you would like to swap");

	int item1 = Keyboard.readInt(); //stores user input

	System.out.println("Please input the second item number (0-11) you would like to swap");

        int item2 = Keyboard.readInt(); //stores user input

	test.swap(item1, item2); //swaps the specified items

	test.printOut(); //prints out the "swapped" array
    }

    
}
