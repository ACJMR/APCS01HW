//Colin Hosking
//APCS1 pd08
//HW37 -- Be More Rational
//2017-11-21
public class Rational{

    //instance vars for numerator and denominator
    private int _numer; 
    private int _denom;

    //default constructor ===> 0/1
    public Rational(){
	_numer = 0;
	_denom = 1;
    }

    //constructor
    public Rational(int p, int q){
	this(); //sets _numer and _denom to "default" values
	if (q != 0){
	    _numer = p;
	    _denom = q;
	}
	else{
	 System.out.println("Invalid: Denominator cannot equal 0. The rational number is set to 0/1.");
	}
    }

    //toString returns the Rational number
    public String toString(){
	return _numer +  " / " + _denom;
    }

    //floatValue returns approx floating point equivalent of rational number
    public double floatValue(){
	return (double) _numer / _denom;
    }

    //multiply
    public void multiply(Rational r){
	_numer = r._numer * _numer; //r's numer * old numer
	_denom = r._denom * _denom; //r's denom * old denom
    }

    //divide
    public void divide(Rational r){ //dividing is multiplying by the reciprocal
	if (r._numer != 0){
	_numer = r._denom * _numer; 
	_denom = r._numer * _denom;
	}
	else{
	    System.out.println("Divide by 0 error");
	}
    }

    //add
    public void add(Rational r){
	int dHolder = _denom; 
	_denom = _denom * r._denom; //common denominators
	_numer = dHolder * r._numer + _numer * r._denom; //cross multiplies numerators and (old) denominators, then takes sum 
    }

    //subtract
    public void subtract(Rational r){
       	int dHolder = _denom; 
	_denom = _denom * r._denom; //common denominators
	_numer = _numer * r._denom - dHolder * r._numer; //cross multiplies numerators and (old) denominators, the takes difference
    }

    //gcd
    public int gcd(){ //Euclid's gcd algorithm
	int n,d = 0;
	n = _numer;
	d = _denom;
	while (n != 0 && d != 0){ //exit condition: when either n or d == 0
	    if (n > d){ 
		n = n % d; //replaces n with n % d, then reenters loop 
	    }
	    else{
		d = d % n; //replaces d with d % n, then reenters loop
	    }
	}
	if (n == 0){
	    return d; //returns the non-zero value (n or d)
	}
	return n;		    
    }

    //reduce
    public void reduce(){ //divides _numer and _denom by gcd
	int x = gcd(); //placeholder for gcd
	_numer /= x; 
	_denom /= x; 	 
    }

    //compareTo
    public int compareTo(Rational r){ //uses floatValue() and default boolean expressions to compare Rational instances
        if (floatValue() > r.floatValue()){ //if parameter smaller ====> -1
	    return 1;
	}
	if (floatValue() < r.floatValue()){  //if parameter larger  ====> 1
	    return -1;
	}
	return 0;  //if parameter equal ====> 0
    }
    
    public static void main(String[] args){
	Rational r = new Rational(2,3); //Stores rational number 2/3
	Rational s = new Rational(1,2); //Stores rational number 1/2

	Rational x = new Rational(4,0); //tests invalid input, should set x to 0/1
	System.out.println(x.toString());

	System.out.println("r value");
	System.out.println(r.toString());
	System.out.println(r.floatValue());
	
  	System.out.println("s value");
	System.out.println(s.toString());
	System.out.println(s.floatValue());

	System.out.println("multiplying");
	r.multiply(s); //Multiplies r by s, should change r to 2/6.  s remains 1/2
	System.out.println(r.toString());
	System.out.println(s.toString());

	System.out.println("dividing");
	r.divide(s); //Divides r by s, should change r to 4/6. s remains 1/2
	System.out.println(r.toString());
	System.out.println(s.toString());

	System.out.println("dividing by 0");
        r.divide(x);

	Rational a = new Rational(1,3); //Stores rational number 1/3
	Rational b = new Rational(1,2); //Stores rational number 1/2

	System.out.println("adding");
	a.add(b); //adds b to a, should change a to 5/6 and b remains 1/2
	System.out.println(a.toString());
	System.out.println(b.toString());
	
	System.out.println("subtracting");
	a.subtract(b); //adds b to a, should change a to 4/12 and b remains 1/2
	System.out.println(a.toString());
	System.out.println(b.toString());

	System.out.println("gcd");
	System.out.println(a.gcd()); //should be 4
     	System.out.println(b.gcd()); //should be 1

	System.out.println("reduce");
	a.reduce();
	System.out.println(a.toString()); //should be 1/3
	b.reduce();
	System.out.println(b.toString()); //should be 1/2
	
	Rational big = new Rational(3,2); //Stores rational number 3/2
	Rational bigger = new Rational(10,6); //Stores rational number 10/6
	Rational bigger2 = new Rational(10,6); //Stores rational number 10/6

	System.out.println("compareTo");
	System.out.println(big.compareTo(bigger)); //should return -1
  	System.out.println(bigger.compareTo(big)); //should return 1
    	System.out.println(bigger2.compareTo(bigger)); //should return 0

	
    }//end main
}//end class Rational
