import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Pacman {

	public static Taulell t = new Taulell();
	public static Finestra f = new Finestra(t);
	public Scanner sc = new Scanner(System.in);
	public int mapaInicio[][] = iniciaMapa();
	public static int mapa[][] = iniciaMapa();
	public boolean finjuego = false;	
	public static int mov = 0;
	public static boolean fin = false;
	public boolean bolagorda=true;
	public static Timer timer = new Timer();
	public static ArrayList<Fantasma> listf ;
	public ArrayList<Catman> listc ;
	public int filas = 31;
	public int columnas = 28;
	public static Catman player1 = new Catman(23,14);
	
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
			{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 20, 20, 20, 20, 20, 20, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//13
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 20, 20, 20, 20, 20, 20, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },//14
			{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 20, 20, 20, 20, 20, 20, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//15
			{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//16
			{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//17
			{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//18
			{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//19
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },//20
			{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },//21
			{ 1, 2, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 2, 1 },//22
			{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1 },//23
			{ 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1 },//24
			{ 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1 },//25
			{ 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1 },//26
			{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },//27
			{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },//28
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },//29
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },//30
			//0//1//2//3//4//5//6//7//8//9/10/11/12/13/14/15/16/17/18/19/20/21/22/23/24/25/26/27/--31/28
			

		};
					
		return mapaInicio;
	}
				
	
	
	private static void initThings () {
		Fantasma redGhost = new Fantasma(11,12,3,4,5,6,0,FantasmasFirstMove.RED); 	//posx,posy,AR,AB,I,D
		Fantasma blueGhost = new Fantasma(14,12,7,8,9,10,20,FantasmasFirstMove.BLUE); 	//posx,posy,AR,AB,I,D
		Fantasma yellowGhost = new Fantasma(14,16,15,16,17,18,20,FantasmasFirstMove.YELLOW); //posx,posy,AR,AB,I,D
		
		listf = new ArrayList<Fantasma>();
		listf.add(redGhost);
		listf.add(blueGhost);
		listf.add(yellowGhost);
		Coords.addcoo();
	}
	
	
	public static void fin() {
		if (fin) {
			timer.cancel();	
		}
	}
	
	private static void ponerGraficos() {
		t.setActcolors(false); //ya no quiero colores
        t.setActimatges(true); 
        t.setActborde(true);  //no quiero borde entre casillas
        t.setActimgbackground(false);  //  TRUE PARA REVERTIR CAMBIOS
        //t.setImgbackground("fondo.jpg");  //direccion al fondo. Todas las imagenes en la carpeta del proyecto
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
		t.dibuixa(mapa);
		t.overdibuixa(MapaFantasmas.iniciaMapa());
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

		
	public static void fun() {
		
		//long startTime = System.currentTimeMillis();
		
		
		player1.mueveteCatman();
		tecladoWASD();		
		for(Fantasma f : listf) {
			f.hazLoTuyo(player1);
		}
		fin();
		//long endTime = System.currentTimeMillis();
		
		//long time = endTime-startTime;
		//System.out.println("tiempo de Jessica "+time);
		
		//long dstartTime = System.currentTimeMillis();
		t.dibuixa(mapa);
		//long dendTime = System.currentTimeMillis();
		//long dtime = dendTime-dstartTime;
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
		initThings();
		
		
		
        timer.schedule(new TimerTask() 
        {
            @Override
            public void run() 
            {          	
            	fun();
            }			
        },
        0,
       900);      
        
	}
	

	



}
