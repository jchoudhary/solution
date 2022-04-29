package com.assignment.solution.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Details API to compare 2 versions
 * 
 * @author Jyoti
 *
 */
@RestController
public class VersionController {	
	
	/**
	 * Accepts 2 version strings as path variables in format /compare/v1,v2
	 * 
	 * @param version1
	 * @param version2
	 * @return 1 if version1 > version2
	 * 		  -1 if version2 > version1
	 * 		   0 if version1 = version2
	 */
	@GetMapping("/compare/{version1},{version2}")
	ResponseEntity<String> compareVersions(@PathVariable String version1, @PathVariable String version2) {
		
		// If any version is null, empty or blank, return 400, Bad Request
		if (!StringUtils.hasText(version1) || !StringUtils.hasText(version2))
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST); 
		
		// Split both versions using period (.) as a delimiter
		String[] arr1 = version1.split("\\.");
		String[] arr2 = version2.split("\\.");
		
		int minLimit = Math.min(arr1.length, arr2.length);
		
		int res = 0;
		
		// Iterate through both version arrays and evaluate the greater each part 
		// If a version has a part greater than the respective part of other version,
		// that is considered to be the greater version overall.
		for (int i = 0; i < minLimit; i++) {
			int v1 = Integer.parseInt(arr1[i]);
			int v2 = Integer.parseInt(arr2[i]);
			if (v1 > v2) {
				res = 1;
				break;
			}
			if (v2 > v1) {
				res = -1;
				break;
			}
		}
		
		// If both versions are unequal in length and equal upto the min length 
		// the version with greater length is considered greater
		if (res == 0) {
			if (arr1.length > arr2.length) res = 1;
			if (arr2.length > arr1.length) res = -1;
		}
		
		return new ResponseEntity<String>(String.valueOf(res), HttpStatus.OK);
	}
	
	
	
}
