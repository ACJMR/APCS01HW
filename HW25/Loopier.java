//Colin Hosking
//APCS1 pd08
//HW25 -- All Hallow's Eve
//2017-11-01

public class Loopier {
    
    public static void randomizeArray(int[] a, int upperBound, int lowerBound){
	for (int x = 0; x < a.length; x++){ //loops through array from left to right
	    a[x] = (int) (lowerBound + Math.random()*upperBound; //assigns random # with proper range
	}
    }

    public static String arrayString(int[] a){
	String fin = "";
	for (int x = 0; x < a.length; x++){ //loops through array from left to right
	    fin += a[x] + ","; //appends each index of array into string fin
	}
	return fin.substring(0,fin.length()-1); //returns string fin without the extra "," at the end
    }

    public static int linSearch( int[] a, int target ){
	for (int x = 0; x < a.length; x++){
	    if (a[x] == target){
		return x;
	    }
	}
	return -1;
    }

    public static int linSearchR( int[] a, int target ){
	if (a[a.length-1] == target){ //BASE CASE: last index slot is the target
	    return a.length-1;
	}
	int[] newArray = new int[a.length-1]; //makes new array identical to a BUT with one less index

	for (int x = 0; x < newArray.length; x++){ //feeds a values into newArray
	    newArray[x] = a[x];
	}
	
	return linSearchR(newArray, target); //RECURSVIE CASE: feed the array back into linSearchR but without the last index
    }

    public static int freq( int[] a, int target ){
	int count = 0;
	
	for (int x = 0; x < a.length; x++){ //loops through array left to right
	    if (a[x] == target){ //if target is spotted, add 1 to count
		count++;
	    }
	}
	return count;	
    }


    public static int nextNonTarget( int[] a, int target){ //returns the first non-target index in the array
	for (int x = 0; x < a.length; x++){
	    if (a[x] != target){
		return x;
	    }
	}
	return -1;
    }
    
    public static int freqRec( int[] a, int target ){
	if (nextNonTarget(a,target) == -1){  //base case: array is all one item which is the target, return length of array
	    return a.length;
	}

	int[] newArray = new int[a.length-1]; 
	
	for (int x = 0; x < a.length - 1; x++){ //modifies the new array to overwrite the first non-target value in a with the last value in a, and chop off the last index of a
	    if (x == nextNonTarget(a,target)){
		newArray[x] = a[a.length-1];
	    }
	    else{
		newArray[x] = a[x];
	    }
	}
	
	return freqRec(newArray, target);
    }

    public static void main( String[] args){
	int[] arrayA = new int[10]; //creates array with length 10
	
	System.out.println(arrayString(arrayA)); //should be "0,0,0,0,0,0,0,0,0,0"
	randomizeArray(arrayA); //randomizes each index in arrayA
	System.out.println(arrayString(arrayA)); //should be string full of random ints

	int[] arrayB = {0,1,2,3,4,5,6,7,8,9}; 

	System.out.println(linSearch(arrayB, 4)); //should be 4
  	System.out.println(linSearchR(arrayB, 4)); //should be 4

	int[] arrayC = {0,0,0,3,345,3,545,2,1,4};

	System.out.println(freq(arrayC, 0)); //should be 3
   	System.out.println(freqRec(arrayC, 0)); //should be 3


    } //end main
} //end class
