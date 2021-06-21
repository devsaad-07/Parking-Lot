package com.parking_lot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parking_Lot {

	int size;
	private static ParkingSystem parkingSystem;
	
	public Parking_Lot(int size) {
		this.size = size;
		parkingSystem = new ParkingSystem(size);
	}
	
	private static void handlerFunction(String input) {
		String[] tokens=input.split(" ");
		if(tokens[0].equals("park")) {
			parkingSystem.park(new Car(tokens[1], tokens[2]));
		}
		else if(tokens[0].equals("leave")) {
			parkingSystem.leave(Integer.valueOf(tokens[1]));
		}
		else if(tokens[0].equals("status")) {
			parkingSystem.status();
		}
		else if(tokens[0].equals("registration_numbers_for_cars_with_colour")) {
			parkingSystem.registration_numbers_for_cars_with_colour(tokens[1]);
		}
		else if(tokens[0].equals("slot_numbers_for_cars_with_colour")) {
			parkingSystem.slot_numbers_for_cars_with_colour(tokens[1]);
		}
		else if(tokens[0].equals("slot_number_for_registration_number")) {
			parkingSystem.slot_number_for_registration_number(tokens[1]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scanner;
		boolean flag = true;
		Parking_Lot parkingLot;
		
			if(args.length == 0) {
				scanner = new Scanner(System.in);
				String input = scanner.nextLine();
				while(!input.equals("quit")) {
					if(flag) {
		            	String[] tokens=input.split(" ");
		            	parkingLot = new Parking_Lot(Integer.valueOf(tokens[1]));
		            	flag=false;
		            	System.out.println("Created a parking lot with " + Integer.valueOf(tokens[1]) + " slots");
		            	input = scanner.nextLine();
		            	continue;
		            }
		            handlerFunction(input);
		            input = scanner.nextLine();
				}
				scanner.close();
			}
			else {
				try {
					scanner = new Scanner(new FileInputStream(args[0]));
					while (scanner.hasNextLine()) {
						String input = scanner.nextLine();
						if(flag) {
							String[] tokens=input.split(" ");
							parkingLot = new Parking_Lot(Integer.valueOf(tokens[1]));
							flag=false;
							continue;
						}
						handlerFunction(input);
					}
					scanner.close();
				}
		        catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		        }
			}
	}
}
