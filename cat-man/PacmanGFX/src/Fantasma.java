import java.awt.List;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.omg.Messaging.SyncScopeHelper;

public class Fantasma implements Serializable{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = -2088904766567638973L;
	/**
	 * 
	 */
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
	private boolean step = true;
	private boolean stepRed = true;
	private boolean stepBlue = true;
	private int contadorPasos=0;
	private boolean arriba =true;
	private boolean abajo= false;
	int vortex = 0;
	ArrayList<Boolean> banderas = new ArrayList<Boolean>();
	ArrayList<String> posNxtMove = new ArrayList<String>();
	ArrayList<Integer[]> listaArraysCone;
	ArrayList<Integer[]> listaArrays;
	ArrayList<Integer[]> listaArrayPosActual;
	FantasmasFirstMove color;
	private Boolean verticeEncontrado=false;
	Integer[] posicionActual;
	private int nuevoMov=1;
	private boolean mueve=false;
	private boolean nuevoActivo=false;
	private boolean primeraVez=false;
	
	
	
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
			if (step) {
				this.firstMoveFantasmas(c);
			}else if (returningHome==false){
				this.move(c);				
			}else {
				this.returnHome(c);//mover volviendo
				if(Pacman.mapa[this.posX][this.posY]==Pacman.mapa[positionHomeX][positionHomeY]) {
					//codigo que se mueve en casa y sale
					nuevoActivo=false;
					returningHome=false;
				}
				
			}
			this.know(c);
	}	
	
	private void firstMoveFantasmas(Catman c) {
		//comprobar que hayan salido de la casa
		if (this.color==FantasmasFirstMove.BLUE||this.color==FantasmasFirstMove.PINK) {
			System.out.println("colores PINK BLUE"+contadorPasos);
			if (contadorPasos<15) {
				if (nuevoMov==1) {	
					nuevoMov=2;
					move2(c);
					contadorPasos++;
				}else if (nuevoMov==2) {	
					nuevoMov=1;
					move2(c);
					contadorPasos++;
				}
			
			}else if (contadorPasos==15) {
				if(this.color==FantasmasFirstMove.BLUE) {
					nuevoMov=4;
					move2(c);
					contadorPasos++;
				}else {
					nuevoMov=2;
					move2(c);
					contadorPasos++;
				}
			
			}else if(contadorPasos>=16&&contadorPasos<=17){
				if(this.color==FantasmasFirstMove.BLUE) {
					nuevoMov=2;
					move2(c);
					contadorPasos++;
				}else {
					nuevoMov=2;
					move2(c);
					contadorPasos++;
				}
			}else if (contadorPasos==18){
				if(this.color==FantasmasFirstMove.BLUE) {
					nuevoMov=2;
					move2(c);
					contadorPasos++;
				}else {
					nuevoMov=4;
					move2(c);
					contadorPasos++;
				}
				
			}else {
				move(c);
				step=false;
			}
		
		}else if (this.color==FantasmasFirstMove.RED||this.color==FantasmasFirstMove.YELLOW) {
			System.out.println("colores PINK BLUE"+contadorPasos);
			if (contadorPasos<8) {
				if (nuevoMov==1) {	
					move2(c);
					contadorPasos++;
					nuevoMov=2;
				}else if (nuevoMov==2) {	
					move2(c);
					contadorPasos++;
					nuevoMov=1;
				
				}
			}else if (contadorPasos==8) {
				if(this.color==FantasmasFirstMove.RED) {
					nuevoMov=3;
					move2(c);
					contadorPasos++;
				}else {
					nuevoMov=2;
					move2(c);
					contadorPasos++;
				}
			
			}else if(contadorPasos>=9&&contadorPasos<=10){
				if(this.color==FantasmasFirstMove.RED) {
					nuevoMov=2;
					move2(c);
					contadorPasos++;
				}else {
					nuevoMov=2;
					move2(c);
					contadorPasos++;
				}
			}else if (contadorPasos==11){
				if(this.color==FantasmasFirstMove.RED) {
					nuevoMov=2;
					move2(c);
					contadorPasos++;
				}else {
					nuevoMov=4;
					move2(c);
					contadorPasos++;
				}
			}else {
				step=false;
				move(c);
			}
			
		}
	}

	

	private void know(Catman c) {
		if(c.isComebola()) {
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
				c.setFinjuego(true);
				Pacman.fin = true;
			}
		}
	}	

	

	

	

	private void move(Catman c) {
		movDone = false;
		int movF;
		while (!movDone) {
			if (nuevoActivo) {
				movF=nuevoMov;
			}else{
				movF = (int) (Math.random() * (4) + 1);
			}
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
						mueve=true;	

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
						mueve=true;	
					
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
						mueve=true;	
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
						mueve=true;	
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
	
	
	
	private void move2(Catman c) {
		movDone = false;
		while (!movDone) {
			int movF = nuevoMov;
			switch (movF) {
			case 1: // DOWN MOV
				if (Pacman.mapa[this.getPosX() + 1][this.getPosY()] != 1
						&& Pacman.mapa[this.getPosX() + 1][this.getPosY()] != 22) { 
					this.operaPos("+", "x");
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
				if (Pacman.mapa[this.getPosX() - 1][this.getPosY()] != 1) {
					this.operaPos("-", "x");
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
						&& Pacman.mapa[this.getPosX()][this.getPosY() - 1] != 22) {
					this.operaPos("-", "y");
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
						&& Pacman.mapa[this.getPosX()][this.getPosY() + 1] != 22) {
					this.operaPos("+", "y");
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

	
	private void returnHome(Catman c) {
		mueve=false;
		noDijkstra(c);
		
	}
	
	public void noDijkstra(Catman c) {
		int mov=0;
		int resultY=0;
		int resultX=0;
		boolean down=false;
		boolean up=false;
		boolean left=false;
		boolean right=false;
		
		if (Pacman.mapa[this.getPosX() + 1][this.getPosY()] != 1) { // DOWN MOV
			mov++;
			down=true;
			System.out.println("down");
		}if (Pacman.mapa[this.getPosX() - 1][this.getPosY()] != 1) {// UP
			mov++;
			up=true;
			System.out.println("up");
		}
		if (Pacman.mapa[this.getPosX()][this.getPosY() - 1] != 1) {//left
			mov++;
			left=true;
			System.out.println("left");
		}if (Pacman.mapa[this.getPosX()][this.getPosY() + 1] != 1) {//right
			mov++;
			right=true;
			System.out.println("right");
		}
		resultY = Math.abs(positionHomeY-this.posY);
		resultX = Math.abs(positionHomeX-this.posX);
		if (mov>=3) {//vertice mirar el lado mas lejos
			verticeEncontrado=true;
			primeraVez=true;
			System.out.println("direccion + 3 vertice encontrado");
			if (resultY>resultX) {
				if (positionHomeY>this.posY) {
					nuevoMov=4;
				}else {
					nuevoMov=3;
				}
				
			}else {
				if (positionHomeX>this.posX) {
					nuevoMov=1;
					
				}else {
					nuevoMov=2;
				}
				
			}
			System.out.println("nuevoMov: "+nuevoMov);
			nuevoActivo=true;
			move(c);			
		}else {
			
			nuevoActivo=true;
			//moverse al mas cercano de x o Y hasta llegar a vertice
			if (verticeEncontrado&&primeraVez) {
				if (left||right) {
					if(positionHomeY>this.posY) {
						nuevoMov=4; 
					}else {
						nuevoMov=3;
					}
						
				}else if (up||down) {
					if(positionHomeX>this.posX) {
						nuevoMov=1;
					}else {
						nuevoMov=2;
					}
				}
				primeraVez=false;
			}
			move(c);
			System.out.println("se movio hacia: "+nuevoMov);
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