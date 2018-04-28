import java.util.Scanner;

import javax.swing.JFrame;


/**
 * Test
 * Petita demostració de representacions possibles. s'avança donant enter a la consola
 *
 */


public class Test {
 
    public static void main(String[] args) {
        Taulell t = new Taulell();
        Finestra f = new Finestra(t);
        
        Scanner sc = new Scanner(System.in);
        
        sc.nextLine();
        
        //cas 1: Hundir la flota
        
        t.setActcolors(true);
        t.setActimatges(false);
        t.setActlletres(false);
        int[] colors={0x0000FF,0x00FF00,0xFFFF00,0xFF0000,0xFF00FF,0x00FFFF,0x000000,0xFFFFFF,0xFF8000,0x7F00FF};
        t.setColors(colors);
        f.setActetiquetes(true); //les etiquetes i titol com que no tenen a veure amb la matriu es tracten per la finestra!
        String[] etiquetes={"Dispars:10","Portavions:1","Cuirassats:0","Creuers:0","Submarins:1"};
        f.setEtiquetes(etiquetes);  
        f.setTitle("Enfonsar la flota");
        int[][] matriu =
        	{
        		{0,0,0,0,0,0,0,0,0,0},
        		{0,0,5,3,3,0,0,5,0,0},
        		{0,0,0,0,0,0,0,0,0,0},
        		{0,0,5,0,6,0,0,0,0,0},
        		{0,0,0,0,6,0,5,0,0,0},
        		{0,0,0,0,6,0,0,0,6,0},
        		{0,0,5,0,6,0,0,0,0,0},
        		{0,0,0,0,0,0,0,0,0,0},
        		{0,0,0,0,0,0,0,0,0,0},
        		{0,0,0,0,2,4,1,7,8,9},
        	};
        		
        t.dibuixa(matriu);
        sc.nextLine();
        
        
      
        
        
        
        //cas 2: Buscaminas
        t.setActcolors(false);
        t.setFons(0xb1adad);
        t.setActimatges(false);
        t.setActlletres(true);
        String[] lletres = {"","1","2","3","4","5","6","7","8","*"};  //què s'ha d'escriure en cada casella en base al nombre
        t.setLletres(lletres);
        int[] colorlletres = {0x0000FF,0x00FF00,0xFFFF00,0xFF0000,0xFF00FF,0x00FFFF,0x521b98,0xFFFFFF,0xFF8000,0x7F00FF};
        t.setColorlletres(colorlletres);
        String[] etiquetes2={"Mines: 10", "Temps: 600"};
        f.setEtiquetes(etiquetes2);
        f.setActetiquetes(true);
        f.setTitle("Cercamines");
        
        int[][] matriu2 =
        	{
        		{9,9,9,9,9,9,9,9,9,9},
        		{9,9,1,1,2,9,9,5,9,9},
        		{9,9,9,9,3,9,9,9,9,9},
        		{9,9,5,9,6,9,9,9,9,9},
        		{9,9,9,9,6,9,5,9,9,9},
        		{9,9,8,9,6,9,9,9,6,9},
        		{9,9,5,9,6,9,9,9,9,9},
        		{1,1,1,9,9,9,9,9,9,9},
        		{0,0,1,2,9,9,9,9,9,9},
        		{0,0,0,1,9,4,1,7,8,9},
        	};
        		
        t.dibuixa(matriu2);
        sc.nextLine();
        
        //cas 3: The Legend of Zelda
        
        t.setActcolors(false);
        t.setFons(0xfed8a7);
        t.setActimatges(true);
        t.setActlletres(false);
        t.setActborde(false);
        String[] imatges = {"","Link1.gif","rock2.png","rock1.png","octorok.gif","octorok.gif","octorok.gif","octorok.gif","octorok.gif","octorok.gif"};  
        t.setImatges(imatges);
        f.setActetiquetes(false);
        f.setTitle("The Legend of Zelda");
        
        int[][] matriu3 =
        	{
            		{2,2,2,2,2,2,2,2,2,2},
            		{0,0,0,0,0,0,0,4,0,0},
            		{0,0,0,3,3,0,0,0,0,0},
            		{0,1,0,3,3,0,4,0,0,0},
            		{0,0,0,0,6,0,0,0,0,0},
            		{2,2,2,2,2,2,2,2,2,2},
        	};
        		
        t.dibuixa(matriu3);
        sc.nextLine();
 
    }
 
}





