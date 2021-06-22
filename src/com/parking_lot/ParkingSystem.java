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
	
	public int park(Car car) {
		
		if(isFull(map.size(), size)) {
			System.out.println("Sorry, parking lot is full");
			return -1;
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
		return map.size();
	}
	
	public int leave(int slotNumber) {
		if(map.containsKey(slotNumber)) {
			pQueue.add(slotNumber);
			map.remove(slotNumber);
			System.out.println("Slot Number " + slotNumber + " is free");
		}
		else {
			System.out.println("No car parked at slot " + slotNumber);
		}
		return map.size();
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
	
	public String registration_numbers_for_cars_with_colour(String color) {
		String string="";
		for(HashMap.Entry<Integer, Car> var : map.entrySet()) {
			Car car = var.getValue();
			if(car.getColor().equals(color)) {
				string+=car.getRegistrationNumber();
				string+=" ";
			}
		}
		System.out.println(string);
		return string;
	}
	
	public String slot_numbers_for_cars_with_colour(String color) {
		String string="";
		for(HashMap.Entry<Integer, Car> var : map.entrySet()) {
			Car car = var.getValue();
			if(car.getColor().equals(color)) {
				string+=String.valueOf(var.getKey());
				string+=" ";
			}
		}
		System.out.println(string);
		return string;
	}
	
	public String slot_number_for_registration_number(String registrationNumber) {
		for(HashMap.Entry<Integer, Car> var : map.entrySet()) {
			Car car = var.getValue();
			if(car.getRegistrationNumber().equals(registrationNumber)) {
				System.out.println(var.getKey());
				return String.valueOf(var.getKey());
			}
		}
		System.out.println("Not found");
		return "Not found";
	}
}
