//Colin Hosking
//APCS1 pd08
//HW13 -- May ah Hahv S'maur, Please?
//2017-10-09

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
	 
     
    } //ends main()
} //ends class
