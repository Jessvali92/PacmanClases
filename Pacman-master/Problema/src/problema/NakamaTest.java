package problema;

import static org.junit.Assert.*;

import org.junit.Test;

public class NakamaTest {

	@Test
	public void testDecodificadorDeNakamas() {
		
		String res = problema1.decodificadorDeNakamas("Estabamos en Texas tranquila hasta que un extraño grito a mi exmarido, exijia que Felix tuviera sexo con el, mi exmarido lo boxeo y pedimos un taxi");
		assertEquals("Thousand Sunny", res);
		
	}
	
	@Test
	public void testDecodificadorDeNakamas2() {
		
		String res = problema1.decodificadorDeNakamas("menos xx");
		assertEquals("Marine", res);
		
	}
	
	@Test
	public void testDecodificadorDeNakamas3() {
		
		String res = problema1.decodificadorDeNakamas("masxxxxxxxxxxxxxxxxxxxxxxxxx");
		assertEquals("BARTO CLUB", res);

	}
	
	@Test
	public void testDecodificadorDeNakamas4() {
		
		String res = problema1.decodificadorDeNakamas("XXXXXXXXXXXXXXXXXXX");
		assertEquals("Marine", res);

	}
	
	@Test
	public void testDecodificadorDeNakamas5() {
		
		String res = problema1.decodificadorDeNakamas(" ");
		assertEquals("Marine", res);
	}

}
