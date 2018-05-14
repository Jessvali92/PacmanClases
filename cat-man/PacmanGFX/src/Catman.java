
public class Catman {

	static Integer pacx;
	static Integer pacy;
	static boolean finjuego = false;
	static boolean desactivar3x1y = true;
	static boolean desactivar3x26y = true;
	static boolean desactivar23x1y = true;
	static boolean desactivar23x26y = true;
	static boolean comebola= false;
	
	public Catman (Integer posPacX, Integer posPacY) {
		pacx = posPacX;
		pacy = posPacY;
		
	}
	
	public Integer getpacx() {
		return pacx;
	}
	
	public void setpacx(Integer posPacX) {
		pacx = posPacX;
	}
	
	public Integer getpacy() {
		return pacy;
	}
	
	public void setpacy(Integer posPacY) {
		pacy = posPacY;
	}
		
	
	public void mueveteCatman() {
		// TODO Auto-generated method stub

		this.movePacman();
		this.teleport();
		this.doStuffcomprobarB();
	}
	
	private void teleport() {
		
		if (pacx==14 && pacy==1) {
			
			pacx = 14;
			pacy = 26;
			
			
			Pacman.mapa[14][1] = 20;
			
				
		}else if (pacx==14 && pacy==26) {
			
			pacx = 14;
			pacy = 1;
			
			Pacman.mapa[14][26] = 20;
		}
	}
	
	
	private void movePacman() {		
		
		boolean movDone = false;
		
		if(!finjuego) {
			
			while (!movDone) {
				// pac derecha
				if (Pacman.mov == 6) {
					if (Pacman.mapa[pacx][pacy+1]!=1) {
							Pacman.mapa[pacx][pacy] = 20;
							pacy++;
							Pacman.mapa[pacx][pacy] = 19;
					}
	
					// pac izquierda
				} else if (Pacman.mov == 4) {
						if (Pacman.mapa[pacx][pacy-1]!=1 /*&& map[pacx][pacy-1]!=21*/){
								Pacman.mapa[pacx][pacy] = 20;
								pacy--;
								Pacman.mapa[pacx][pacy] = 26;
						}
					// pac abajo
				} else if (Pacman.mov == 5) {
					if (Pacman.mapa[pacx+1][pacy]!=1) {
						Pacman.mapa[pacx][pacy] = 20;
							pacx++;
							Pacman.mapa[pacx][pacy] = 32;
							
					}else if (Pacman.mapa[pacx+1][pacy]==9) {
						Pacman.mapa[pacx][pacy] = 20;
						pacy--;
						Pacman.mapa[pacx][pacy] = 32;
					}
					
					// pac arriba
				} else if (Pacman.mov == 8) {
					if (Pacman.mapa[pacx-1][pacy]!=1) {
							Pacman.mapa[pacx][pacy] = 20;
							pacx--;
							Pacman.mapa[pacx][pacy] = 31;
					}
				
				}
				movDone = true;
			}			
		}
		
	}
	
	private void doStuffcomprobarB() {
		
		if (Pacman.mapa[pacx][pacy]==Pacman.mapa[3][1]&&desactivar3x1y) {
			comebola=true;
			for(Fantasma f : Pacman.listf) {
				f.setDie(true);
				
			}
			desactivar3x1y = false;
			
		}else if ( Pacman.mapa[pacx][pacy]==Pacman.mapa[3][26]&&desactivar3x26y) {
			comebola=true;
			for(Fantasma f : Pacman.listf) {
				f.setDie(true);
			}
			desactivar3x26y = false;
			
		}else if( Pacman.mapa[pacx][pacy]==Pacman.mapa[22][1]&&desactivar23x1y) {
			comebola=true;
			for(Fantasma f : Pacman.listf) {
				f.setDie(true);
			}
			desactivar23x1y = false;
		}else if (Pacman.mapa[pacx][pacy]==Pacman.mapa[22][26]&&desactivar23x26y) {
			comebola=true;
			for(Fantasma f : Pacman.listf) {
				f.setDie(true);
			}
			desactivar23x26y = false;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
