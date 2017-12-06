/***************************
 * interface List
 * Declares methods that will be implemented by any
 *  class wishing to adhere to this specification.
 * This interface specifies behaviors of a list of ints.
 ***************************/

public interface List
{
  // Return number of elements in the list
  int size();

  // Append an object to the end. Return true.
  boolean add( Object o );

  // Retrieve the int at index
  Object get( int index );

  // Overwrite the Object at index
  Object set( int index, Object o );

  //remove Object at index
  Object remove(int index);

  //Insert Object at index
  void add(int index, Object o);

}//end interface ListInt
