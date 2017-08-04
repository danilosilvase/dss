package ufs.main;

public class MainTeste {

	public static void main(String[] args) {
		double C1 = 2.05, C2 = 2.05;
		double constrictionFactor = Math.abs(2 / (4 - (C1 + C2) - Math.sqrt(Math.pow(C1+C2, 2)- (4 * C1+C2)) ));
		
		System.out.println(constrictionFactor);

	}

}
