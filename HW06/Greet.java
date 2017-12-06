public class Greet {
    public static void main( String[] args ) {
	String greeting;

	BigSib richard = new BigSib();
        richard.setHelloMsg("Word up ");

	greeting = richard.greet("freshman");
	System.out.println(greeting);
	
	BigSib bob = new BigSib();
	bob.setHelloMsg("Salutations ");
	
	greeting = bob.greet("Dr. Spaceman");
	System.out.println(greeting);

	BigSib frank = new BigSib();
	frank.setHelloMsg("Hey ya ");

	greeting = frank.greet("Kong Fooey");
	System.out.println(greeting);

	BigSib pete = new BigSib();
	pete.setHelloMsg("Sup ");
	
	greeting = pete.greet("mom");
	System.out.println(greeting);
    }
}
