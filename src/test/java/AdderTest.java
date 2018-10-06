import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdderTest {
	
	
	@Test
	public void tesDiff() {
		int a = 2;
		int b = 1;
		
		Adder adder = new Adder();
		int sum = adder.getSum(a, b);
		assertEquals(sum, 1);
	}
	
	
	@Test
	public void testDefault() {
		Adder adder = new Adder();
		int sum = adder.getDefaultSum();
		assertEquals(sum, 10);
	}
	
	@Test
	public void testSum() {
		int a = 3;
		int b = 4;
		
		Adder adder = new Adder();
		int sum = adder.getSum(a,  b);
		assertEquals(sum, 7);
	}
	
	@Test
	public void testQuotient() {
		int a = 4;
		int b = 0;
		
		Adder adder = new Adder();
		int sum = adder.getQuotient(a, b);
		assertEquals(sum, 2);
	}
	
	
	
}
