import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdderTest {
	
	@Test
	public void testDefault() {
		Adder adder = new Adder();
		int sum = adder.getDefaultSum();
		assertEquals(sum, 10);
	}
	
	
	@Test
	public void testDefault2() {
		Adder adder = new Adder();
		int sum = adder.getDefaultSum();
		assertEquals(sum, 5);
	}
	
	
	@Test
	public void testSum() {
		int a = 3;
		int b = 4;
		
		Adder adder = new Adder();
		int sum = adder.getSum(a,  b);
		assertEquals(sum, 7);
	}
	
	
	
}
