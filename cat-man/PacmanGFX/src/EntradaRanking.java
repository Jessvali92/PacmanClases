
public class EntradaRanking implements Comparable{
	
	String nom;
	int punts;
	
	public EntradaRanking (String nom2, int punts2) {
		nom=nom2;
		punts=punts2;
	}
		
	@Override
	public int compareTo(Object arg0) {
		EntradaRanking er = (EntradaRanking) arg0;
		//Return negativo = mas pequeño. Return positivo = mas grande. Return 0 = iguales.
		return er.punts-this.punts;
	}
}
