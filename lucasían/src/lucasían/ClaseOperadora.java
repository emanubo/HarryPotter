package lucasían;

public class ClaseOperadora {

	ClaseOperadora(int x, int y){
	System .out .println ("x = " + x + "y = " + y );
	}
	ClaseOperadora(int x, float y){
	System .out .println ("x = "+ x + "y = " + y );
	}
	
	public static void main(String args[]) {
		
	int x = 129;
	byte y = 77;
	ClaseOperadora test = new ClaseOperadora(x, y);
	}
	
}
