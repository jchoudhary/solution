package com.assignment.solution.controller;

import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.solution.math.Calculator;

/**
 * Details all Math related APIs
 * 
 * @author Jyoti
 *
 */
@RestController
public class MathController {
	
	@Autowired
	Calculator calculator;
	
	/**
	 * Accepts a json of number list in the format [n1,n2,n3...]
	 * q is a quantifier added as a path variable in format /min/q
	 * 
	 * @param q
	 * @param numbers
	 * @return q smallest numbers from the given set of numbers as a String
	 */
	@PostMapping("/min/{q}")
	ResponseEntity<String> getMinNumbers(@PathVariable int q, @RequestBody List<Integer> numbers) {
		String result = null;
		try {
		result = calculator.calculateMin(numbers, q);
		} catch(InputMismatchException ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
		
	}
	
	/**
	 * Accepts a json of number list in the format [n1,n2,n3...]
	 * q is a quantifier added as a path variable in format /max/q
	 *   
	 * @param q
	 * @param numbers
	 * @return q largest numbers from the given set of numbers as a String
	 */
	@PostMapping("/max/{q}")
	ResponseEntity<String> getMaxNumbers(@PathVariable int q, @RequestBody List<Integer> numbers) {
		String result = null;
		try {
		result = calculator.calculateMax(numbers, q);
		} catch(InputMismatchException ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
		
	}
	
	/**
	 * Accepts a json of number list in the format [n1,n2,n3...]
	 * 
	 * @param numbers
	 * @return average of given numbers as a String
	 */
	@PostMapping("/avg")
	ResponseEntity<String> getAverage(@RequestBody List<Integer> numbers) {
		String result = null;
		try {
		result = calculator.calculateAvg(numbers);
		} catch(InputMismatchException ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	/**
	 * Accepts a json of number list in the format [n1,n2,n3...]
	 * 
	 * @param numbers
	 * @return median of given numbers as a String
	 */
	@PostMapping("/median")
	ResponseEntity<String> getMedian(@RequestBody List<Integer> numbers) {
		String result = null;
		try {
		result = calculator.calculateMedian(numbers);
		} catch(InputMismatchException ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	/**
	 * Accepts a json of number list in the format [n1,n2,n3...]
	 * q is a quantifier added as a path variable in the format /percentile/q
	 * 
	 * @param q
	 * @param numbers
	 * @return qth percentile among given numbers
	 */
	@PostMapping("/percentile/{q}")
	ResponseEntity<String> getPercentile(@PathVariable int q, @RequestBody List<Integer> numbers) {
		String result = null;
		try {
		result = calculator.calculateQthPercentile(numbers, q);
		} catch(InputMismatchException ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

}
