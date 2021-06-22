package com.parking_lot;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ParkTest.class, LeaveTest.class, Registration_numbers_for_cars_with_colour_test.class, Slot_numbers_for_cars_with_colour.class, Slot_number_for_registration_number.class})
public class AllTests {

}
