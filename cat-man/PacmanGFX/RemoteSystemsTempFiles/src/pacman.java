import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class pacman {

	static Taulell t = new Taulell();
	static Finestra f = new Finestra(t);
	static Scanner sc = new Scanner(System.in);
	static int filas = 32;
	static int columnas = 29;
	static int muro = 1;
	static int mapaInicio[][] = iniciaMapa();
	static int map[][] = iniciaMapa();
	static boolean finjuego = false;
	static boolean comer = false;
	static int blinkyx = 0;//11
	static int blinkyy = 0;//14
	static int pinkyx = 0;//13
	static int pinkyy = 0;//14
	static int inkyx = 0;//13
	static int inkyy = 0;//12
	static int clydex = 0;//0
	static int clydey = 0;//0
	static boolean primeraA = false;
	static boolean primeraAR = false;
	static boolean primeraI = false;
	static boolean primeraD = false;
	static int lastNumber = 0;
	static int mov = 0;
	static int pacx = 23;
	static int pacy = 14;

	private static int[][] iniciaMapa() {
		int mapaInicio[][] = {

				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
				{ 1, 2, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 2, 1 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 9, 9, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 4, 4, 4, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
				{ 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4 },
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
				{ 1, 2, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 2, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1 },
				{ 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },

		};
		return mapaInicio;
	}

	private static int menu() {
		System.out.println("Buscaminas, Escribe un número \n" + "1. Ayuda\n" //
				+ "2. Opcions\n" //
				+ "3. Jugar partida\n" //
				+ "4. Ranking\n" // visualizacion de la puntuacion
				+ "5. Sortir");
		return sc.nextInt();
	}

	private static boolean salir() {
		System.out.println("Seguro? Este programa es muy guay");
		String segur = sc.nextLine();
		if (segur.equals("si")) {
			return false;
		} else {
			return true;
		}
	}

	private static void imprimirMatriz() {
		String ac = "";
		for (int f = 0; f < filas - 1; f++) {
			for (int c = 0; c < columnas - 1; c++) {
				ac = ac + map[f][c] + " ";
			}
			ac = ac + "\n";
		}
		ac = ac + "\n";
		System.out.println("Este es tu tablero de juego " + "\n" + "\n" + ac);
	}

	private static void comprobar() {
		// TODO
	}

	private static void fantasmaRandom() {
		// NUMBER 3 Blinky
		if (!finjuego) {
			boolean movDone = false;
			if (!primeraA) { //inicia  solo a la primera posicion de Blinky
				lastNumber = map [11][14];
				blinkyx = 11; //filas bliky
				blinkyy = 14;//columnas blinky
				map [blinkyx][blinkyy] = 3;//poner blinky en el mapa
				t.dibuixa(map);
				primeraA = true;//no vuelve a hacerlo
			}
			if (lastNumber == 0) {
				map [blinkyx][blinkyy] = 0;				
			}else {
				map [blinkyx][blinkyy] = 4;				
			}						
			while (!movDone) {	
				int mov = (int) (Math.random() * (4) + 1);
				if (mov == 1) { // ABAJO
					if (map[blinkyx + 1][blinkyy] != 1     &&
							map[blinkyx + 1][blinkyy] != 9) {
						blinkyx++;
						lastNumber = map[blinkyx][blinkyy];
						map[blinkyx][blinkyy] = 3;
						movDone = true;
					}
				}
				if (mov == 2) { // ARRIBA
					if (map[blinkyx - 1][blinkyy] != 1) {
						blinkyx--;
						lastNumber = map[blinkyx][blinkyy];
						map[blinkyx][blinkyy] = 3;
						movDone = true;
					}
				}
				if (mov == 3) { // IZQ
					if (map[blinkyx][blinkyy - 1] != 1) {
						blinkyy--;
						lastNumber = map[blinkyx][blinkyy];
						map[blinkyx][blinkyy] = 3;
						movDone = true;
					}
				}
				if (mov == 4) { // DER
					if (map[blinkyx][blinkyy + 1] != 1) {
						blinkyy++;
						lastNumber = map[blinkyx][blinkyy];
						map[blinkyx][blinkyy] = 3;
						movDone = true;
					}
				}
					
			}
		}
		t.dibuixa(map);
	}

	private static void scanner() {
		
		while (mov!=4 && mov!=5 && mov!=6 && mov!=8) 
		{
			System.out.println("5 Abajo,8 arriba, 6 derecha, 4 izquierda");
			
			mov = sc.nextInt();
		}		
	}
	
	private static void move() {
		// posicion inicial
		
		// posicion siguiente
		int i = 0;
		int j = 0;
		boolean movDone = false;
		while (!movDone) {
			// pac derecha
			if (mov == 6) {
				if (map[pacx][pacy+1]!=1) {
						map[pacx][pacy] = 8;
						pacy++;
						map[pacx][pacy] = 5;
				}

				// pac izquierda
			} else if (mov == 4) {
					if (map[pacx][pacy-1]!=1) {
							map[pacx][pacy] = 8;
							pacy--;
							map[pacx][pacy] = 5;
					}
			
				// pac abajo
			} else if (mov == 5) {
				if (map[pacx+1][pacy]!=1) {
						map[pacx][pacy] = 8;
						pacx++;
						map[pacx][pacy] = 5;
				}
				// pac arriba
			} else if (mov == 8) {
				if (map[pacx-1][pacy]!=1) {
						map[pacx][pacy] = 8;
						pacx--;
						map[pacx][pacy] = 5;
				}
			
			}
			movDone = true;
		}
		
	}

	public static void main(String[] args) throws Throwable {
				
		t.setActcolors(false); //ya no quiero colores
        t.setActimatges(true); 
        t.setActborde(false);  //no quiero borde entre casillas
        t.setActimgbackground(true);  //quiero fondo de imagen
        t.setImgbackground("fondo.jpg");  //direccion al fondo. Todas las imagenes en la carpeta del proyecto
        String[] imatges = {"puntop1.png","","puntop.png","slinky.png","","pac.png","","","",""};  //cread primero al lista y luego pasadsela. El String vacio es que no quiere simagen alli
        t.setImatges(imatges);
        f.setActetiquetes(false); 
        f.setTitle("Pac-Man");
		t.dibuixa(map);
		
		Timer timer = new Timer();
        timer.schedule(new TimerTask() 
        {
            @Override
            public void run() 
            {
            	doStuffpac();
            	doStuff();
            	t.dibuixa(map);
            }
        },
        0,
        2000); 
        
     // get the current KeyboardFocusManager
        KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
         
        // add a KeyDispatcher
        kfm.addKeyEventDispatcher(new KeyEventDispatcher() {
         
        	// process the KeyEvent
        	@Override
        	public boolean dispatchKeyEvent(KeyEvent e) {
         
        		// check for the KeyEvent you want
        		if (e.getKeyCode() == KeyEvent.VK_W) 
        		{
         
        			// do something with e
        			mov = 8;
        			return true; // this KeyEvent stops here
        		}
        		else if(e.getKeyCode() == KeyEvent.VK_S) 
        		{
        			mov = 5;
        			return true;
        		}
        		else if(e.getKeyCode() == KeyEvent.VK_A) 
        		{
        			mov = 4;
        			return true;
        		}
        		else if(e.getKeyCode() == KeyEvent.VK_D) 
        		{
        			mov = 6;
        			return true;
        		}
        		else
        		{	
        			return false; // all other KeyEvents continue down the chain
        		}
        	}
        });
        

		/*while (!finjuego)
		{
			scanner();	
			   
		}
		*/
	}
	
	private static void doStuff() {
			fantasmaRandom();
	}
	private static void doStuffpac() {
			move();
	}
}
