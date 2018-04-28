import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Pacman {

	static Taulell t = new Taulell();
	static Finestra f = new Finestra(t);
	static Scanner sc = new Scanner(System.in);
	static int mapaInicio[][] = iniciaMapa();
	static int map[][] = iniciaMapa();
	static boolean finjuego = false;	
	static int mov = 0;
	static int pacx = 23;
	static int pacy = 14;
	static boolean fin = false;
	static boolean bolagorda=true;
	static boolean desactivar3x1y = true;
	static boolean desactivar3x26y = true;
	static boolean desactivar23x1y = true;
	static boolean desactivar23x26y = true;
	static Timer timer = new Timer();
	static ArrayList<Fantasma> listf ;
	static ArrayList<Integer> duplicados;
	static ArrayList<Integer> duplicados2;
	static int filas = 31;
	static int columnas = 28;
		
	
	private static int[][] iniciaMapa() {
		int mapaInicio[][] = {

				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },//0
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },//1
				{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },//2
				{ 1, 2, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 2, 1 },//3
				{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },//4
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },//5
				{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1 },//6
				{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1 },//7
				{ 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1 },//8
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//9
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//10
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//11
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 22, 22, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//12
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 20, 20, 20, 20, 20, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//13
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 20, 20, 20, 20, 20, 20, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },//14
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//15
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//16
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//17
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//18
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//19
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },//20
				{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },//21
				{ 1, 2, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 2, 1 },//22
				{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1 },//23
				{ 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1 },//24
				{ 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1 },//25
				{ 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1 },//26
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },//27
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },//28
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },//29
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },//30
				//0//1//2//3//4//5//6//7//8//9/10/11/12/13/14/15/16/17/18/19/20/21/22/23/24/25/26/27/--31/28
				

		};
		Fantasma redGhost = new Fantasma(11,12,3,4,5,6,0); 	//posx,posy,AR,AB,I,D
		Fantasma blueGhost = new Fantasma(14,11,7,8,9,10,20); 	//posx,posy,AR,AB,I,D
		Fantasma yellowGhost = new Fantasma(14,16,15,16,17,18,20); //posx,posy,AR,AB,I,D
		listf = new ArrayList<Fantasma>();
		listf.add(redGhost);
		listf.add(blueGhost);
		listf.add(yellowGhost);
		Coords.addcoo();
		return mapaInicio;
	}
	
	/*private void errors() {
		String valor = "";
		int esta=0;
		int fi;
		int co;
		for (int i=0;i<filas;i++) {
			for (int j=0;j<columnas;j++) {
				 if(map[i][j]==3) {
                     esta=esta+1;
                     fi=i;
                     co=j;
				 }	
			}
		}
		if (esta>2) {
			map[fi][co]
		}
	}*/
	
	/*private static void solapar() {
 		ArrayList<Integer> positionGhostListX = new ArrayList<Integer>();
 		ArrayList<Integer> positionGhostListY = new ArrayList<Integer>();
 		for (Fantasma fan : listf) {
 			positionGhostListX.add(fan.getPosX());
 			positionGhostListY.add(fan.getPosY());
	
 		}
 		for (int i=0; i<positionGhostListX.size();i++ ) {
 			int position = positionGhostListX.get(i);
 			for (int j=0; j<positionGhostListX.size();j++) {
 				int position2 = positionGhostListX.get(j);
 				if (i!=j) {
 					if (position2==position) {
 						
 						avoidGhost = true;
 					}else {
 						avoidGhost = false;
 					}
 				}
 				
 			}
 			
 			
 			
 			
 		}
 		
 		for (Integer pos2 : positionGhostListY ) {
 			
 		}
 		
 		avoidGhost = true;
					
	}*/
	
	public static void fin() {
		if (fin) {
			timer.cancel();	
		}
	}

	private static void teleport() {
	
		if (pacx==14 && pacy==1) {
			
			pacx = 14;
			pacy = 26;
			
			
			map[14][1] = 20;
			
				
		}else if (pacx==14 && pacy==26) {
			
			pacx = 14;
			pacy = 1;
			
			map[14][26] = 20;
		}
	}


	
	private static void movePacman() {		
		
		boolean movDone = false;
		
		if(!finjuego) {
			
			while (!movDone) {
				// pac derecha
				if (mov == 6) {
					if (map[pacx][pacy+1]!=1) {
							map[pacx][pacy] = 20;
							pacy++;
							map[pacx][pacy] = 19;
					}
	
					// pac izquierda
				} else if (mov == 4) {
						if (map[pacx][pacy-1]!=1 /*&& map[pacx][pacy-1]!=21*/){
								map[pacx][pacy] = 20;
								pacy--;
								map[pacx][pacy] = 26;
						}
					// pac abajo
				} else if (mov == 5) {
					if (map[pacx+1][pacy]!=1) {
							map[pacx][pacy] = 20;
							pacx++;
							map[pacx][pacy] = 32;
							
					}else if (map[pacx+1][pacy]==9) {
						map[pacx][pacy] = 20;
						pacy--;
						map[pacx][pacy] = 32;
					}
					
					// pac arriba
				} else if (mov == 8) {
					if (map[pacx-1][pacy]!=1) {
							map[pacx][pacy] = 20;
							pacx--;
							map[pacx][pacy] = 31;
					}
				
				}
				movDone = true;
			}			
		}
		
	}
	
	private static void ponerGraficos() {
		t.setActcolors(false); //ya no quiero colores
        t.setActimatges(true); 
        t.setActborde(false);  //no quiero borde entre casillas
        t.setActimgbackground(true);  //                          quiero fondo de imagen CAMBIAR A TRUEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
        t.setImgbackground("fondo.jpg");  //direccion al fondo. Todas las imagenes en la carpeta del proyecto
        String[] imatges = { 
        		
        "puntop1.png","","puntop.png",//0,1,2
        
        "rojoAR.png","rojoAB.png","rojoI.png","RojoD.png",//3,4,5,6 ROJO
        
        "celesteAR.png","celesteAB.png","celesteI.png","celesteD.png",//7,8,9,10 CELESTE
        
        "rosadoAR.png","rosadoAB.png","rosadoI.png","rosadoD.png",//11,12,13,14 ROSADO
        
        "naranjaAR.png","naranjaAB.png","naranjaI.png","naranjaD.png",//15,16,17,18 NARANJA
        
        "pacmanD.png",//19 PACMAN
        "",//20 vacio
        "",//21 vacio uso teletransporte
        "",//22 vacio uso fantasmas
        "fantasmamuerto.png",//23 fantasma azul
        "",//24
        "",//25
        "pacmanI.png",//26 PACMAN IZQ
        "fantasmamuerto.png",//27
        "fantasmamuerto.png",//28
        "fantasmamuerto.png",//29
		"fantasmamuerto.png",//30
        "pacmanAR.png",//31
        "pacmanAB.png",//32
        };
        
        t.setImatges(imatges);
        f.setActetiquetes(false); 
        f.setTitle("Cat-Man");
		t.dibuixa(map);
	}
	
	private static void tecladoWASD() {
		
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
        
	}
	
	
	private static void doStuffcomprobarB() {
		
		
		if (map[pacx][pacy]==map[3][1]&&desactivar3x1y) {
			
			for(Fantasma f : listf) {
				f.setDie(true);
			}
			
			desactivar3x1y = false;
			
		}else if ( map[pacx][pacy]==map[3][26]&&desactivar3x26y) {
			
			for(Fantasma f : listf) {
				f.setDie(true);
			}
			desactivar3x26y = false;
			
		}else if( map[pacx][pacy]==map[22][1]&&desactivar23x1y) {
			
			for(Fantasma f : listf) {
				f.setDie(true);
			}
			desactivar23x1y = false;
		}else if (map[pacx][pacy]==map[22][26]&&desactivar23x26y) {
			
			for(Fantasma f : listf) {
				f.setDie(true);
			}
			desactivar23x26y = false;
		}
	}

	private static void doStuffpac() {
		movePacman();
		teleport();
	}
	
	
	public static void fun() {
		
		long startTime = System.currentTimeMillis();
		doStuffpac();
		
		for(Fantasma f : listf) {
			f.hazLoTuyo();
		}
		tecladoWASD();
		doStuffcomprobarB();
		fin();
		long endTime = System.currentTimeMillis();
		
		long time = endTime-startTime;
		//System.out.println("tiempo de Jessica "+time);
		
		long dstartTime = System.currentTimeMillis();
		t.dibuixa(map);
		long dendTime = System.currentTimeMillis();
		long dtime = dendTime-dstartTime;
		//System.out.println("Tiempo de Marc "+dtime);
		/*String valor = "";
		for (int i=0;i<filas;i++) {
			for (int j=0;j<columnas;j++) {
				valor = valor+ map[i][j]+" ";
			}valor = valor + "\n";
		}System.out.println(valor);*/
	}
	
	

	
	public static void main(String[] args) throws Throwable {
				
		ponerGraficos();
		
		
        timer.schedule(new TimerTask() 
        {
            @Override
            public void run() 
            {          	
            	fun();
            }			
        },
        0,
       1000);      
        
	}
	

	



}
