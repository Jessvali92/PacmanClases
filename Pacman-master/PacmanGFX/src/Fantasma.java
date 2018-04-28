import java.util.ArrayList;

public class Fantasma {

	public Integer posX;
	public Integer posY;
	private Boolean movDone = false;
	private Boolean firstTime = false;
	private Boolean die = false;
	private int lastNumber = 20;
	private int tiempobolagorda = 0;
	private int imgAR;
	private int imgAB;
	private int imgI;
	private int imgD;
	static ArrayList<Integer> ghostWall = new ArrayList<Integer>();
	static boolean red = false;
	public boolean returningHome = false;

	/*
	 * "rojoAR.png","rojoAB.png","rojoI.png","RojoD.png",//3,4,5,6 ROJO
	 * 
	 * "celesteAR.png","celesteAB.png","celesteI.png","celesteD.png",//7,8,9,10
	 * CELESTE
	 * 
	 * "rosadoAR.png","rosadoAB.png","rosadoI.png","rosadoD.png",//11,12,13,14
	 * ROSADO
	 * 
	 * "naranjaAR.png","naranjaAB.png","naranjaI.png","naranjaD.png",//15,16,17,18
	 * NARANJA
	 */

	public void initGhostWall() {
		for (int i = 3; i < 18; i++) {
			ghostWall.add(i);
		}
	}

	public Fantasma() { // en caso de usar fantasma sin posiciones-imagenes
		initGhostWall();
	}

	public Fantasma(Integer posicionX, Integer posicionY, int AR, int AB, int I, int D, int lastNumber) {

		initGhostWall();
		this.posX = posicionX;
		this.posY = posicionY;
		imgAR = AR;
		imgAB = AB;
		imgI = I;
		imgD = D;
		this.lastNumber = lastNumber;

	}

	public Integer getPosX() {
		return posX;
	}

	public void setPosX(Integer posicionX) {
		this.posX = posicionX;
	}

	public Integer getPosY() {
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

	public void hazLoTuyo() {
		// TODO Auto-generated method stub

		this.move();
		this.know();

	}

	private void know() {

		if (die) {
			tiempobolagorda++;
			if (tiempobolagorda > 30) {
				die = false;
				tiempobolagorda = 0;
				// System.out.println(tiempobolagorda);
			}

			if (posX == Pacman.pacx && posY == Pacman.pacy) {

				// Se comen al fantasma, ya lo haras.
			}

		} else {
			if (posX == Pacman.pacx && posY == Pacman.pacy) {

				Pacman.finjuego = true;
				Pacman.fin = true;
			}
		}
	}

	private boolean noDijkstra(boolean b) {

		// camino siguiente

		return Coords.calcCoods(this.getPosX(), this.getPosY());

	}

	/*private void lastStep() { // desde la coordenada a casa
		
	}
	
	private void firstStep() { // primeros pasos de los fantasmas
		
	}*/

	
	private void sVortex() { //funcion que mueve hasta el vortice
		
		//TODO convertir a global
		int x = getPosX();
		int y = getPosY();
		int positionHomeX = 11;
		int positionHomeY = 14;
		String option = "";
		int vortex = 0;
		/**************************/
		returningHome = true;
		if (noDijkstra(false)) {// no encuentra el vortice
			
			System.out.println("Esquinas encontradas: " + vortex);
			switch (option) {
			case "DE":
				if (positionHomeY < y && Pacman.map[this.getPosX() + 1][this.getPosY()] != 1) { // right
					this.operaPos("+", "y");
					System.out.println("vuelve derecha");
				}
				break;
		
			case "IZ":
				if (positionHomeY > y && Pacman.map[this.getPosX() - 1][this.getPosY()] != 1) { // left
					this.operaPos("-", "y");
					System.out.println("vuelve izquierda");
				}
				break;
		
			case "AR":
				if (positionHomeX > x && Pacman.map[this.getPosX() - 1][this.getPosY()] != 1) { // up
					this.operaPos("-", "x");
					System.out.println("vuelve arriba");
		
				}
				break;
		
			case "AB":
				if (positionHomeX < x && Pacman.map[this.getPosX() + 1][this.getPosY()] != 1) { // down
					this.operaPos("+", "x");
					System.out.println("vuelve abajo");
				}
				break;
			}
		}else {
			//Ha encontrado el vortice
		}
	}
		
	
	private void returnHome() { //funcion hacia la nueva direccion
		
		//TODO convertir a global
		int x = getPosX();
		int y = getPosY();
		int positionHomeX = 11;
		int positionHomeY = 14;
		String option = "";
		int vortex = 0;
		/**************************/
		// get next position
		
		int XAR = Pacman.map[x - 1][y];
		int XAB = Pacman.map[x + 1][y];
		int YIZ = Pacman.map[x][y - 1];
		int YDE = Pacman.map[x][y + 1];
		
		// check next position

		if (XAR == 0 || XAR == 20) { 
			option = "AR";
			vortex++;
		} else if (XAB == 0 || XAB == 20) {
			option = "AB";
			vortex++;
		} else if (YIZ == 0 || YIZ == 20) {
			option = "IZ";
			vortex++;
		} else if (YDE == 0 || YDE == 20) {
			option = "DE";
			vortex++;
		}
	
	
		
		returningHome = true;
		

		// saber si hay que ir hacia la derecha/izquierda o arriba/abajo
		/*
		 * una funcion que avanza hacia la esquina
		 * una funcion que detecta en que direccion ir
		 * 
		 * casillas de alrededor si es 3 o mas es un cruce mathabs untilvortex();
		 * nodijkstra(); clase de coordenadas buscar primero un vertice de forma random
		 * conseguir hacer el camino mas corto posible
		 */

	}

	private void move() {

		Pacman.map[posX][posY] = lastNumber;
		movDone = false;
		if (returningHome) {
			returnHome();
		} else {
			while (!movDone) {
				int movF = (int) (Math.random() * (4) + 1);
				switch (movF) {
				case 1: // DOWN MOV
					if (Pacman.map[this.getPosX() + 1][this.getPosY()] != 1
							&& Pacman.map[this.getPosX() + 1][this.getPosY()] != 22
							&& !ghostWall.contains(Pacman.map[this.getPosX() + 1][this.getPosY()])) { // can he move down?

						this.operaPos("+", "x");
						lastNumber = Pacman.map[this.getPosX()][this.getPosY()];
						// DEATH
						if (this.getDie() == true) {
							Pacman.map[this.getPosX()][this.getPosY()] = 28;
							this.setMovDone(true);
							if (this.getPosX() == Pacman.pacx && this.getPosY() == Pacman.pacy) {
								Pacman.map[this.getPosX()][this.getPosY()] = 14;// el 14 es el rosa Cambiar																			
								sVortex();
								returnHome();
							}

							// ALIVE
						} else if (this.getDie() == false) {
							Pacman.map[this.getPosX()][this.getPosY()] = imgAB;
							this.setMovDone(true);
						} else {
							this.setMovDone(true);

						}
					}

					break;
				case 2: // UP MOV
					if (Pacman.map[this.getPosX() - 1][this.getPosY()] != 1
							&& !ghostWall.contains(Pacman.map[this.getPosX() - 1][this.getPosY()])) {// can he move up?

						this.operaPos("-", "x");
						lastNumber = Pacman.map[this.getPosX()][this.getPosY()];
						// DEATH
						if (this.getDie() == true) {
							Pacman.map[this.getPosX()][this.getPosY()] = 28;
							this.setMovDone(true);
							if (this.getPosX() == Pacman.pacx && this.getPosY() == Pacman.pacy) {
								Pacman.map[this.getPosX()][this.getPosY()] = 14;// el 14 es el rosa Cambiar 																			
								sVortex();
								returnHome();
							}
							// ALIVE

						} else if (this.getDie() == false) {
							Pacman.map[this.getPosX()][this.getPosY()] = imgAR;
							this.setMovDone(true);
						} else {
							this.setMovDone(true);

						}
					}

					break;
				case 3: // LEFT MOV
					if (Pacman.map[this.getPosX()][this.getPosY() - 1] != 1
							&& Pacman.map[this.getPosX()][this.getPosY() - 1] != 22
							&& !ghostWall.contains(Pacman.map[this.getPosX()][this.getPosY() - 1])
					/* && returningHome==false */) {// can he move left?

						this.operaPos("-", "y");
						lastNumber = Pacman.map[this.getPosX()][this.getPosY()];
						// DEATH
						if (this.getDie() == true) {
							Pacman.map[this.getPosX()][this.getPosY()] = 28;
							this.setMovDone(true);
							if (this.getPosX() == Pacman.pacx && this.getPosY() == Pacman.pacy) {
								Pacman.map[this.getPosX()][this.getPosY()] = 14;// el 14 es el rosa Cambiar																				
								sVortex();
								returnHome();
							}
							// ALIVE
						} else if (this.getDie() == false) {

							Pacman.map[this.getPosX()][this.getPosY()] = imgI;
							this.setMovDone(true);

						} else {
							this.setMovDone(true);
						}
					}

					break;
				case 4: // RIGHT MOV
					if (Pacman.map[this.getPosX()][this.getPosY() + 1] != 1
							&& Pacman.map[this.getPosX()][this.getPosY() + 1] != 22
							&& !ghostWall.contains(Pacman.map[this.getPosX()][this.getPosY() + 1])
					/* && returningHome==false */) {// can he move right?

						this.operaPos("+", "y");
						lastNumber = Pacman.map[this.getPosX()][this.getPosY()];
						// DEATH
						if (this.getDie() == true) {
							Pacman.map[this.getPosX()][this.getPosY()] = 28;
							this.setMovDone(true);
							if (this.getPosX() == Pacman.pacx && this.getPosY() == Pacman.pacy) {
								Pacman.map[this.getPosX()][this.getPosY()] = 14;// el 14 es el rosa Cambiar																				
								sVortex();
								returnHome();
							}
							// ALIVE
						} else if (this.getDie() == false) {
							Pacman.map[this.getPosX()][this.getPosY()] = imgD;
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

	

}
