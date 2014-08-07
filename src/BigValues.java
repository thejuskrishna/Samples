import java.math.BigInteger;


public class BigValues {
	
	public static void main(String args[]) {
		
		BigInteger var = new BigInteger("99999999999999999999999999999");
		var = var.add(new BigInteger("1"));
		System.out.println(var);
		var = var.pow(2);
		System.out.println(var);
	}

}
