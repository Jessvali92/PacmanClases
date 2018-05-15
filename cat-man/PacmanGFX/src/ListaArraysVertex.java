import java.util.ArrayList;

public class ListaArraysVertex {//posiciones de los vertices

	public ListaArraysVertex() {
		
	}
	
	
	public ArrayList<Integer[]> getConexiones() {
		ArrayList<Integer[]> listaArraysCone = new ArrayList<Integer[]>();
		
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
		
		return listaArraysCone;
		
	}
	
	public ArrayList<Integer[]> getCoordenadas() {
		
		ArrayList<Integer[]> listaArrays = new ArrayList<Integer[]>();
		
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
		
        return listaArrays;
 
        
	}
	

}
