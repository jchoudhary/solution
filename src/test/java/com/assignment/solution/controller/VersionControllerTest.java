package com.assignment.solution.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class VersionControllerTest {
	
	VersionController controller = new VersionController();
	
	@Test
	public void testCompareVersions() {
		
		assertEquals("-1", controller.compareVersions("0.1", "1.1").getBody());
		assertEquals(HttpStatus.OK, controller.compareVersions("0.1", "1.1").getStatusCode());
		assertEquals("1", controller.compareVersions("1.1", "0.1").getBody());
		assertEquals("-1", controller.compareVersions("1.1", "1.2").getBody());
		assertEquals("1", controller.compareVersions("1.2", "1.1").getBody());
		assertEquals("-1", controller.compareVersions("1.2", "1.2.9.9.9.9").getBody());
		assertEquals("-1", controller.compareVersions("1.2.9.9.9.9", "1.3").getBody());
		assertEquals("-1", controller.compareVersions("1.3", "1.3.4").getBody());
		assertEquals("-1", controller.compareVersions("1.3.4", "1.10").getBody());
		assertEquals("1", controller.compareVersions("1.10", "0.1").getBody());
		assertEquals("0", controller.compareVersions("1.10", "1.10").getBody());
	}
	
	@Test
	public void testCompareVersionsException() {
		
		assertEquals(HttpStatus.BAD_REQUEST, controller.compareVersions(null, null).getStatusCode());
		assertEquals(HttpStatus.BAD_REQUEST, controller.compareVersions("", "").getStatusCode());
		assertEquals(HttpStatus.BAD_REQUEST, controller.compareVersions(" ", " ").getStatusCode());
	}

}
