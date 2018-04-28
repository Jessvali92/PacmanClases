import java.util.ArrayList;

public class Coords {

	private static ArrayList<String> listVortexPos = new ArrayList<String>();
	static Integer coordx;	
	static Integer coordy;
	
	
	public static boolean calcCoods(int x, int y) {//esta en un vortice o no?
		String comprobar = "";
		comprobar = x+""+y+"";
		if (listVortexPos.contains(comprobar)){
			System.out.println("(true)estoy en un vortice temporal");//busca el camino mas corto a través del vortice
			return true;
		}else {
			System.out.println("false");//tendra que seguir moviendo
			return false;
			
		}
		
	}
	
	//coordenadas de los vortices (usar o no, es es la cuestion)
	static void addcoo() {
			//1
			listVortexPos.add("17");
			listVortexPos.add("122");
			//5
			listVortexPos.add("51");
			listVortexPos.add("57");
			listVortexPos.add("510");
			listVortexPos.add("513");
			listVortexPos.add("516");
			listVortexPos.add("519");
			listVortexPos.add("522");
			listVortexPos.add("527");
			//8
			listVortexPos.add("87");
			listVortexPos.add("822");
			//11
			listVortexPos.add("1113");
			listVortexPos.add("1116");
			//14
			listVortexPos.add("147");
			listVortexPos.add("1410");
			listVortexPos.add("1419");
			listVortexPos.add("1422");
			//17
			listVortexPos.add("1710");
			listVortexPos.add("1719");
			//20
			listVortexPos.add("207");
			listVortexPos.add("2010");
			listVortexPos.add("2019");
			listVortexPos.add("2022");
			//23
			listVortexPos.add("237");
			listVortexPos.add("2310");
			listVortexPos.add("2313");
			listVortexPos.add("2316");
			listVortexPos.add("2319");
			listVortexPos.add("2322");
			//29
			listVortexPos.add("2913");
			listVortexPos.add("2916");				
			
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
