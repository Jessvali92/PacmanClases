
public class revserse{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String putaVida= "nah betx arum khar jhaleb";
		System.out.println(desgrasiada(putaVida));
	}

	private static String desgrasiada (String desgrasia) {
		
		if (desgrasia.length()==1)
			return desgrasia;
		else			
			return desgrasiada(desgrasia.substring(1))+ desgrasia.charAt(0);
	}
}
