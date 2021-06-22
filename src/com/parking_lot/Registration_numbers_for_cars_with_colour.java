package com.parking_lot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Registration_numbers_for_cars_with_colour_test {

	@Test
	void test() {
		ParkingSystem parkingSystem = new ParkingSystem(3);
		
		parkingSystem.park(new Car("KA-01-HH-1234", "White"));
		parkingSystem.park(new Car("KA-01-HH-9999", "White"));
		parkingSystem.park(new Car("KA-01-HH-9990", "Black"));
		
		assertEquals("KA-01-HH-1234 KA-01-HH-9999 ", parkingSystem.registration_numbers_for_cars_with_colour("White"));
	}

}
