package com.parking_lot;

public class Parking_Lot {

	int size;
	private ParkingSystem parkingSystem;
	
	public Parking_Lot(int size) {
		this.size = size;
		parkingSystem = new ParkingSystem(size);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parking_Lot parkingLot = new Parking_Lot(6);
		ParkingSystem parkingSystem = parkingLot.parkingSystem;
		parkingSystem.park(new Car("KA-01-HH-1234", "White"));
		parkingSystem.park(new Car("KA-01-HH-9999" ,"White"));
		parkingSystem.park(new Car("KA-01-BB-0001" ,"Black"));
		parkingSystem.park(new Car("KA-01-HH-7777" ,"Red"));
		parkingSystem.park(new Car("KA-01-HH-2701" ,"Blue"));
		parkingSystem.park(new Car("KA-01-HH-3141" ,"Black"));
		
		parkingSystem.leave(4);
		parkingSystem.status();
		parkingSystem.park(new Car("KA-01-P-333" ,"White"));
		parkingSystem.park(new Car("DL-12-AA-9999" ,"White"));
	}

}
