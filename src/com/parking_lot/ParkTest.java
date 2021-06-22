package com.parking_lot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ParkTest {

	@Test
	public void test() {
		ParkingSystem parkingSystem = new ParkingSystem(3);
		
		assertEquals(1, parkingSystem.park(new Car("KA-01-HH-1234", "White")));
		assertEquals(2, parkingSystem.park(new Car("KA-01-HH-9999", "White")));
	}

}
