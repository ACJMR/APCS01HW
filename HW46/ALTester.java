//Colin Hosking
//APCS1 pd08
//HW46 -- Al<B> Sorted!
//2017-12-05
import java.util.ArrayList;

public class ALTester{
   
    public static void populate(ArrayList a){ //populates ArrayList a with random ints 0-100
	int value = (int)(Math.random()*100);
	for(int i = 0; i < 23; i++){
	    a.add(value);
	    value = (int)(Math.random()*100);
	}
    }

    public static boolean sorted(ArrayList a){ 
	if (a.size() < 2){ //if size is too small (1,0,etc), count as 'sorted'
	    System.out.println("sorted");
       	    return true;
	}
	
	for(int i = 1; i < a.size(); i++){ //loops through indicies comparing the current index value to the previous one
	    if (((Comparable)a.get(i)).compareTo((Comparable)a.get(i-1)) < 0){ //if current index is less than the previous one...count as not sorted
      		System.out.println("not sorted"); 
	   	return false;
	    }
	}
	System.out.println("sorted"); //otherwise the array must be sorted
	return true;	    
    }
    
    public static void main(String[] args){
	ArrayList<Comparable> banana = new ArrayList<Comparable>(); 

	System.out.println(banana.toString()); //should print out empty array
	populate(banana);
	System.out.println(banana.toString()); //should print out array with 23 random ints

        sorted(banana); //checks if array is sorted
	
    } //end main
} //end class ALTester
