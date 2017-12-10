//Colin Hosking
//APCS1 pd08
//HW49 -- Halving the Halves
//2017-12-08
/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
  // instance of class ArrayList, holding objects of type Comparable 
  // (ie, instances of a class that implements interface Comparable)
  private ArrayList<Comparable> _data;


  // default constructor initializes instance variable _data
  public OrderedArrayList()
  {
    _data = new ArrayList<Comparable>();    
  }


  public String toString()
  {
    return _data.toString(); 
  }


  public Comparable remove( int index )
  {	
    return _data.remove(index); 
  }


  public int size()
  { 
    return _data.size();
  }

    
  public Comparable get( int index )
  { 
    return _data.get(index); 
  }


  /***
   * add takes as input any comparable object 
   * (i.e., any object of a class implementing interface Comparable)
   * inserts newVal at the appropriate index
   * maintains ascending order of elements
   * uses a linear search to find appropriate index
   ***/
  public void add( Comparable newVal )
  { 
    for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
        //newVal < oal[p]
        _data.add( p, newVal );
        return; //Q:why not break?
	    }
    }
    _data.add( newVal ); //newVal > every item in oal, so add to end 
  }



    public int addBin(Comparable newVal){ //employs a binary search to locate the point of insertion for a new element
	if (newVal == this.get(this.size()-1)){ //extreme base case: if newVal is the last value of the array
	    return this.size()-1;
	}
	return addBin(newVal,0,this.size()-1); 
    }

    public int addBin(Comparable newVal, int lo, int hi){ //helper function that takes the range as parameters
	int avg = (int) (lo + hi)/2;
	if (newVal.compareTo(this.get(avg)) == 0){ //base case: if newVal == avg
	    return avg;
	}
	if (newVal.compareTo(this.get(avg))>0){ //if newVal > avg, avg becomes the lower bounds
	    return addBin(newVal, avg, hi);
	}
	return addBin(newVal, lo, avg); //if newVal < avg, avg becomes the upper bounds
    }

  // main method solely for testing purposes
  public static void main( String[] args )
  {
    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.add(i);
    System.out.println( Franz );

    //check for sorted-ness
    //if msg does not appear, list was sorted
    for( int i=0; i<Franz.size()-1; i++ ) {
      System.out.println("at i: " + Franz.get(i) );
      if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
        System.out.println( " *** NOT sorted *** " );
        break;
      }
    }

    System.out.println(Franz.addBin(4));
    System.out.println(Franz.addBin(14));
    System.out.println(Franz.addBin(0));
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class OrderedArrayList
