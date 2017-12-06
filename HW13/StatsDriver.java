//Colin Hosking
//APCS1 pd08
//HW13 -- May ah Hahv S'maur, Please?
//2017-10-09

public class StatsDriver{

    public static void main(String[] args){
	System.out.println("int x3 max testing: expecting 100, 100, 100, -5, 10");

	System.out.println(Stats.max(100,50,10)); //tests largest int in pos. 1
	System.out.println(Stats.max(10,50,100)); //tests largest int in pos. 3
	System.out.println(Stats.max(50,100,10)); //tests largest int in pos. 2
	System.out.println(Stats.max(-20,-5,-10)); //tests all negative
	System.out.println(Stats.max(0,-50,10)); //tests both negative and positive ints

	System.out.println("========================================");

	System.out.println("double x3 max testing: expecting 100.2, 100.34, 500.1, -10.34, 10.3");

	System.out.println(Stats.max(100.2,50.1,10.34)); //tests largest double in pos. 1
	System.out.println(Stats.max(10.2,50.1,100.34)); //tests largest double in pos. 3                      
        System.out.println(Stats.max(100.2,500.1,10.34)); //tests largest double in pos. 3
 	System.out.println(Stats.max(-100.2,-50.1,-10.34)); //tests all negative
	System.out.println(Stats.max(0.0,-50.1,10.3)); //tests both negative and positive doubles

	System.out.println("========================================");

	System.out.println("int x3 geoMean testing: expecting 4, -4, 5");

	System.out.println(Stats.geoMean(2,8,4)); //tests all +, int geoMean result
	System.out.println(Stats.geoMean(-8,-2,-4)); //tests all -, int geoMean result
	System.out.println(Stats.geoMean(8,3,6)); //tests double geoMean result

	System.out.println("========================================");

	System.out.println("double x3 geoMean testing: expecting ~6.3, ~-6.3, 4.0");

	System.out.println(Stats.geoMean(2.1,35.5,3.4)); //tests all +, double geoMean result
	System.out.println(Stats.geoMean(-2.1,-35.5,-3.4)); //tests all -, double geoMean result
	System.out.println(Stats.geoMean(2.0,8.0,4.0)); //tests int geoMean result
    }//ends main()
}//ends class