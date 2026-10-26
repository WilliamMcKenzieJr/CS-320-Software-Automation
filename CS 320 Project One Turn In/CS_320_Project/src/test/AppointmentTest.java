package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;

import java_main.Appointment;
import java_main.AppointmentService;

class AppointmentTest {

	@Test
	void testAppointment() {
		Date appointmentDate = new Date(System.currentTimeMillis() + 20000);
		
		Appointment appointment = new Appointment("123", appointmentDate, "This is an example description.");
		assertTrue(appointment.getAppointmentId().equals("123"));
		assertTrue(appointment.getAppointmentDate().equals(appointmentDate));
		assertTrue(appointment.getAppointmentDesc().equals("This is an example description."));
	}
	@Test
	void testAppointmentIdToLong() {
		Date appointmentDate = new Date(System.currentTimeMillis() + 20000);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234823948347932742974", appointmentDate, "This is an example description.");
		});
	}
	@Test
	void testAppointmentDescToLong() {
		Date appointmentDate = new Date(System.currentTimeMillis() + 20000);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123", appointmentDate, "This is an example description. 1232333483848477 57575664747464646466 464646646464646464664644 77363636473773747");
		});
	}
	@Test
	void testNullAppointmentId() {
		Date appointmentDate = new Date(System.currentTimeMillis() + 20000);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, appointmentDate, "This is an example description.");
		});
	}
	@Test
	void testNullAppointmentDate() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123", null, "This is an example description.");
		});
	}
	@Test
	void testNullAppointmentDesc() {
		Date appointmentDate = new Date(System.currentTimeMillis() + 20000);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123", appointmentDate, null);
		});
	}
	
	@Test
	void testPastAppointmentDate() {
		Date pastAppointmentDate = new Date(System.currentTimeMillis() - 20000);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123", pastAppointmentDate, "This is an example description.");
		});
	}
	
	
	
	
}

