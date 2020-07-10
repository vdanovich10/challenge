package com.mastercard.route.challenge;

import com.mastercard.route.challenge.service.RouteFinder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RouteMapTests {

	@Autowired
	private RouteFinder routeFinder;

	@Test
	void testPositiveRoute() {
		Assert.assertTrue(routeFinder.routeExists("Boston", "Newark").equals("Yes"));
	}

	@Test
	void testNegativeRoute() {
		Assert.assertTrue(routeFinder.routeExists("Philadelphia", "Albany").equals("No"));
	}

}
