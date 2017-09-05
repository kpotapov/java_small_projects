package kpotapov.forkjoin;

import static kpotapov.forkjoin.ForkJoinSample.getFibonacciNumber;
import static org.testng.Assert.*;

public class ForkJoinSampleTest {

	/** A test that a fibonacciNumber calculation should not depend on amount of threads
	 */
	@org.testng.annotations.Test
	public void testGetFibonacciNumber() throws Exception {
		assertEquals(new Integer(6765), getFibonacciNumber(20, 10));
		assertEquals(new Integer(6765), getFibonacciNumber(20, 40));
		assertEquals(new Integer(6765), getFibonacciNumber(20, 2));
	}

}