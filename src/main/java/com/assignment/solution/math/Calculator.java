package com.assignment.solution.math;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.assignment.solution.ds.MaxHeap;
import com.assignment.solution.ds.MinHeap;

/**
 * Performs operations specified by Math APIs
 * 
 * @author Jyoti
 *
 */
@Component
public class Calculator {
	
	/**
	 * Builds a min heap of given numbers and returns q smallest numbers as String
	 * 
	 * @param numbers
	 * @param quantifier
	 * @return
	 */
	public String calculateMin(List<Integer> numbers,  int quantifier) {
		if (quantifier == 0)
			return null;
		int size = numbers.size();
		if (size == 0 || size < quantifier)
			throw new InputMismatchException("Invalid request arguments");
		
		MinHeap minHeap = new MinHeap(numbers.size());
		
		for (int num : numbers)
			minHeap.insert(num);
		
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < quantifier; i++)
			builder.append(String.valueOf(minHeap.poll())).append(" ");
		
		return builder.toString().trim();
	}
	
	/**
	 * Builds a max heap of given numbers and returns q largest numbers as String
	 * 
	 * @param numbers
	 * @param quantifier
	 * @return
	 */
	public String calculateMax(List<Integer> numbers,  int quantifier) {
		if (quantifier == 0)
			return null;
		int size = numbers.size();
		if (size == 0 || size < quantifier)
			throw new InputMismatchException("Invalid request arguments");
		
		MaxHeap maxHeap = new MaxHeap(numbers.size());
		
		for (int num : numbers)
			maxHeap.insert(num);
		
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < quantifier; i++)
			builder.append(String.valueOf(maxHeap.poll())).append(" ");
		
		return builder.toString().trim();
	}

	/**
	 * Calculates average of given numbers
	 * 
	 * @param numbers
	 * @return
	 */
	public String calculateAvg(List<Integer> numbers) {
		double size = numbers.size();
		if (size == 0)
			throw new InputMismatchException("Invalid request arguments");
		
		double sum = 0;
		for (int i = 0; i < size; i++)
			sum += numbers.get(i);
		
		// Setting precision of average to 1 decimal point
		String avg = String.format("%.1f", sum / size);
		
		return avg;
	}

	/**
	 * Calculates median of given numbers
	 * 
	 * @param numbers
	 * @return
	 */
	public String calculateMedian(List<Integer> numbers) {
		double size = numbers.size();
		if (size == 0)
			throw new InputMismatchException("Invalid request arguments");
		
		// Sort numbers in ascending order
		Collections.sort(numbers);
		
		double median = 0.0;
		// If size of data set is odd, the middle index is median index
		if (size % 2 != 0) {
			int medianIndex = (int) Math.ceil(size / 2.0);
			median = (double) numbers.get(medianIndex - 1);
		} else {
			// If size is even, the 2 middle elements are averaged to calculate median
			int medianIndex = (int) (size / 2);
			median = (double) (numbers.get(medianIndex - 1) + (double) numbers.get(medianIndex)) / 2.0;
		}
		
		return String.valueOf(median);
	}

	/**
	 * Calculates qth percentile of given set of numbers as String
	 * 
	 * @param numbers
	 * @param q
	 * @return
	 */
	public String calculateQthPercentile(List<Integer> numbers, int q) {
		if (q == 0)
			return null;
		double size = numbers.size();
		if (size == 0 || q > 100)
			throw new InputMismatchException("Invalid request arguments");
		
		Collections.sort(numbers);
		
		// Ordinal rank is the qth percent of the size
		double ordinalRank = size * q / 100;
		// Ordinal rank is rounded to next integer to get the percentile index 
		int percentileIndex = (int) Math.ceil(ordinalRank) - 1;
		
		return String.valueOf(numbers.get(percentileIndex));
	}

}
