import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.omg.Messaging.SyncScopeHelper;

public class Fantasma { 

	private Integer posX;
	private Integer posY;
	private Boolean movDone = false;
	private Boolean firstTime = false;
	private Boolean die = false;
	private Boolean eat = false;
	public int tiempobolagorda = 0;
	private int imgAR;
	private int imgAB;
	private int imgI;
	private int imgD;
	public boolean returningHome = false;
	public int positionHomeX = 11;
	public int positionHomeY = 14;
	private Array[][] destino;
	private Array[][] pActual;
	private Array[][] origen;
	private int iteraciones;
	public String op = "";
	int vortex = 0;
	ArrayList<Boolean> banderas = new ArrayList<Boolean>();
	ArrayList<String> posNxtMove = new ArrayList<String>();
	FantasmasFirstMove color;
	
	
	
	public int getPositionHomeX() {
		return positionHomeX;
	}

	public void setPositionHomeX(int positionHomeX) {
		this.positionHomeX = positionHomeX;
	}

	public int getPositionHomeY() {
		return positionHomeY;
	}

	public void setPositionHomeY(int positionHomeY) {
		this.positionHomeY = positionHomeY;
	}

	public void banderas() {
		for (int i = 0; i < 30; i++) {
			banderas.add(true);
		}
	}

	public Fantasma(Integer posicionX, Integer posicionY, int AR, int AB, int I, int D,FantasmasFirstMove color) {
		banderas();		
		this.posX = posicionX;
		this.posY = posicionY;
		imgAR = AR;
		imgAB = AB;
		imgI = I;
		imgD = D;
		this.color = color;
		
	}
	
	

	public Boolean getEat() {
		return eat;
	}

	public void setEat(Boolean eat) {
		this.eat = eat;
	}

	public  Integer getPosX() {
		return posX;
	}

	public void setPosX(Integer posicionX) {
		this.posX = posicionX;
	}

	public  Integer getPosY() {
		return posY;
	}

	public void setPosY(Integer posicionY) {
		this.posY = posicionY;
	}

	public Boolean getMovDone() {
		return this.movDone;
	}

	public void setMovDone(Boolean movDone) {
		this.movDone = movDone;
	}

	public void operaPos(String operacion, String variable) {
		if (operacion.equals("-")) {
			if (variable.equals("x")) {
				this.posX--;
			} else if (variable.equals("y")) {
				this.posY--;
			}
		} else if (operacion.equals("+")) {
			if (variable.equals("x")) {
				this.posX++;
			} else if (variable.equals("y")) {
				this.posY++;
			}
		}
	}

	public Boolean getFirstTime() {

		return this.firstTime;
	}

	public void setFirstTime(Boolean firstTime) {
		this.firstTime = firstTime;
	}

	public boolean getDie() {

		return die;
	}

	public void setDie(Boolean die) {
		this.die = die;
	}

	public void hazLoTuyo(Catman c) {
			this.know(c);
			if (returningHome==false){
				this.move(c);
			}else {
				this.returnHome();
			}
			this.know(c);
	}
	
	
	private void firstStep() { // primeros pasos de los fantasmas
		
	}
	
	/*if (this.color==FantasmasFirstMove.BLUE&&banderas.get(2)==true) {
	System.out.println("inblue");
	this.firstMoveBlue();
	System.out.println("outblue");
}if (this.color==FantasmasFirstMove.YELLOW&&banderas.get(3)==true) {
	System.out.println("inyellow");
	this.firstMoveYellow();
	System.out.println("outyellow");}*/
/*if (this.color==FantasmasFirstMove.RED&&banderas.get(14)==true) {
	System.out.println("inred");
	this.firstMoveRed();
	System.out.println("outred");
}else {*/
	
	/*private void firstMoveRed() {
		MapaFantasmas.mapa[posX][posY] = lastNumber;
		if (banderas.get(15)==true) {	
			this.operaPos("-", "y");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgI;
			banderas.set(15,false);
		}else if(banderas.get(16)==true) {
			this.operaPos("-", "y");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgI;
			banderas.set(16,false);
		}else if(banderas.get(17)==true) {
			this.operaPos("-", "y");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgI;
			banderas.set(17,false);
			banderas.set(14,false);
		}
	}*/
	
	/*private void firstMoveYellow() {
		MapaFantasmas.mapa[posX][posY] = lastNumber;
		
		if (banderas.get(9)==true) {		
			this.operaPos("-", "x");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgAR;
			banderas.set(9, false);
			System.out.println("arriba");
			
		}else if (banderas.get(18)) {
			this.operaPos("+", "x");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgAB;
			banderas.set(18, false);
			System.out.println("abajo");
			
		}else if (banderas.get(20)) {
			this.operaPos("-", "x");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgAR;
			banderas.set(20, false);
			System.out.println("arriba");
			
		}else if (banderas.get(21)) {
			this.operaPos("+", "x");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgAB;
			banderas.set(21, false);
			System.out.println("abajo");
			
		}else if (banderas.get(22)) {
			this.operaPos("-", "x");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgAR;
			banderas.set(22, false);
			System.out.println("arriba");
			
		}else if (banderas.get(10)==true) {
			this.operaPos("-", "y");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgI;
			banderas.set(10, false);
			System.out.println("izquierda");
			
		}else if (banderas.get(11)==true) {
			this.operaPos("-", "y");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgAR;
			banderas.set(11, false);
			System.out.println("izquierda");
			
		}else if (banderas.get(12)==true) {
			this.operaPos("-", "x");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgAR;
			banderas.set(12, false);
			System.out.println("arriba");
			
		}else if (banderas.get(13)==true) {
			this.operaPos("-", "x");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgAR;
			System.out.println("arriba");
			banderas.set(13, false);
			banderas.set(3,false);
			banderas.set(1, false);
		}	
	}*/
	
	/*private  void firstMoveBlue() {
		MapaFantasmas.mapa[posX][posY] = lastNumber;
		if (banderas.get(4)==true) {		
			this.operaPos("+", "y");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgD;
			banderas.set(4, false);
			System.out.println("D");
		}else if (banderas.get(5)==true) {
			this.operaPos("-", "x");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgAR;
			banderas.set(5, false);
			System.out.println("AR");
		}else if (banderas.get(6)==true) {
			this.operaPos("-", "x");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgI;
			banderas.set(6, false);
			System.out.println("AR");
		}else if (banderas.get(7)==true) {
			this.operaPos("-", "x");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgAR;
			banderas.set(7, false);
			System.out.println("AR");
		}else if (banderas.get(8)==true) {
			this.operaPos("-", "x");
			lastNumber = MapaFantasmas.mapa[this.getPosX()][this.getPosY()];
			MapaFantasmas.mapa[this.getPosX()][this.getPosY()] = imgAR;
			System.out.println("AR");
			banderas.set(8, false);
			banderas.set(2,false);
			banderas.set(0, false);
		}	
	}*/

	private void know(Catman c) {
		if(Catman.comebola) {
			tiempobolagorda=0;
		}
		if (die) {
			tiempobolagorda++;
			if (this.getPosX() == c.getpacx() && this.getPosY() == c.getpacy()) {
				eat = true;
				returningHome=true;
			}if (tiempobolagorda > 30) {
				die = false;
				eat = false;
				tiempobolagorda = 0;
			}
		} else {
			returningHome=false;
			if (this.getPosX() == c.getpacx() && this.getPosY() == c.getpacy()) {
				Catman.finjuego = true;
				Pacman.fin = true;
			}
		}
	}	

	private void lastStep() { // desde la coordenada a casa
		
	}
	
	private void sVortex(int x, int y) { //funcion que mueve hasta el vortice
		
		String option = "";		
		returningHome = true;
		x = getPosX();
		y = getPosY();		
			
		switch (option) {
		case "DE":
			if (positionHomeY < y && MapaFantasmas.mapaF[this.getPosX() + 1][this.getPosY()] != 1) { // right
				this.operaPos("+", "y");
				System.out.println("vuelve derecha");
			}
			break;
	
		case "IZ":
			if (positionHomeY > y && MapaFantasmas.mapaF[this.getPosX() - 1][this.getPosY()] != 1) { // left
				this.operaPos("-", "y");
				System.out.println("vuelve izquierda");
			}
			break;
	
		case "AR":
			if (positionHomeX > x && MapaFantasmas.mapaF[this.getPosX() - 1][this.getPosY()] != 1) { // up
				this.operaPos("-", "x");
				System.out.println("vuelve arriba");
	
			}
			break;
	
		case "AB":
			if (positionHomeX < x && MapaFantasmas.mapaF[this.getPosX() + 1][this.getPosY()] != 1) { // down
				this.operaPos("+", "x");
				System.out.println("vuelve abajo");
			}
			break;
		}	
	}
		
	
	private void returnHome() {
		
		if (this.getPosX() == 11 && this.getPosY() == 14) {
			//hacer movimiento final para entrar y 
			//reproducir de nuevo la salida del fantasma
		}/*else {
			
			//clase dijktra
			
			
			
			posNxtMove.removeAll(posNxtMove);
			
			// check vortice
			if (Pacman.mapa[this.getPosX() - 1][this.getPosY()] == 0 || Pacman.mapa[this.getPosX() - 1][this.getPosY()] == 20) { 
				posNxtMove.add("AR");
				vortex++;
			} if ( Pacman.mapa[this.getPosX() + 1][this.getPosY()] == 0 ||  Pacman.mapa[this.getPosX() + 1][this.getPosY()] == 20) {
				posNxtMove.add("AB");
				vortex++;
			} if (Pacman.mapa[this.getPosX()][this.getPosY() - 1] == 0 || Pacman.mapa[this.getPosX()][this.getPosY() - 1] == 20) {
				posNxtMove.add("IZ");
				vortex++;
			} if (Pacman.mapa[this.getPosX()][this.getPosY() + 1] == 0 || Pacman.mapa[this.getPosX()][this.getPosY() + 1] == 20) {
				posNxtMove.add("DE");
				vortex++;
			}
			System.out.println(vortex);
			if (vortex>=3) {//significa que estas en un vortice
				sVortex(this.getPosX(),this.getPosY());
				System.out.println("entra vortice porque cumple");
			}else {//significa que NO estas en un vortice
				sNextVortex(this.getPosX(),this.getPosY());
			}
					
			
		}*/
	}
	
	
	private void sNextVortex(Integer x, Integer y) {
		
		/*int resultY=0;
		int resultX=0;
		//comprobar cual esta mas lejos
		
		if (positionHomeY>y) {
			resultY = positionHomeY-y;
		}else {
			resultY = y-positionHomeY;
		}
		if (positionHomeX>x) {
			resultX = positionHomeX-x;
		}else {
			resultX = x-positionHomeX;
		}
		
		//saber si me puedo ir hacia ese lugar o no
		
		if (resultY>resultX) {
			System.out.println("izq/derecha");
		}else {
			System.out.println("arriba/abajo");
		}		*/
	}

	private void move(Catman c) {
		movDone = false;
		if (returningHome) {
			returnHome();
		} else {
			while (!movDone) {
				int movF = (int) (Math.random() * (4) + 1);
				switch (movF) {
				case 1: // DOWN MOV
					if (Pacman.mapa[this.getPosX() + 1][this.getPosY()] != 1
							&& Pacman.mapa[this.getPosX() + 1][this.getPosY()] != 22
							/*&& !ghostWall.contains(Pacman.mapa[this.getPosX() + 1][this.getPosY()])*/) { // can he move down?

						this.operaPos("+", "x");
						//lastNumber = Pacman.mapa[this.getPosX()][this.getPosY()];
						// DEATH
						if (this.getPosX() == c.getpacx() && this.getPosY() == c.getpacy()) {
							this.setEat(true);
						}if (this.getDie()==true&&this.getEat()==false) {
							MapaFantasmas.mapaF[this.getPosX()][this.getPosY()] = 28;//panic
							this.setMovDone(true);
						}else if (this.getDie() == true&&this.getEat()==true) {
							MapaFantasmas.mapaF[this.getPosX()][this.getPosY()] = 33; //ojos
							this.setMovDone(true);															

							// ALIVE
						} else if (this.getDie() == false) {
							
							MapaFantasmas.mapaF[this.getPosX()][this.getPosY()] = imgAB;
							this.setMovDone(true);
						} else {
							this.setMovDone(true);

						}
					}

					break;
				case 2: // UP MOV
					if (Pacman.mapa[this.getPosX() - 1][this.getPosY()] != 1
							/*&& !ghostWall.contains(Pacman.mapa[this.getPosX() - 1][this.getPosY()])*/) {// can he move up?

						this.operaPos("-", "x");
						//lastNumber = Pacman.mapa[this.getPosX()][this.getPosY()];
						// DEATH
						if (this.getPosX() == c.getpacx() && this.getPosY() == c.getpacy()) {
							this.setEat(true);
						}if (this.getDie()==true&&this.getEat()==false) {
							MapaFantasmas.mapaF[this.getPosX()][this.getPosY()] = 28;//panic
							this.setMovDone(true);
						}else if (this.getDie() == true&&this.getEat()==true) {
							MapaFantasmas.mapaF[this.getPosX()][this.getPosY()] = 33;//ojos
							this.setMovDone(true);																
						
						// ALIVE
						} else if (this.getDie() == false) {
							MapaFantasmas.mapaF[this.getPosX()][this.getPosY()] = imgAR;
							this.setMovDone(true);
						} else {
							this.setMovDone(true);

						}
					}

					break;
				case 3: // LEFT MOV
					if (Pacman.mapa[this.getPosX()][this.getPosY() - 1] != 1
							&& Pacman.mapa[this.getPosX()][this.getPosY() - 1] != 22
							/*&& !ghostWall.contains(Pacman.mapa[this.getPosX()][this.getPosY() - 1])*/
					/* && returningHome==false */) {// can he move left?

						this.operaPos("-", "y");
						//lastNumber = Pacman.mapa[this.getPosX()][this.getPosY()];
						// DEATH
						// DEATH
						if (this.getPosX() == c.getpacx() && this.getPosY() == c.getpacy()) {
							this.setEat(true);
						}if (this.getDie()==true&&this.getEat()==false) {
							MapaFantasmas.mapaF[this.getPosX()][this.getPosY()] = 28;//panic
							this.setMovDone(true);
						}else if (this.getDie() == true&&this.getEat()==true) {
							MapaFantasmas.mapaF[this.getPosX()][this.getPosY()] = 33;//ojos
							this.setMovDone(true);															
							// ALIVE
						} else if (this.getDie() == false) {

							MapaFantasmas.mapaF[this.getPosX()][this.getPosY()] = imgI;
							this.setMovDone(true);

						} else {
							this.setMovDone(true);
						}
					}

					break;
				case 4: // RIGHT MOV
					if (Pacman.mapa[this.getPosX()][this.getPosY() + 1] != 1
							&& Pacman.mapa[this.getPosX()][this.getPosY() + 1] != 22
							/*&& !ghostWall.contains(Pacman.mapa[this.getPosX()][this.getPosY() + 1])*/
					/* && returningHome==false */) {// can he move right?

						this.operaPos("+", "y");
						//lastNumber = Pacman.mapa[this.getPosX()][this.getPosY()];
						// DEATH
						if (this.getPosX() == c.getpacx() && this.getPosY() == c.getpacy()) {
							this.setEat(true);
						}if (this.getDie()==true&&this.getEat()==false) {
							MapaFantasmas.mapaF[this.getPosX()][this.getPosY()] = 28;//panic
							this.setMovDone(true);
						}else if (this.getDie() == true&&this.getEat()==true) {
							MapaFantasmas.mapaF[this.getPosX()][this.getPosY()] = 33;//ojos
							this.setMovDone(true);															
							// ALIVE
						} else if (this.getDie() == false) {
							MapaFantasmas.mapaF[this.getPosX()][this.getPosY()] = imgD;
							this.setMovDone(true);
						} else {
							this.setMovDone(true);
						}
					}
					break;
				}
			}
		}
	}
	
	public void listaArraysV() {
		


	}
		
		
	public void dijkstra() {
		destino = new Array [positionHomeX][positionHomeY];
		pActual = new Array [this.posX][this.posY];
		origen = new Array [this.posX][this.posY];
		iteraciones=0;
		int contadorPeso1;
		
		
		
		
		
		System.out.println(Arrays.toString(destino));
		System.out.println(Arrays.toString(pActual));
		System.out.println(Arrays.toString(origen));
		while (!pActual.equals(destino)) {
			//comprobar hacia donde voy
			if (MapaFantasmas.mapaF[this.posX+1][this.posY]!=1||MapaFantasmas.mapaF[this.posX+1][this.posY]!=-1) {// abajo
				//while (MapaFantasmas.mapaF[this.posX][this.posY]!= listaArrays.contains[i][j]) {
					
				}
			}
	}
	
			
		
	
}