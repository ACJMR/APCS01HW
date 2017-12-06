/******************************
 * class TwoDimArray
 * (skeleton)
 * practice working with 2D arrays
 ******************************/

//Colin Hosking
//APCS1 pd08
//HW34 -- A Rising Tide of Knowledge Lifts All Thinkers
//2017-11-17

public class TwoDimArray
{
    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a )
    {
	for (int row = 0; row < a.length; row++){ //loops through rows
	    for (int x = 0; x < a[row].length; x++){ //loops through row items
		System.out.print(a[row][x] + " ");
	    }
	    System.out.println(); //carriage return for next row
	}
    }


    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a )
    {
        for(int[] row: a){ //for each array in superarray a
	    for(int i: row){ //for each item in row
		System.out.print(i + " ");
	    }
	    System.out.println();
	}
    }


    //postcond: returns sum of all items in 2D int array a
    public static int sum1( int[][] a )
    {
	int total = 0;
	for(int[] row: a){ //for each array in superarray a
	    for(int i: row){ //for each item in row
		total += i;
	    }
	}
	return total;
    }


    //postcond: returns sum of all items in 2D int array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m )
    {
	int total = 0;
	
        for(int row = 0; row < m.length; row++){ //loops through rows
	    total += sumRow(row , m); //sum of each row added to total
	}
	return total;
    }


    //postcond: returns sum of all items on row r of 2D int array a
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a )
    {
	int total = 0;

	for(int x = 0; x < a[r].length; x++){ //loops through row
	    total += a[r][x]; //adds item in row to total
	}
	return total;
	
    }


    //postcond: returns sum of all items on row r of 2D int array a
    //          uses a FOREACH loop
    public static int sumRow2(int r, int[][] m)
    {
	int total = 0;
	
        for(int x: m[r]){ //loops through each item in a row
	    total += x; //adds item to total
	}
	return total;	// *** YOUR IMPLEMENTATION HERE ***
	
    }


    public static void main( String [] args )
    {

	int [][] m1 = new int[4][2]; //sum: 0
      int [][] m2 = { {2,4,6}, {3,5,7} }; //sum: 27
      int [][] m3 = { {2}, {4,6}, {1,3,5} }; //sum: 21
      print1(m1);
      print1(m2);
      print1(m3);
      System.out.println();
      print2(m1);
      print2(m2);
      print2(m3);
      
      System.out.print("testing sum1...\n");
      System.out.println("sum m1 : " + sum1(m1));
      System.out.println("sum m2 : " + sum1(m2));
      System.out.println("sum m3 : " + sum1(m3));
      
      System.out.print("testing sum2...\n");
      System.out.println("sum m1 : " + sum2(m1));
      System.out.println("sum m2 : " + sum2(m2));
      System.out.println("sum m3 : " + sum2(m3));
      	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class TwoDimArray
