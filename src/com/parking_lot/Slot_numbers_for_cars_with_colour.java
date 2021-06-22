package com.parking_lot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Slot_numbers_for_cars_with_colour {

	@Test
	void test() {
		ParkingSystem parkingSystem = new ParkingSystem(3);
		
		parkingSystem.park(new Car("KA-01-HH-1234", "White"));
		parkingSystem.park(new Car("KA-01-HH-9999", "White"));
		parkingSystem.park(new Car("KA-01-HH-9990", "Black"));
		
		assertEquals("1 2 ", parkingSystem.slot_numbers_for_cars_with_colour("White"));
	}

}
