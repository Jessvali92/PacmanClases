package problema;

/** 
 * 
 * @author Qukita92
 * @version 1.0
 * @since Java 8.0
 * 
 * 
 */

public class problema1 {
		/**
		 * 
		 * problema1: Clase Buscadora de Nakamas
		 * @param args main del problema con Syso para el resultado por consola
		 * 
		 */

	public static void main(String[] args) {
		System.out.println(decodificadorDeNakamas(""));
		}
		
		/**
		 * 
		 * @param cadena String Lee una frase y cuenta sus x
		 *  @return "Thousand Sunny","BARTO CLUB","Marine"
		 */
	
	public static String decodificadorDeNakamas(String cadena) {
		int cuentaNakama=0; 
		String codigoSecreto="x";
	        int contador[]={0};
	        
	 
	        // recorrer la cadena todas las letras
	        
	        for(int i=0;i<cadena.length();i++) {
	 
	            // recorrer y comparar con las x
	        	
	            for(int j=0;j<codigoSecreto.length();j++) {
	            	
	                if(cadena.charAt(i)==codigoSecreto.charAt(j)) {
	                	
	                    // contador ++ para cuando encuentre vocal
	                	
	                    contador[j]++;
	                }
	            }
	        }
	 
	        for(int i=0;i<codigoSecreto.length();i++) {
	        cuentaNakama = contador[i];
	        
	        }
	        
	        if (cuentaNakama==9) {
            	return "Thousand Sunny";			        
	        }else if (cuentaNakama>9) {
	        	return "BARTO CLUB";	
	        }else {
	        	return "Marine";	
	        }   
	}	
}


