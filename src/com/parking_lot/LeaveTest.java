package com.parking_lot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LeaveTest {

	@Test
	void test() {
		ParkingSystem parkingSystem = new ParkingSystem(3);
		
		parkingSystem.park(new Car("KA-01-HH-1234", "White"));
		parkingSystem.park(new Car("KA-01-HH-9999", "White"));
		parkingSystem.park(new Car("KA-01-HH-9990", "Black"));
		assertEquals(2, parkingSystem.leave(1));
	}

}
