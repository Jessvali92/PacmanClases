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
	private int[][] destino;
	private Array[][] pAnterior;
	private Array[][] origen;
	private int iteraciones;
	public String op = "";
	int vortex = 0;
	ArrayList<Boolean> banderas = new ArrayList<Boolean>();
	ArrayList<String> posNxtMove = new ArrayList<String>();
	ArrayList<Integer[]> listaArraysCone;
	ArrayList<Integer[]> listaArrays;
	ArrayList<Integer[]> listaArrayPosActual;
	FantasmasFirstMove color;
	private Boolean verticeEncontrado=false;
	Integer[] posicionActual;
	
	
	
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
		this.noDijkstra();	
			/*this.know(c);
			if (returningHome==false){
				
				//this.move(c);				
			}else {
				this.returnHome();
			}
			this.know(c);*/
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
			}if (tiempobolagorda > 55) {
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
	
	public void caminoVectores(int vectorEncontrado, int destino) {
		int numFinal= destino;
		int numActual=vectorEncontrado;
		if (numActual==numFinal) {
			System.out.println("si");
			
		}else {
			
			
			System.out.println("no");
		}
		
		
		
	}
	
	public void noDijkstra() {
		System.out.println("entra dj");
		initListas();
		origen = new Array [this.posX][this.posY];
		iteraciones=0;
		/*listaArraysCone.get(0)[0]= 0; --> modificar el array 0 del indice 0*/
		while (MapaFantasmas.mapaF[this.posX][this.posY]!=MapaFantasmas.mapaF[positionHomeX][positionHomeY]) {
			System.out.println("entro while");
			pAnterior = new Array [this.posX][this.posY];
			//comprobar hacia donde voy
			if (MapaFantasmas.mapaF[this.posX+1][this.posY]!=1||MapaFantasmas.mapaF[this.posX+1][this.posY]!=-1) {// abajo
				while (!verticeEncontrado) {//mientras no hayas encontrado coordenadas de vertice
					posicionActual = new Integer[]{this.posX,this.posY};
					System.out.println("posAc"+posicionActual[0]);
					for (int i=0; i<listaArrays.size();i++) {						
						if (listaArrays.get(i)[0]==posicionActual[0]&&listaArrays.get(i)[1]==posicionActual[1]) {//si coincide llegas a un vertice	
							//System.out.println("vector encontrado(indice: "+i+" )");//numero del vertice encontrado		
							System.out.println(listaArraysCone.get(traductor(this.posX,this.posY)));//vertice encontrado y posicion
							verticeEncontrado=true;
							i=listaArrays.size();//cambiar a while algun dia	
						}				
					}
					if (verticeEncontrado==false) {//no entra si ha encontrado el vertice
						System.out.println("entra else");
						//MapaFantasmas.mapaF[this.posX][this.posY]=-1;//tachar posicion pasada
						this.operaPos("+", "x");
						verticeEncontrado=false;
					}
				}
				//despues de comprobar las coordenadas
			}else {
				System.out.println("abajo no se puede");
			}			
			if (MapaFantasmas.mapaF[this.posX-1][this.posY]!=1||MapaFantasmas.mapaF[this.posX-1][this.posY]!=-1) {// arriba
				while (!verticeEncontrado) {//mientras no hayas encontrado coordenadas de vertice
					posicionActual = new Integer[]{this.posX,this.posY};
					System.out.println("posAc"+posicionActual[0]);
					for (int i=0; i<listaArrays.size();i++) {						
						if (listaArrays.get(i)[0]==posicionActual[0]&&listaArrays.get(i)[1]==posicionActual[1]) {//si coincide llegas a un vertice	
							//System.out.println("vector encontrado(indice: "+i+" )");//numero del vertice encontrado		
							System.out.println(listaArraysCone.get(traductor(this.posX,this.posY)));//vertice encontrado y posicion
							verticeEncontrado=true;
							i=listaArrays.size();//cambiar a while algun dia
						}				
					}
					if (verticeEncontrado==false) {//no entra si ha encontrado el vertice
						System.out.println("entra else");					
						//MapaFantasmas.mapaF[this.posX][this.posY]=-1;//tachar posicion pasada
						this.operaPos("-", "x");
						verticeEncontrado=false;
					}
				}
				//despues de comprobar las coordenadas
			}else {
				System.out.println("arriba no se puede");
			}
			if (MapaFantasmas.mapaF[this.posX][this.posY+1]!=1||MapaFantasmas.mapaF[this.posX][this.posY+1]!=-1) {// derecha
				while (!verticeEncontrado) {//mientras no hayas encontrado coordenadas de vertice
					posicionActual = new Integer[]{this.posX,this.posY};
					System.out.println("posAc"+posicionActual[0]);
					for (int i=0; i<listaArrays.size();i++) {						
						if (listaArrays.get(i)[0]==posicionActual[0]&&listaArrays.get(i)[1]==posicionActual[1]) {//si coincide llegas a un vertice	
							//System.out.println("vector encontrado(indice: "+i+" )");//numero del vertice encontrado		
							System.out.println(listaArraysCone.get(traductor(this.posX,this.posY)));//vertice encontrado y posicion
							verticeEncontrado=true;
							i=listaArrays.size();//cambiar a while algun dia
						}				
					}
					if (verticeEncontrado==false) {//no entra si ha encontrado el vertice
						System.out.println("entra else");						
						//MapaFantasmas.mapaF[this.posX][this.posY]=-1;//tachar posicion pasada
						this.operaPos("+", "y");
						verticeEncontrado=false;
					}
				}
				//despues de comprobar las coordenadas
			}else {
				System.out.println("derecha no se puede");
			}
			if (MapaFantasmas.mapaF[this.posX][this.posY-1]!=1||MapaFantasmas.mapaF[this.posX][this.posY-1]!=-1) {// izq
				while (!verticeEncontrado) {//mientras no hayas encontrado coordenadas de vertice
					posicionActual = new Integer[]{this.posX,this.posY};
					System.out.println("posAc"+posicionActual[0]);
					for (int i=0; i<listaArrays.size();i++) {						
						if (listaArrays.get(i)[0]==posicionActual[0]&&listaArrays.get(i)[1]==posicionActual[1]) {//si coincide llegas a un vertice	
							//System.out.println("vector encontrado(indice: "+i+" )");//numero del vertice encontrado		
							System.out.println(listaArraysCone.get(traductor(this.posX,this.posY)));//vertice encontrado y posicion
							verticeEncontrado=true;
							i=listaArrays.size();//cambiar a while algun dia
						}				
					}
					if (verticeEncontrado==false) {//no entra si ha encontrado el vertice
						System.out.println("entra else");						
						//MapaFantasmas.mapaF[this.posX][this.posY]=-1;//tachar posicion pasada
						this.operaPos("-", "y");
						verticeEncontrado=false;
					}
				}
				//despues de comprobar las coordenadas
			}else {
				System.out.println("izquierda no se puede");
			}
		}
	}
	
	private int traductor(int x, int y) {
		
		int numeroVortice;
		
		int mapa[][] = {

				{1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1},
				{1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	2,	1,	1,	3,	0,	0,	0,	0,	0,	4,	0,	0,	0,	0,	5,	1},
				{1,	0,	1,	1,	1,	1,	0,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	0,	1,	1,	1,	1,	0,	1},
				{1,	2,	1,	1,	1,	1,	0,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	0,	1,	1,	1,	1,	2,	1},
				{1,	0,	1,	1,	1,	1,	0,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	0,	1,	1,	1,	1,	0,	1},
				{1,	6,	0,	0,	0,	0,	7,	0,	0,	8,	0,	0,	9,	0,	0,	10,	0,	0,	11,	0,	0,	12,	0,	0,	0,	0,	13,	1},
				{1,	0,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	0,	1},
				{1,	0,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	0,	1},
				{1,	14,	0,	0,	0,	0,	15,	1,	1,	16,	0,	0,	17,	1,	1,	18,	0,	0,	19,	1,	1,	20,	0,	0,	0,	0,	21,	1},
				{1,	1,	1,	1,	1,	1,	0,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	0,	1,	1,	1,	1,	1,	1},
				{1,	1,	1,	1,	1,	1,	0,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	0,	1,	1,	1,	1,	1,	1},
				{1,	1,	1,	1,	1,	1,	0,	1,	1,	22,	0,	0,	23,	3,	3,	24,	0,	0,	25,	1,	1,	0,	1,	1,	1,	1,	1,	1},
				{1,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	3,	3,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	1},
				{1,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	20,	20,	20,	20,	20,	20,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	1},
				{1,	0,	0,	0,	0,	0,	26,	0,	0,	27,	1,	20,	20,	20,	20,	20,	20,	1,	28,	0,	0,	29,	0,	0,	0,	0,	0,	1},
				{1,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	20,	20,	20,	20,	20,	20,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	1},
				{1,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	1},
				{1,	1,	1,	1,	1,	1,	0,	1,	1,	30,	0,	0,	0,	0,	0,	0,	0,	0,	31,	1,	1,	0,	1,	1,	1,	1,	1,	1},
				{1,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	1},
				{1,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	1},
				{1,	32,	0,	0,	0,	0,	33,	0,	0,	34,	0,	0,	35,	1,	1,	36,	0,	0,	37,	0,	0,	38,	0,	0,	0,	0,	39,	1},
				{1,	0,	1,	1,	1,	1,	0,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	0,	1,	1,	1,	1,	0,	1},
				{1,	2,	1,	1,	1,	1,	0,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	0,	1,	1,	1,	1,	2,	1},
				{1,	40,	0,	41,	1,	1,	42,	0,	0,	43,	0,	0,	44,	0,	0,	45,	0,	0,	46,	0,	0,	47,	1,	1,	48,	0,	49,	1},
				{1,	1,	1,	0,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	0,	1,	1,	1},
				{1,	1,	1,	0,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	0,	1,	1,	1},
				{1,	50,	0,	51,	0,	0,	52,	1,	1,	53,	0,	0,	54,	1,	1,	55,	0,	0,	56,	1,	1,	57,	0,	0,	58,	0,	59,	1},
				{1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1},
				{1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1},
				{1,	60,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	61,	0,	0,	62,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	63,	1},
				{1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1},

		};
		
		numeroVortice = mapa[x][y];
		
		return numeroVortice;
		
		
		
	}

	
	
	
	public void pruebaComparar2() {
		
		
		
	}
	
	
	
	
	public boolean initListas () {
		listaArraysCone = new ArrayList<Integer[]>();
		listaArrays = new ArrayList<Integer[]>();
		//listaArrayPosActual = new ArrayList<Integer[]>();
	
		
		
		
		//vectores conexiones
		
		
		listaArraysCone.add(new Integer[]{1,6});//index: 0 
		listaArraysCone.add(new Integer[]{0,2,7});//1
		listaArraysCone.add(new Integer[]{1,9});//2
		listaArraysCone.add(new Integer[]{4,10});//3
		listaArraysCone.add(new Integer[]{3,5,12});//4
		listaArraysCone.add(new Integer[]{4,13});//5
      
		listaArraysCone.add(new Integer[]{0,7,14});//6
		listaArraysCone.add(new Integer[]{1,6,8,15});//7
		listaArraysCone.add(new Integer[]{7,9,16});//8
		listaArraysCone.add(new Integer[]{2,8,10});//9
		listaArraysCone.add(new Integer[]{3,9,11});//10
		listaArraysCone.add(new Integer[]{10,12,19});//11
		listaArraysCone.add(new Integer[]{4,11,13,20});//12
		listaArraysCone.add(new Integer[]{5,12,21});//13
        
		listaArraysCone.add(new Integer[]{6,15});//14
		listaArraysCone.add(new Integer[]{7,14,26});//15
		listaArraysCone.add(new Integer[]{8,17});//16
		listaArraysCone.add(new Integer[]{16,23});//17
		listaArraysCone.add(new Integer[]{19,24});//18
		listaArraysCone.add(new Integer[]{11,18});//19
		listaArraysCone.add(new Integer[]{12,21,29});//20
		listaArraysCone.add(new Integer[]{13,20});//21

		listaArraysCone.add(new Integer[]{23,27});//22
		listaArraysCone.add(new Integer[]{17,22,24});//23
		listaArraysCone.add(new Integer[]{18,23,25});//24
		listaArraysCone.add(new Integer[]{24,28});//25
        
      
		listaArraysCone.add(new Integer[]{15,27,33});//26
		listaArraysCone.add(new Integer[]{22,26,30});//27
		listaArraysCone.add(new Integer[]{25,29,31});//28
		listaArraysCone.add(new Integer[]{20,38});//29
        
		listaArraysCone.add(new Integer[]{27,31,34});//30
		listaArraysCone.add(new Integer[]{28,30,37});//31
        
		listaArraysCone.add(new Integer[]{33,40});//32
		listaArraysCone.add(new Integer[]{26,32,34,42});//33
		listaArraysCone.add(new Integer[]{30,33,35});//34
		listaArraysCone.add(new Integer[]{34,44});//35
		listaArraysCone.add(new Integer[]{37,45});//36
		listaArraysCone.add(new Integer[]{31,36,38});//37
		listaArraysCone.add(new Integer[]{29,37,39,47});//38
		listaArraysCone.add(new Integer[]{38,49});//39
        
        
		listaArraysCone.add(new Integer[]{32,41});//40
		listaArraysCone.add(new Integer[]{40,51});//41
		listaArraysCone.add(new Integer[]{33,43,52});//42
		listaArraysCone.add(new Integer[]{42,44});//43
		listaArraysCone.add(new Integer[]{35,43,45});//44
		listaArraysCone.add(new Integer[]{36,44,46});//45
		listaArraysCone.add(new Integer[]{45,47,56});//46
		listaArraysCone.add(new Integer[]{38,46,57});//47
		listaArraysCone.add(new Integer[]{49,58});//48
		listaArraysCone.add(new Integer[]{39,48});//49
        
        
		listaArraysCone.add(new Integer[]{51,60});//50
		listaArraysCone.add(new Integer[]{41,50,52});//51
		listaArraysCone.add(new Integer[]{42,51});//52
		listaArraysCone.add(new Integer[]{43,54});//53
		
		listaArraysCone.add(new Integer[]{53,61});//54
		listaArraysCone.add(new Integer[]{56,62});//55
		listaArraysCone.add(new Integer[]{46,55});//56
		listaArraysCone.add(new Integer[]{47,58});//57
		listaArraysCone.add(new Integer[]{48,57,59});//58
		listaArraysCone.add(new Integer[]{58,63});//59
		
		listaArraysCone.add(new Integer[]{50,61});//60
		listaArraysCone.add(new Integer[]{54,60,62});//61
		listaArraysCone.add(new Integer[]{55,61,63});//62
		listaArraysCone.add(new Integer[]{59,62});//63
		
		
		
		
		
        //vectores posiciones
		
        listaArrays.add(new Integer[]{1,1});//index: 0
        listaArrays.add(new Integer[]{1,6});
        listaArrays.add(new Integer[]{1,12});
        listaArrays.add(new Integer[]{1,15});
        listaArrays.add(new Integer[]{1,21});
        listaArrays.add(new Integer[]{1,26});
      
        listaArrays.add(new Integer[]{5,1});
        listaArrays.add(new Integer[]{5,6});
        listaArrays.add(new Integer[]{5,9});
        listaArrays.add(new Integer[]{5,12});
        listaArrays.add(new Integer[]{5,15});
        listaArrays.add(new Integer[]{5,18});
        listaArrays.add(new Integer[]{5,21});
        listaArrays.add(new Integer[]{5,26});
        
        listaArrays.add(new Integer[]{8,1});
        listaArrays.add(new Integer[]{8,6});
        listaArrays.add(new Integer[]{8,9});
        listaArrays.add(new Integer[]{8,12});
        listaArrays.add(new Integer[]{8,15});
        listaArrays.add(new Integer[]{8,18});
        listaArrays.add(new Integer[]{8,21});
        listaArrays.add(new Integer[]{8,26});

        listaArrays.add(new Integer[]{11,9});
        listaArrays.add(new Integer[]{11,12});
        listaArrays.add(new Integer[]{11,15});
        listaArrays.add(new Integer[]{11,18});
        
      
        listaArrays.add(new Integer[]{14,6});
        listaArrays.add(new Integer[]{14,9});
        listaArrays.add(new Integer[]{14,18});
        listaArrays.add(new Integer[]{14,21});
        
        listaArrays.add(new Integer[]{17,9});
        listaArrays.add(new Integer[]{17,18});
        
        listaArrays.add(new Integer[]{20,1});
        listaArrays.add(new Integer[]{20,6});
        listaArrays.add(new Integer[]{20,9});
        listaArrays.add(new Integer[]{20,12});
        listaArrays.add(new Integer[]{20,15});
        listaArrays.add(new Integer[]{20,18});
        listaArrays.add(new Integer[]{20,21});
        listaArrays.add(new Integer[]{20,26});
        
        
        listaArrays.add(new Integer[]{23,1});
        listaArrays.add(new Integer[]{23,3});
        listaArrays.add(new Integer[]{23,6});
        listaArrays.add(new Integer[]{23,9});
        listaArrays.add(new Integer[]{23,12});
        listaArrays.add(new Integer[]{23,15});
        listaArrays.add(new Integer[]{23,18});
        listaArrays.add(new Integer[]{23,21});
        listaArrays.add(new Integer[]{23,24});
        listaArrays.add(new Integer[]{23,26});
        
        listaArrays.add(new Integer[]{26,1});
        listaArrays.add(new Integer[]{26,3});
        listaArrays.add(new Integer[]{26,6});
        listaArrays.add(new Integer[]{26,9});
        listaArrays.add(new Integer[]{26,12});
        listaArrays.add(new Integer[]{26,15});
        listaArrays.add(new Integer[]{26,18});
        listaArrays.add(new Integer[]{26,21});
        listaArrays.add(new Integer[]{26,24});
        listaArrays.add(new Integer[]{26,26});
        
        
        listaArrays.add(new Integer[]{29,1});
        listaArrays.add(new Integer[]{29,12});
        listaArrays.add(new Integer[]{29,15});
        listaArrays.add(new Integer[]{29,26});//index: 63
		
        return true;
 
        
	}
	
	
	
}