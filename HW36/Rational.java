//Colin Hosking
//APCS1 pd08
//HW36 -- Be Rational
//2017-11-20
public class Rational{

    //instance vars for numerator and denominator
    private int numer; 
    private int denom;

    //default constructor ===> 0/1
    public Rational(){
	numer = 0;
	denom = 1;
    }

    //constructor
    public Rational(int p, int q){
	this(); //sets numer and denom to "default" values
	if (q != 0){
	    numer = p;
	    denom = q;
	}
	else{
	 System.out.println("Invalid: Denominator cannot equal 0. The rational number is set to 0/1.");
	}
    }

    //toString returns the Rational number
    public String toString(){
	return numer +  " / " + denom;
    }

    //floatValue returns approx floating point equivalent of rational number
    public double floatValue(){
	return (numer * 1.0) / denom;
    }

    //multiply
    public void multiply(Rational r){
	numer = r.numer * numer; //r's numer * old numer
	denom = r.denom * denom; //r's denom * old denom
    }

    //divide
    public void divide(Rational r){ //dividing is multiplying by the reciprocal
	numer = r.denom * numer; 
	denom = r.numer * denom;
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
	
    }//end main
}//end class Rational
