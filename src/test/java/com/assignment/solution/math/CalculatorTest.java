package com.assignment.solution.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.InputMismatchException;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	Calculator calc = new Calculator();
	
	@Test
	public void testGetMax() {
		assertEquals("7 6 4", calc.calculateMax(Arrays.asList(1,2,3,6,7,4), 3));
		assertEquals("10 9 8 8 7 5", calc.calculateMax(Arrays.asList(10,3,2,8,4,5,7,8,9), 6));
		assertEquals("11 9 8 8 8 7 5 4 3 2 1", calc.calculateMax(Arrays.asList(1,3,2,8,4,5,7,8,9,11,8), 11));
	}
	
	@Test
	public void testGetMaxException() {
		assertThrows(InputMismatchException.class, () -> {
			calc.calculateMax(Arrays.asList(), 3);
		});
		
		assertThrows(InputMismatchException.class, () -> {
			calc.calculateMax(Arrays.asList(1,4,2,7,6), 7);
		});
	}
	
	@Test
	public void testGetMin() {
		assertEquals("1 2 3", calc.calculateMin(Arrays.asList(1,2,3,6,7,4), 3));
		assertEquals("2 3 4 5 7 8", calc.calculateMin(Arrays.asList(10,3,2,8,4,5,7,8,9), 6));
		assertEquals("1 2 3 4 5 7 8 8 8 9 11", calc.calculateMin(Arrays.asList(1,3,2,8,4,5,7,8,9,11,8), 11));
	}
	
	@Test
	public void testGetMinException() {
		assertThrows(InputMismatchException.class, () -> {
			calc.calculateMin(Arrays.asList(), 3);
		});
		
		assertThrows(InputMismatchException.class, () -> {
			calc.calculateMin(Arrays.asList(1,4,2,7,6), 7);
		});
	}
	
	@Test
	public void testGetAverage() {
		assertEquals("3.8", calc.calculateAvg(Arrays.asList(1,2,3,6,7,4)));
		assertEquals("6.2", calc.calculateAvg(Arrays.asList(10,3,2,8,4,5,7,8,9)));
		assertEquals("6.0", calc.calculateAvg(Arrays.asList(1,3,2,8,4,5,7,8,9,11,8)));
	}
	
	@Test
	public void testGetAvgException() {
		assertThrows(InputMismatchException.class, () -> {
			calc.calculateAvg(Arrays.asList());
		});
	}
	
	@Test
	public void testGetMedian() {
		assertEquals("3.5", calc.calculateMedian(Arrays.asList(1,2,3,6,7,4)));
		assertEquals("7.0", calc.calculateMedian(Arrays.asList(10,3,2,8,4,5,7,8,9)));
	}
	
	@Test
	public void testGetMedianException() {
		assertThrows(InputMismatchException.class, () -> {
			calc.calculateMedian(Arrays.asList());
		});
	}
	
	@Test
	public void testGetQthPercentile() {
		assertEquals("50", calc.calculateQthPercentile(Arrays.asList(50,15,35,20,40), 100));
		assertEquals("35", calc.calculateQthPercentile(Arrays.asList(50,15,35,20,40), 50));
		assertEquals("20", calc.calculateQthPercentile(Arrays.asList(50,15,35,20,40), 40));
		assertEquals("20", calc.calculateQthPercentile(Arrays.asList(50,15,35,20,40), 30));
		assertEquals("15", calc.calculateQthPercentile(Arrays.asList(50,15,35,20,40), 5));
		assertEquals("15", calc.calculateQthPercentile(Arrays.asList(6,3,8,7,8,13,10,20,16,15), 75));
		assertEquals("8", calc.calculateQthPercentile(Arrays.asList(6,3,8,7,8,13,10,20,16,15), 50));
		assertEquals("7", calc.calculateQthPercentile(Arrays.asList(6,3,8,7,8,13,10,20,16,15), 25));
	}
	
	@Test
	public void testGetQthPercentileException() {
		assertThrows(InputMismatchException.class, () -> {
			calc.calculateQthPercentile(Arrays.asList(), 3);
		});
		
		assertThrows(InputMismatchException.class, () -> {
			calc.calculateQthPercentile(Arrays.asList(1,4,2,7,6), 102);
		});
	}

}
