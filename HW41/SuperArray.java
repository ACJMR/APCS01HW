//Colin Hosking
//APCS1 pd08
//HW 41 -- Array of Steel
//2017-11-28
/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray
{
    
  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
      _data = new int[10];
      _size = 10;
  }


  //output SuperArray in [a,b,c] format
  public String toString(){
      String s = "";
      for(int x: _data){
	  s += x + " , "; //note: will return an extra "," at the end
      }
      return s;
  }


  //double capacity of SuperArray
  private void expand()
  {
      int[] newA = new int[_data.length * 2]; //placeholder array for the doubled array
      for (int i = 0; i<_data.length; i++){ //copies _data into the new doubled array
	  newA[i] = get(i);
      }
      _data = newA; //stores the doubled array in _data 
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
      return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
      int oldVal = _data[index]; //stores oldVal in order to later return 
      _data[index] = newVal;
      return oldVal;
  }


  //main method for testing
  public static void main( String[] args )
  {

      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );
      
      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);
 
      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      }
         /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class
