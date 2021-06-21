package com.parking_lot;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ParkingSystem {
	
	private Integer size;
	private PriorityQueue<Integer> pQueue;
	private HashMap<Integer, Car> map;
	
	public ParkingSystem(Integer size) {
		this.size = size;
		this.pQueue = new PriorityQueue<Integer>();
		this.map = new HashMap<>();
	}
	
	private boolean isFull(Integer count, Integer size) {
		if(count.equals(size)) {
			return true;
		}
		return false;
	}
	
	public void park(Car car) {
		
		if(isFull(map.size(), size)) {
			System.out.println("Sorry, parking lot is full");
			return;
		}
		
		int slotParked;
		if(pQueue.isEmpty()) {
			map.put(map.size()+1, car);
			slotParked=map.size();
		}
		else {
			slotParked=pQueue.poll();
			map.put(slotParked, car);
		}
		System.out.println("Allocated slot number: " + slotParked);
	}
	
	public void leave(int slotNumber) {
		if(map.containsKey(slotNumber)) {
			pQueue.add(slotNumber);
			map.remove(slotNumber);
			System.out.println("Slot Number " + slotNumber + " is free");
		}
		else {
			System.out.println("No car parked at slot " + slotNumber);
		}
		
	}
	
	public void status() {
		System.out.println("Slot No. Registration No Colour");
		for(HashMap.Entry<Integer, Car> var : map.entrySet()) {
			Car car = var.getValue();
			String registrationNumber = car.getRegistrationNumber();
			String color = car.getColor();
			System.out.println("    " + var.getKey() + "  " + registrationNumber + "  " + color);
		}
	}
	
	public void registration_numbers_for_cars_with_colour(String color) {
		for(HashMap.Entry<Integer, Car> var : map.entrySet()) {
			Car car = var.getValue();
			if(car.getColor().equals(color)) {
				System.out.print(car.getRegistrationNumber() + " ");
			}
		}
		System.out.println();
	}
	
	public void slot_numbers_for_cars_with_colour(String color) {
		for(HashMap.Entry<Integer, Car> var : map.entrySet()) {
			Car car = var.getValue();
			if(car.getColor().equals(color)) {
				System.out.print(var.getKey() + " ");
			}
		}
		System.out.println();
	}
	
	public void slot_number_for_registration_number(String registrationNumber) {
		for(HashMap.Entry<Integer, Car> var : map.entrySet()) {
			Car car = var.getValue();
			if(car.getRegistrationNumber().equals(registrationNumber)) {
				System.out.println(var.getKey());
				return;
			}
		}
		System.out.println("Not found");
	}
}
