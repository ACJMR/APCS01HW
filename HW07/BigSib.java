public class BigSib{
    private String helloMsg;

    public BigSib( String myMsg){
	helloMsg = myMsg;

    }

    public void setHelloMsg( String nowMsg){
	helloMsg = nowMsg;
	    }
    public String greet(String name){
	return helloMsg + " " +  name;
	    }
}
