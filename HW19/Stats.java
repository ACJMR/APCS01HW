//Colin Hosking (+ George Liang = Team String cheese = "yum")
//APCS1 pd08
//HW19 -- gcd 3 ways
//2017-10-19

public class Stats{

    public static int mean(int a, int b){
    	int sum = a + b;
	return sum/2; //Do not need typecaster here because sum will always be an int and an int/int = int in java
    }

    public static double mean(double a, double b){
	double sum = a + b;
	return sum/2; //Do not need typecaster, no loss of precision

    }

    public static int max(int a, int b){ 
	if (a > b){
	    return a;} //Do not need typecaster, no loss of precision
	return b; 
    }

    public static double max(double a, double b){
	if (a > b){
	    return a;} //Do not need typecaster, no loss of precision
	return b;
    }

    public static int geoMean(int a, int b){
	int product = a * b; //either both + or both -, product cannot be -
	return (int) Math.sqrt(product); //MUST include an int typecaster: according to the API, Math.sqrt returns a double. Precision is lost when taking the sqrt of an int
    }

    public static double geoMean(double a, double b){
	double product = a * b; //either both + or both -, product cannot be -
	return Math.sqrt(product); // Do not need typecaster, no loss of precision. Math.sqrt returns a double, and so does our method
    }
    

    public static int max(int a, int b, int c){
	int biggestSoFar = max(a,b); //Use previous method to test max 2 ints at a time
	return max(biggestSoFar,c); // No loss of precision, no typecaster
    }

    public static double max(double a, double b, double c){
	double biggestSoFar = max(a,b); //Use previous method to test max 2 doubles at a time
	return max(biggestSoFar,c); //No loss of precision, no typecaster
    }

    public static int geoMean(int a, int b, int c){
	int product = a * b * c; //Product CAN be negative
	return (int) Math.cbrt(product); //MUST include an int typecaster: according to the API, Math.cbrt returns a double. Precision is lost when taking the cbrt of an int
    }

    public static double geoMean(double a, double b, double c){
	double product = a * b * c; //Product CAN be negative
	return Math.cbrt(product); //Do not need typecaster, no loss of precision. Math.cbrt returns a double, and so does our method
    }




 /**
       Euclid's Algorithm Explained:
   
      0. If the one # is a divisor of the other (a % b == 0), return the larger #.
      1. Take your two #s and find the largest and smallest.
      2. Subtract the smaller # from the larger #.
      3. Your two new #s are the old smaller # and the # calculated in 2.
      4. Repeat steps 1-3 until the smaller # == 0. 
      5. Return the larger (non-0) #. 

      gcdEW performs steps 1-3 using a while loop. 
      gcdER performs steps 1-3 using recursion to loop through.
      gcd ignores Euclid's Algorithm and (unwisely) brute forces the gcd, checking every #.
     **/



    public static int min(int a, int b){  //returns smallest valued parameter
	if (a > b){
	    return b;}
	return a;}

    public static int gcdEW(int a,int b){
	int larger = max(a,b);
	int smaller = min(a,b);
	int placeHolder = 0;

	if (larger % smaller == 0){  //if smaller is a divisor of larger-----> return smaller
	    return smaller;}

	while (smaller != 0){  //exit condition: smaller == 0
	    placeHolder = larger;
	    larger = max(larger - smaller, smaller);  //larger becomes max(difference, smaller)
	    smaller = min(placeHolder - smaller, smaller); //smaller becomes min(difference, smaller)
	}

	return larger;
    }

  
  ///////////////////////////////////////////////////////////////////////////    

    public static int gcdER(int a, int b){
	int larger = max(a,b);
	int smaller = min(a,b);
	
	if (smaller != 0){
	   
	    return  gcdER(larger-smaller,smaller);  //simplifies the problem by one level: [a>b] --  gcd(a,b) == gcd(a-b,b). returns the gcd of the difference and the smaller #
 	}
	return larger;
    }

    ///////////////////////////////////////////////////////////////////////////

    public static int gcd(int a, int b){
	int larger = max(a,b);
	int smaller = min(a,b);
	int divisor = 1;
	int sofar = 1;  //biggest common divisor so far
       
        while (divisor <= smaller){ //divisor increases by 1 until EXIT CONDITION: divisor > smaller
	    if ((larger % divisor == 0) && (smaller % divisor == 0)){ //if divisor divides into larger AND smaller....
		sofar = divisor; 
		}
	    divisor += 1;}  //divisor increases
	return sofar;
    }

    /////////////////////////////////////////////////////////////////////////

    public static void main(String[] args){
	System.out.println("int mean testing: expecting 15, 2, -15, 0"); //int mean testing
	System.out.println(mean(10,20)); //tests a int mean
       	System.out.println(mean(2,3)); //tests a non-int mean
    	System.out.println(mean(-10,-20)); //tests 2 negative #s
	System.out.println(mean(-2,3)); //tests 1 negative, 1 positive #

	System.out.println("==============================================================");

	System.out.println("double mean testing: expecting 15.0, 2.5, -15.0, 0.5, ~51.1");
    
       	System.out.println(mean(10.0,20.0)); //tests a int mean 
       	System.out.println(mean(2.0,3.0)); //tests a non-int mean
	System.out.println(mean(-10.0,-20.0)); //tests 2 negative #s
	System.out.println(mean(-2.0,3.0)); //tests 1 negative, 1 positive #    }
	System.out.println(mean(10.831,91.34786572)); //tests super long decimal mean

	System.out.println("==============================================================");

	System.out.println("int x2  max testing: expecting 100, 100, -3, 100");

	System.out.println(max(100,1)); //tests both + 
	System.out.println(max(1,100)); //tests both + swap order
	System.out.println(max(-3,-100)); //tests both -
        System.out.println(max(-3,100)); //tests one + one -

	System.out.println("==============================================================");

	System.out.println("double x2 max testing: expecting 100.0, 100.3, -3.95, 100.3, 1.9");

	System.out.println(max(100.0,1.7)); //tests both + 
	System.out.println(max(1.3,100.3)); //tests both + swap order
	System.out.println(max(-3.95,-100.095)); //tests both -
        System.out.println(max(-3.6,100.3)); //tests one + one -
	System.out.println(max(1.9,1.2)); //tests both within inverval of 1

	System.out.println("==============================================================");

	System.out.println("int x2  geoMean testing: expecting 4, 4, 14");
	
	System.out.println(geoMean(8,2)); //tests both +, int geoMean result
	System.out.println(geoMean(-8,-2)); //tests both -, int geoMean result
	System.out.println(geoMean(2,100)); //tests double geoMean result

	System.out.println("==============================================================");

	System.out.println("double x2 geoMean testing: expecting ~4.5, ~4.5, 100.0");
	
	System.out.println(geoMean(8.3135,2.474)); //tests both +, double geoMean result
	System.out.println(geoMean(-8.3745,-2.458973452)); //tests both -, double geoMean result
	System.out.println(geoMean(100.0,100.0)); //tests int  geoMean result
	 
	System.out.println("==============================================================");
	
	System.out.println("gcdEW testing: expected 5, 5 ,10, 50, 30");

	System.out.println(gcdEW(20,15)); 
	System.out.println(gcdEW(15,20)); //tests larger/smaller params flipped
	System.out.println(gcdEW(30,20));
	System.out.println(gcdEW(50,50)); //tests equal params
	System.out.println(gcdEW(180,30)); //tests smaller is a divisor of larger

	System.out.println("==============================================================");       

	System.out.println("gcdER testing: expected 5, 5, 10, 50, 30");

	System.out.println(gcdER(20,15));
	System.out.println(gcdER(15,20)); //tests larger/smaller params flipped
	System.out.println(gcdER(30,20));
	System.out.println(gcdER(50,50)); //tests equal params
	System.out.println(gcdER(180,30)); //tests smaller is a divisor of larger

	System.out.println("==============================================================");

	System.out.println("gcd testing: expected 5, 5, 10, 50, 30");	

	System.out.println(gcd(20,15));
	System.out.println(gcd(15,20)); //tests larger/smaller params flipped
	System.out.println(gcd(30,20));
	System.out.println(gcd(50,50)); //tests equal params
	System.out.println(gcd(180,30)); //tests smaller is a divisor of larger


    } //ends main()
} //ends class
