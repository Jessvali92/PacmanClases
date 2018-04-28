import java.util.Scanner;

public class CosasGraficasChulas {
	static Taulell t = new Taulell();
	static Finestra f = new Finestra(t); 
	static Scanner sc = new Scanner(System.in);
			
	public static void main (String[] args) {
		int[][] mapa = {
				{1,1,1,1,1},
				{1,0,0,0,1},
				{1,0,3,0,1},
				{1,0,0,0,1},
				{1,1,1,1,1},
		};
		
		t.setActcolors(true);  ///ACTIVAR COLORES
		int[] colors = {0x0000F0, 0xFF000, 0x000000, 0xFFFF00};
		t.setColors(colors);   ///ENVIAR COLORES
		
		t.dibuixa(mapa);
		
		
		sc.nextLine();
		
		t.setActcolors(false); //ya no quiero colores
        t.setActimatges(true); 
        t.setActborde(false);  //no quiero borde entre casillas
        t.setActimgbackground(true);  //quiero fondo de imagen
        t.setImgbackground("hs.jpg");  //direccion al fondo. Todas las imagenes en la carpeta del rpoyecto
        String[] imatges = {"","sap.png","bugi.png","feo.jpg"};  //cread primero al lista y luego pasadsela. El String vacio es que no quiere simagen alli
        t.setImatges(imatges);
        f.setActetiquetes(false);
        f.setTitle("HS");
		int[][] mapache = {
				{0,0,0,0,0},
				{0,0,1,2,0},
				{0,0,3,0,0},
				{0,0,0,0,0},
		};

		
		t.dibuixa(mapache);
	}
}
