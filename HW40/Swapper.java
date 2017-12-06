//Colin Hosking
//APCS1 pd08
//HW40 -- Make it Better
//2017-11-27
/**
Version 1:

The contents of the 2D array will first be printed out in the terminal. Each item is separated by a "|" character.
The user will then be prompted to select an integer representing the "index" (or rather the item number starting from 0 and continuing through a.length) of an item they would like to swap. 
The user will then be prompted to select a second integer of an item they would like to swap.
The contents of the 2D array is printed again, with the two specified items swapped.

Version 2:

The user interface is completeley redone. Row and column headings were added to increase organization, and in addition each value's number ID is displayed in square brackets next to the value. This also aids in the usability, because the user no longer has to count out the number ID that they want to swap.
I also added a feature that echoes back the values (and their IDs) the user decided to swap. 

 **/

import cs1.Keyboard;

public class Swapper{

    private String[][]a = new String[3][4];  //creates 2D array: 3 rows, 4 cols

    public void printOut(){  //loops through each item in each row and prints out, sepparated by a "|"
	int rowNum = 0;
	int ID = 0;
	System.out.println();
	System.out.println();

	System.out.println("Column:       0           1           2           3");
	
	for(String[] p: a){
	    System.out.print("Row " + rowNum + ":  | ");
	    for (String q: p){
		System.out.print("[" + ID + "] " +  q + "  | ");
		ID += 1;
	    }
	    rowNum += 1;
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

    public String valueFromID(int ID){ //given the ID, return the value in a
       return a[ID/a[0].length][ID%a[0].length];

    }

    public static void main(String[] args){

	Swapper test = new Swapper();
	//test.printOut(); //should print out 3x4 grid of nulls

	//System.out.println(Keyboard.readInt()); //tests readInt(), should return whatever int user inputs

	test.populate();
	test.printOut(); //should print out a grid of strings containing random numbers

   	System.out.println();
	System.out.println("Please input the item number (0-11) you would like to swap -- Item numbers denoted by square brackets []");
	System.out.println();
	
	int item1 = Keyboard.readInt(); //stores user input

    	String s1 = "["+item1+"] " + test.valueFromID(item1);

	System.out.println();
	System.out.println("Please input the second item number (0-11) you would like to swap -- Item numbers denoted by square brackets []");
       	System.out.println();
	
        int item2 = Keyboard.readInt(); //stores user input

	String s2 = "["+item2+"] " + test.valueFromID(item2);

	test.swap(item1, item2); //swaps the specified items

	test.printOut(); //prints out the "swapped" array
	
	System.out.println();
	System.out.println("Swapped: "+ s1  +" and "+ s2);
    }

    
}
