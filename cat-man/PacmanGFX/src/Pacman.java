import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.SynchronousQueue;

public class Pacman {

	/**
	 * 
	 */

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
	public static int filas = 31;
	public static int columnas = 28;
	public static Catman player1 = new Catman(21,1); //new Catman(23,14);
	static ArrayList<EntradaRanking> ranking = new ArrayList<>();
	static String nom = "player";
	static int punts = 0;
	
	
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
	    	{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,20, 20, 20, 20, 20, 20, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },//14
		    { 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 20, 20, 20, 20, 20, 20, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//15
		    { 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//16
			{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//17
			{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//18
			{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },//19
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },//20
			{ 1, 19, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },//21
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
		leeRanking();
		Fantasma redGhost = new Fantasma(14,15,3,4,5,6,FantasmasFirstMove.RED); 	//posx,posy,AR,AB,I,D 11/12
		Fantasma blueGhost = new Fantasma(15,12,7,8,9,10,FantasmasFirstMove.BLUE); 	//posx,posy,AR,AB,I,D 14/12
		Fantasma yellowGhost = new Fantasma(14,13,15,16,17,18,FantasmasFirstMove.YELLOW); //posx,posy,AR,AB,I,D
		Fantasma pinkGhost = new Fantasma(15,14,11,12,13,14,FantasmasFirstMove.PINK); //posx,posy,AR,AB,I,D
		
		listf = new ArrayList<Fantasma>();
		listf.add(redGhost);
		listf.add(blueGhost);
		listf.add(yellowGhost);
		listf.add(pinkGhost);
		
	}
	
	
	public static void fin() {
		if (fin) {
			timer.cancel();	
			System.out.println("GAME OVER");
			System.out.println("PUNTOS TOTALES: " +punts);
			guardarRanking();
		}
	}
	
	private static void ponerGraficos() {
		t.setActcolors(false); //ya no quiero colores
        t.setActimatges(true); 
        t.setActborde(false);  //no quiero borde entre casillas
        t.setActimgbackground(true);  //  TRUE PARA REVERTIR CAMBIOS
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
        "ojosD.png",//33
        "ojosI.png",//34
        
        };
        
        t.setImatges(imatges);
        f.setActetiquetes(false); 
        f.setTitle("Cat-Man");
		t.dibuixa(MapaFantasmas.mapaF);
	
		
		
		
	}
	
	private static int calculapunts() {
		int calpunts=0;
		for (int i=0;i<filas;i++) {
			for (int j=0;j<columnas;j++) {
				//-18
				if(Pacman.mapa[i][j]==20) {
					calpunts++;
				}
			}
		}
		
		return calpunts-18;
	}
	
	private static void leeRanking() {
		// TODO Auto-generated method stub
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("C:/Users/Qukita/Desktop/ranking.txt")));
			while (in.ready()) {
				String entrada = in.readLine();
				String aen[] = entrada.split(" ");
				int entradapunts = Integer.parseInt(aen[1]);
				EntradaRanking entrank = new EntradaRanking(aen[0], entradapunts);
				ranking.add(entrank);
			}
			Collections.sort(ranking);
			in.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No funciona la lectura");
		}

	}
	
	private static void guardarRanking() {
		// TODO Auto-generated method stub
		
		EntradaRanking rank = new EntradaRanking(nom, punts);
		ranking.add(rank);
		Collections.sort(ranking);
		File f = new File("C:/Users/Qukita/Desktop/ranking.txt");
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(f));
			for (EntradaRanking er : ranking) {
				out.write(er.nom + " " + er.punts);
				out.newLine();

			}
			out.flush();
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void saveGame() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("C:/Users/Qukita/Desktop/save.sav");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Pacman.mapa);
			oos.writeObject(listf);
			oos.writeObject(player1);
			System.out.println("Guardado");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void loadGame() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:/Users/Qukita/Desktop/save.sav");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while(true) {
				
				Object o = ois.readObject();
				if (o instanceof int[][])  Pacman.mapa = (int[][]) o;
				else if(o instanceof ArrayList<?>) {
					listf = (ArrayList<Fantasma>) o;	
				}else if (o instanceof Catman) {
					player1 = (Catman) o;
				}
			}			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Cargado");
		}
			
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
        		
        		}else if(e.getKeyCode() == KeyEvent.VK_G)
        		{
        			saveGame();
        			return true;
        		}else if(e.getKeyCode() == KeyEvent.VK_L)
        		{
        			loadGame();
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
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				MapaFantasmas.mapaF[i][j]=mapa[i][j];
			}
		}
		for(Fantasma f : listf) {
			f.hazLoTuyo(player1);
		}
		player1.setComebola(false);
		punts=calculapunts()+Catman.puntos;
		System.out.println(punts);
		fin();
		//long endTime = System.currentTimeMillis();
		//long time = endTime-startTime;
		//System.out.println("tiempo de Jessica "+time);
		//long dstartTime = System.currentTimeMillis();
		t.dibuixa(MapaFantasmas.mapaF);
		
		//t.overdibuixa(MapaFantasmas.mapaF);
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
		
		datos();
		initThings();			
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
       900);      
        
	}



	private static void datos() {
		System.out.println("Introduce nombre de jugador");
		Scanner sc = new Scanner(System.in);
		nom= sc.next();
		sc.close();
		punts=0;
		System.out.println("¡Buena suerte "+ nom+"!");
		
	}
	

	



}
