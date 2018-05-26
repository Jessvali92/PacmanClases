package Leyendo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class leer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Leer_Fichero accediendo=new Leer_Fichero();
		accediendo.lee();
	}

}

class Leer_Fichero{
	
	public void lee () {
		try {
			FileReader entrada = new FileReader("C:/Users/Qukita/Desktop/ranking.txt");
			
			int c=entrada.read();
			while(c!=-1) {
				c=entrada.read();
				char letra=(char)c;
				System.out.print(letra);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha encontrado el archivo");
		}
	}
}